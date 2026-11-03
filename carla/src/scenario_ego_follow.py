#!/usr/bin/env python3
"""
CARLA Scenario: Ego Vehicle Following Lead Vehicle
====================================================
Spawns two vehicles:
  1. Lead vehicle - moves in a straight line at constant speed
  2. Ego vehicle - automatically follows the lead vehicle maintaining distance

Duration: 1800 seconds with live position updates every 2 seconds
Output: Real-time actor positions for scene graph generation
"""

from __future__ import annotations

import glob
import math
import os
import random
import sys
import time

import os
import sys

# Auto-discover PythonAPI/carla directory containing the 'agents' folder
script_dir = os.path.dirname(os.path.abspath(__file__))
carla_api_root = None

# Search upward up to 5 directory levels for CARLA_0.9.16/PythonAPI/carla or agents
curr_dir = script_dir
for _ in range(5):
    candidate = os.path.join(curr_dir, "carla", "CARLA_0.9.16", "PythonAPI", "carla")
    if os.path.isdir(os.path.join(candidate, "agents")):
        carla_api_root = candidate
        break
    
    # Alternative check if running directly inside workspace
    candidate_alt = os.path.join(curr_dir, "CARLA_0.9.16", "PythonAPI", "carla")
    if os.path.isdir(os.path.join(candidate_alt, "agents")):
        carla_api_root = candidate_alt
        break
        
    curr_dir = os.path.dirname(curr_dir)

if carla_api_root and carla_api_root not in sys.path:
    sys.path.insert(0, carla_api_root)

import carla
from agents.navigation.controller import VehiclePIDController


def clamp(value, minimum, maximum):
    return max(minimum, min(maximum, value))


def limit_steer_rate(control, previous_steer, max_delta):
    control.steer = clamp(control.steer, previous_steer - max_delta, previous_steer + max_delta)
    return control


def spawn_behind(transform, distance_meters):
    forward_vector = transform.get_forward_vector()
    location = carla.Location(
        x=transform.location.x - forward_vector.x * distance_meters,
        y=transform.location.y - forward_vector.y * distance_meters,
        z=transform.location.z + 0.5,
    )
    return carla.Transform(location, transform.rotation)


def spawn_ahead(transform, distance_meters):
    forward_vector = transform.get_forward_vector()
    location = carla.Location(
        x=transform.location.x + forward_vector.x * distance_meters,
        y=transform.location.y + forward_vector.y * distance_meters,
        z=transform.location.z + 0.5,
    )
    return carla.Transform(location, transform.rotation)


def choose_straight_successor(waypoint, lookahead_meters):
    options = waypoint.next(lookahead_meters)
    if not options:
        return None

    base_yaw = waypoint.transform.rotation.yaw

    def yaw_delta(candidate):
        delta = (candidate.transform.rotation.yaw - base_yaw + 180.0) % 360.0 - 180.0
        return abs(delta)

    return min(options, key=yaw_delta)


def build_follow_camera_transform(vehicle_transform, follow_distance=4.0, height=4.6, pitch=30.0):
    """Place spectator behind and above a vehicle, aligned with its heading."""
    forward_vector = vehicle_transform.get_forward_vector()
    camera_location = carla.Location(
        x=vehicle_transform.location.x - forward_vector.x * follow_distance,
        y=vehicle_transform.location.y - forward_vector.y * follow_distance,
        z=vehicle_transform.location.z + height,
    )
    camera_rotation = carla.Rotation(
        pitch=pitch,
        yaw=vehicle_transform.rotation.yaw,
        roll=0.0,
    )
    return carla.Transform(camera_location, camera_rotation)


def lerp(a, b, alpha):
    return a + (b - a) * alpha


def lerp_angle_deg(current, target, alpha):
    delta = (target - current + 180.0) % 360.0 - 180.0
    return current + delta * alpha


def smooth_transform(current_transform, target_transform, alpha):
    """Blend toward target transform to reduce spectator jitter/snap."""
    return carla.Transform(
        carla.Location(
            x=lerp(current_transform.location.x, target_transform.location.x, alpha),
            y=lerp(current_transform.location.y, target_transform.location.y, alpha),
            z=lerp(current_transform.location.z, target_transform.location.z, alpha),
        ),
        carla.Rotation(
            pitch=lerp_angle_deg(current_transform.rotation.pitch, target_transform.rotation.pitch, alpha),
            yaw=lerp_angle_deg(current_transform.rotation.yaw, target_transform.rotation.yaw, alpha),
            roll=lerp_angle_deg(current_transform.rotation.roll, target_transform.rotation.roll, alpha),
        ),
    )


def pan_back_from_transform(transform, back_meters=3.0, raise_meters=0.0, pitch_delta=0.0):
    """Return a new transform panned back from `transform` by `back_meters`.

    This offsets the spectator slightly behind an attached follow camera
    so a vehicle's front-mounted camera or hood becomes visible.
    """
    forward_vector = transform.get_forward_vector()
    location = carla.Location(
        x=transform.location.x - forward_vector.x * back_meters,
        y=transform.location.y - forward_vector.y * back_meters,
        z=transform.location.z + raise_meters,
    )
    rotation = carla.Rotation(
        pitch=transform.rotation.pitch + pitch_delta,
        yaw=transform.rotation.yaw,
        roll=transform.rotation.roll,
    )
    return carla.Transform(location, rotation)


CONTROL_DT = 0.1


def pace_loop_with_camera_updates(
    loop_wall_start,
    sim_dt,
    spectator,
    follow_camera,
    ego_vehicle,
    camera_transform,
    camera_smoothing,
):
    """Pace loop timing while continuously refreshing spectator movement."""
    elapsed = time.perf_counter() - loop_wall_start
    remaining = sim_dt - elapsed
    if remaining <= 0.0:
        return camera_transform

    update_hz = 60.0
    update_period = 1.0 / update_hz
    end_time = time.perf_counter() + remaining

    while True:
        now = time.perf_counter()
        if now >= end_time:
            break

        if follow_camera is not None and follow_camera.is_alive:
            # Smooth toward a panned-back target based on the attached camera
            # so rapid internal spring-arm adjustments don't cause visible jitter.
            camera_target = pan_back_from_transform(
                follow_camera.get_transform(),
                back_meters=4.0,
                raise_meters=-1.0,
                pitch_delta=22.0,
            )
            camera_transform = smooth_transform(camera_transform, camera_target, min(0.12, camera_smoothing))
            spectator.set_transform(camera_transform)
        else:
            ego_transform = ego_vehicle.get_transform()
            camera_target = build_follow_camera_transform(ego_transform)
            # Use a gentler per-refresh alpha because this runs much faster than control updates.
            camera_transform = smooth_transform(camera_transform, camera_target, min(0.12, camera_smoothing))
            spectator.set_transform(camera_transform)

        time.sleep(min(update_period, max(0.0, end_time - now)))

    return camera_transform

def main():
    # Connect to CARLA
    client = carla.Client('127.0.0.1', 2000)
    client.set_timeout(10.0)
    world = client.get_world()
    original_settings = world.get_settings()
    sync_settings = world.get_settings()
    sync_settings.synchronous_mode = False
    world.apply_settings(sync_settings)
    tm = client.get_trafficmanager(8000)
    tm.set_synchronous_mode(False)
    tm.set_global_distance_to_leading_vehicle(0.5)
    
    print("=" * 70)
    print("CARLA Scenario: Ego Vehicle Following Lead Vehicle")
    print("=" * 70)
    print()
    
    # Get available vehicle blueprints
    bp_lib = world.get_blueprint_library()
    vehicle_bps = bp_lib.filter('vehicle.*')
    
    # Get spawn points
    spawn_points = world.get_map().get_spawn_points()
    if len(spawn_points) < 2:
        print("ERROR: Not enough spawn points!")
        return
    
    # Spawn ego vehicle first, then spawn lead vehicle ahead of ego.
    ego_bp = vehicle_bps[0]
    if ego_bp.has_attribute('role_name'):
        ego_bp.set_attribute('role_name', 'ego')

    ego_spawn = spawn_points[0]
    ego_vehicle = world.try_spawn_actor(ego_bp, ego_spawn)
    if ego_vehicle is None:
        print("ERROR: Could not spawn ego vehicle")
        return

    lead_bp = vehicle_bps[1]
    if lead_bp.has_attribute('role_name'):
        lead_bp.set_attribute('role_name', 'lead')

    lead_vehicle = None
    lead_spawn = None
    for gap in (10.0, 8.0, 6.0, 4.0):
        candidate_spawn = spawn_ahead(ego_spawn, gap)
        lead_vehicle = world.try_spawn_actor(lead_bp, candidate_spawn)
        if lead_vehicle is not None:
            lead_spawn = candidate_spawn
            print(f"  Spawned lead {gap:.1f} m ahead of ego")
            break
    if lead_vehicle is None:
        print("ERROR: Could not spawn lead vehicle ahead of ego")
        ego_vehicle.destroy()
        return

    lead_vehicle.set_autopilot(False)
    lead_controller = VehiclePIDController(
        lead_vehicle,
        args_lateral={"K_P": 0.80, "K_I": 0.0, "K_D": 0.24, "dt": CONTROL_DT},
        args_longitudinal={"K_P": 1.25, "K_I": 0.05, "K_D": 0.16, "dt": CONTROL_DT},
        max_throttle=1.00,
        max_brake=0.9,
        max_steering=0.45,
    )
    world_map = world.get_map()
    assert lead_spawn is not None
    lead_waypoint = world_map.get_waypoint(
        lead_spawn.location,
        project_to_road=True,
        lane_type=carla.LaneType.Driving,
    )
    lead_target_waypoint = None if lead_waypoint is None else choose_straight_successor(lead_waypoint, 10.0)
    lead_target_speed_kmh = 24.0
    print(f"✓ Spawned ego vehicle: {ego_bp.id} (role_name: ego)")
    print(f"  Position: ({ego_spawn.location.x:.1f}, {ego_spawn.location.y:.1f}, {ego_spawn.location.z:.1f})")
    print(f"✓ Spawned lead vehicle: {lead_bp.id} (role_name: lead)")
    print(f"  Position: ({lead_spawn.location.x:.1f}, {lead_spawn.location.y:.1f}, {lead_spawn.location.z:.1f})")
    print("  Lead behavior: straight-priority waypoint tracking with random accel/brake")

    ego_vehicle.set_autopilot(False)
    assert ego_spawn is not None
    ego_controller = VehiclePIDController(
        ego_vehicle,
        args_lateral={"K_P": 0.72, "K_I": 0.0, "K_D": 0.28, "dt": CONTROL_DT},
        args_longitudinal={"K_P": 1.10, "K_I": 0.06, "K_D": 0.22, "dt": CONTROL_DT},
        max_throttle=0.95,
        max_brake=0.75,
        max_steering=0.45,
    )
    print("  Following distance target: random 5.0-12.0 m")
    print("  Camera target: ego vehicle (1st spawned)")
    print()

    spectator = world.get_spectator()
    camera_transform = build_follow_camera_transform(ego_vehicle.get_transform())
    spectator.set_transform(camera_transform)
    follow_camera = None
    camera_mount = carla.Transform(carla.Location(x=-4.0, z=4.6), carla.Rotation(pitch=30.0))
    try:
        camera_bp = bp_lib.find("sensor.camera.rgb")
        camera_bp.set_attribute("sensor_tick", "0.0")
        camera_bp.set_attribute("image_size_x", "640")
        camera_bp.set_attribute("image_size_y", "360")
        camera_bp.set_attribute("fov", "110")
        follow_camera = world.spawn_actor(
            camera_bp,
            camera_mount,
            attach_to=ego_vehicle,
            attachment_type=carla.AttachmentType.SpringArmGhost,
        )
        # Start from a zoomed-out, pitched-back spectator view so the front
        # vehicle stays visible, then smooth future updates to avoid flicker.
        camera_transform = pan_back_from_transform(
            follow_camera.get_transform(),
            back_meters=4.0,
            raise_meters=-1.0,
            pitch_delta=22.0,
        )
        spectator.set_transform(camera_transform)
        print("  Camera mode: SpringArmGhost attached follow camera")
    except RuntimeError as exc:
        print(f"  Camera sensor attach failed ({exc}); using smoothed spectator fallback")
    
    print("Running scenario for 1800 seconds...")
    print("Applying PID control in asynchronous mode (real-time paced), printing status every 2 seconds")
    print("-" * 70)
    print()
    
    try:
        start_time = time.time()
        status_interval = 2.0
        next_status_time = start_time
        camera_smoothing = 0.5
        sim_dt = CONTROL_DT
        lead_cruise_speed_kmh = 24.0
        lead_speed_variation_kmh = 0.0
        next_lead_speed_change_time = start_time
        lead_brake_until_time = 0.0
        next_lead_brake_window_time = start_time + random.uniform(4.0, 8.0)
        follow_distance = random.uniform(4.0, 11.0)
        follow_distance_speed_gain = 2.0
        next_follow_distance_change_time = start_time + random.uniform(2.0, 5.0)
        lead_prev_steer = 0.0
        ego_prev_steer = 0.0
        steer_delta_limit = 0.06
        
        while time.time() - start_time < 1800:
            loop_wall_start = time.perf_counter()
            loop_now = time.time()

            if loop_now >= next_follow_distance_change_time:
                follow_distance = random.uniform(4.0, 11.0)
                next_follow_distance_change_time = loop_now + random.uniform(2.0, 5.0)

            if loop_now >= next_lead_speed_change_time:
                lead_speed_variation_kmh = random.uniform(-6.0, 6.0)
                next_lead_speed_change_time = loop_now + random.uniform(1.5, 3.8)

            if loop_now >= next_lead_brake_window_time:
                if random.random() < 0.60:
                    lead_brake_until_time = loop_now + random.uniform(0.4, 1.4)
                next_lead_brake_window_time = loop_now + random.uniform(2.8, 6.2)

            if loop_now < lead_brake_until_time:
                lead_target_speed_kmh = 0.0
            else:
                lead_target_speed_kmh = clamp(lead_cruise_speed_kmh + lead_speed_variation_kmh, 10.0, 30.0)
            
            # Advance lead vehicle along the straightest available branch.
            lead_location = lead_vehicle.get_location()
            if lead_target_waypoint is not None and lead_location.distance(lead_target_waypoint.transform.location) < 5.0:
                lead_waypoint = lead_target_waypoint
                lead_target_waypoint = choose_straight_successor(lead_waypoint, 10.0)

            if lead_target_waypoint is not None:
                lead_control = lead_controller.run_step(lead_target_speed_kmh, lead_target_waypoint)
            else:
                lead_control = carla.VehicleControl(throttle=0.0, steer=0.0, brake=0.25)
            lead_control = limit_steer_rate(lead_control, lead_prev_steer, steer_delta_limit)
            lead_prev_steer = lead_control.steer
            lead_vehicle.apply_control(lead_control)

            # Get current positions
            lead_transform = lead_vehicle.get_transform()
            ego_transform = ego_vehicle.get_transform()
            if follow_camera is not None and follow_camera.is_alive:
                camera_target = pan_back_from_transform(
                    follow_camera.get_transform(),
                    back_meters=4.0,
                    raise_meters=-1.0,
                    pitch_delta=22.0,
                )
                camera_transform = smooth_transform(camera_transform, camera_target, min(0.18, camera_smoothing))
                spectator.set_transform(camera_transform)
            else:
                camera_target = build_follow_camera_transform(ego_transform)
                camera_transform = smooth_transform(camera_transform, camera_target, camera_smoothing)
                spectator.set_transform(camera_transform)
            lead_pos = lead_transform.location
            ego_pos = ego_transform.location
            lead_vel = lead_vehicle.get_velocity()
            ego_vel = ego_vehicle.get_velocity()
            
            # Calculate distances
            dx = ego_pos.x - lead_pos.x
            dy = ego_pos.y - lead_pos.y
            distance = math.sqrt(dx**2 + dy**2)

            # Track a waypoint behind the lead vehicle to keep a safe following gap.
            target_transform = spawn_behind(lead_transform, follow_distance)
            target_waypoint = world_map.get_waypoint(target_transform.location, project_to_road=True, lane_type=carla.LaneType.Driving)
            if target_waypoint is None:
                target_waypoint = world_map.get_waypoint(lead_transform.location, project_to_road=True, lane_type=carla.LaneType.Driving)
            if target_waypoint is None:
                world.wait_for_tick()
                camera_transform = pace_loop_with_camera_updates(
                    loop_wall_start,
                    sim_dt,
                    spectator,
                    follow_camera,
                    ego_vehicle,
                    camera_transform,
                    camera_smoothing,
                )
                continue

            preview_waypoint = choose_straight_successor(target_waypoint, 4.0)
            tracking_waypoint = target_waypoint if preview_waypoint is None else preview_waypoint

            lead_speed = math.sqrt(lead_vel.x**2 + lead_vel.y**2 + lead_vel.z**2)
            lead_speed_kmh = lead_speed * 3.6
            distance_error = distance - follow_distance
            target_speed_kmh = lead_speed_kmh + follow_distance_speed_gain * distance_error

            control = ego_controller.run_step(target_speed_kmh, tracking_waypoint)
            control = limit_steer_rate(control, ego_prev_steer, steer_delta_limit)
            ego_prev_steer = control.steer
            ego_vehicle.apply_control(control)

            ego_speed = math.sqrt(ego_vel.x**2 + ego_vel.y**2 + ego_vel.z**2)

            now = time.time()
            if now >= next_status_time:
                print(f"Time: {now - start_time:.1f}s")
                print(f"  Lead Vehicle (straight-priority PID):")
                print(f"    pos:   ({lead_pos.x:7.1f}, {lead_pos.y:7.1f}, {lead_pos.z:6.1f})")
                print(f"    speed: {lead_speed:6.2f} m/s")
                print(f"  Ego Vehicle (PID controller):")
                print(f"    pos:   ({ego_pos.x:7.1f}, {ego_pos.y:7.1f}, {ego_pos.z:6.1f})")
                print(f"    speed: {ego_speed:6.2f} m/s")
                print(f"  Target follow distance: {follow_distance:4.1f} m")
                print(f"  Distance between vehicles: {distance:6.2f} m")
                print(f"  Control: throttle={control.throttle:4.2f} steer={control.steer:5.2f} brake={control.brake:4.2f}")
                print()
                next_status_time = now + status_interval

            world.wait_for_tick()
            camera_transform = pace_loop_with_camera_updates(
                loop_wall_start,
                sim_dt,
                spectator,
                follow_camera,
                ego_vehicle,
                camera_transform,
                camera_smoothing,
            )
        
        print("-" * 70)
        print("✓ Scenario complete! Vehicles still alive for scene graph export...")
        print()
        
        # Keep vehicles alive for scene export
        print("Keeping vehicles alive for 10 more seconds (for scene export)...")
        time.sleep(10)
        
    except KeyboardInterrupt:
        print("\n\nScenario interrupted by user")
    
    finally:
        # Cleanup
        print("\nCleaning up...")
        if follow_camera is not None and follow_camera.is_alive:
            follow_camera.destroy()
        if lead_vehicle.is_alive:
            lead_vehicle.destroy()
        if ego_vehicle.is_alive:
            ego_vehicle.destroy()
        tm.set_synchronous_mode(False)
        world.apply_settings(original_settings)
        print("✓ Vehicles destroyed")

if __name__ == "__main__":
    main()
