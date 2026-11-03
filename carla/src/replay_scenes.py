#!/usr/bin/env python3
"""Replays recorded scenes over ZeroMQ, at the pace they were recorded.

Reads a JSON lines file of scenes, as scenario_evaluation.py writes them with
--out, and sends each scene the way scenario_evaluation.py --publish does. Each
scene goes out as long after the first scene as it did in the recording, with
a new timestamp, so the subscriber measures latency from the replay.

Typical usage example:

  python replay_scenes.py a-10-1-incremental.jsonl.gz
  python replay_scenes.py a-10-1-incremental.jsonl.gz --publish tcp://*:5557
"""

from __future__ import annotations

import argparse
import gzip
import json
import time
from datetime import datetime, timezone

import zmq


def parse_args():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "scenes", help="JSON lines file of scenes, gzipped if it ends in .gz"
    )
    parser.add_argument(
        "--publish",
        default="tcp://*:5556",
        help="ZeroMQ PUB endpoint to send each scene to",
    )
    return parser.parse_args()


def main():
    args = parse_args()
    opener = gzip.open if args.scenes.endswith(".gz") else open
    with opener(args.scenes, "rt", encoding="utf-8") as f:
        scenes = [json.loads(line) for line in f]
    first = datetime.fromisoformat(scenes[0]["timestamp"])
    offsets = [
        (datetime.fromisoformat(scene["timestamp"]) - first).total_seconds()
        for scene in scenes
    ]
    print(
        f"[replay] {len(scenes)} scenes over {offsets[-1]:.1f} s from "
        f"{args.scenes}",
        flush=True,
    )
    context = zmq.Context()
    publisher = context.socket(zmq.PUB)
    # Queues at most 16 scenes for a slow subscriber, as carla2ecore's publisher does.
    publisher.setsockopt(zmq.SNDHWM, 16)
    publisher.bind(args.publish)
    # Gives the subscriber time to connect, since PUB drops what it sends
    # before then.
    time.sleep(2.0)
    try:
        start = time.perf_counter()
        for scene, offset in zip(scenes, offsets):
            time.sleep(max(0.0, start + offset - time.perf_counter()))
            scene["timestamp"] = datetime.now(timezone.utc).isoformat()
            publisher.send_string(json.dumps(scene, separators=(",", ":")))
    finally:
        # Gives scenes still queued for a slow subscriber 5 s to go out.
        publisher.close(linger=5000)
        context.term()
    print(f"[replay] sent {len(scenes)} scenes", flush=True)
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
