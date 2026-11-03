/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedPatternGroup;

/**
 * A pattern group formed of all public patterns defined in scenegraph.vql.
 * 
 * <p>Use the static instance as any {@link interface org.eclipse.viatra.query.runtime.api.IQueryGroup}, to conveniently prepare
 * a VIATRA Query engine for matching all patterns originally defined in file scenegraph.vql,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package ca.mcmaster.mt4sg.queries, the group contains the definition of the following patterns: <ul>
 * <li>vehiclesInASceneGraph</li>
 * <li>distanceEdgeExists</li>
 * <li>spatialEdgeExists</li>
 * <li>vehicleIsInLaneSegmentEdgeExists</li>
 * <li>longitudinalRSSViolationEdgeExists</li>
 * <li>lateralRSSViolationEdgeExists</li>
 * <li>distanceEdgeValue</li>
 * <li>spatialEdgeValue</li>
 * <li>angleFromTo</li>
 * <li>squaredDistance</li>
 * <li>preCollision</li>
 * <li>superNear</li>
 * <li>veryNear</li>
 * <li>near</li>
 * <li>visibleDistance</li>
 * <li>distanceEdgeToBeRemoved</li>
 * <li>preCollisionEdgeToBeAdded</li>
 * <li>superNearEdgeToBeAdded</li>
 * <li>veryNearEdgeToBeAdded</li>
 * <li>nearEdgeToBeAdded</li>
 * <li>visibleDistanceEdgeToBeAdded</li>
 * <li>isPreCollisionLabel</li>
 * <li>isSuperNearLabel</li>
 * <li>isVeryNearLabel</li>
 * <li>isNearLabel</li>
 * <li>isVisibleLabel</li>
 * <li>updatePreCollision</li>
 * <li>updateSuperNear</li>
 * <li>updateVeryNear</li>
 * <li>updateNear</li>
 * <li>updateVisibleDistance</li>
 * <li>left</li>
 * <li>frontLeft</li>
 * <li>front</li>
 * <li>frontRight</li>
 * <li>right</li>
 * <li>rearRight</li>
 * <li>rear</li>
 * <li>rearLeft</li>
 * <li>leftEdgeToBeAdded</li>
 * <li>frontLeftEdgeToBeAdded</li>
 * <li>frontEdgeToBeAdded</li>
 * <li>frontRightEdgeToBeAdded</li>
 * <li>rightEdgeToBeAdded</li>
 * <li>rearRightEdgeToBeAdded</li>
 * <li>rearEdgeToBeAdded</li>
 * <li>rearLeftEdgeToBeAdded</li>
 * <li>updateLeft</li>
 * <li>updateFrontLeft</li>
 * <li>updateFront</li>
 * <li>updateFrontRight</li>
 * <li>updateRight</li>
 * <li>updateRearRight</li>
 * <li>updateRear</li>
 * <li>updateRearLeft</li>
 * <li>vehicleOnLaneSegment</li>
 * <li>vehicleOnLaneSegmentEdgeToBeAdded</li>
 * <li>vehicleOnLaneSegmentEdgeToBeRemoved</li>
 * <li>vLongitudinal</li>
 * <li>vLateral</li>
 * <li>isLeftSector</li>
 * <li>isFrontLeftSector</li>
 * <li>isFrontSector</li>
 * <li>isFrontRightSector</li>
 * <li>isRightSector</li>
 * <li>isRearRightSector</li>
 * <li>isRearSector</li>
 * <li>isRearLeftSector</li>
 * <li>isFrontGroupSector</li>
 * <li>isLeftGroupSector</li>
 * <li>isRightGroupSector</li>
 * <li>longitudinalRSSViolation</li>
 * <li>longitudinalRSSViolationEdgeToBeAdded</li>
 * <li>longitudinalRSSViolationEdgeToBeRemoved</li>
 * <li>lateralRSSViolation</li>
 * <li>lateralRSSViolationEdgeToBeAdded</li>
 * <li>lateralRSSViolationEdgeToBeRemoved</li>
 * </ul>
 * 
 * @see IQueryGroup
 * 
 */
@SuppressWarnings("all")
public final class Scenegraph extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws ViatraQueryRuntimeException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Scenegraph instance() {
    if (INSTANCE == null) {
        INSTANCE = new Scenegraph();
    }
    return INSTANCE;
  }

  private static Scenegraph INSTANCE;

  private Scenegraph() {
    querySpecifications.add(VehiclesInASceneGraph.instance());
    querySpecifications.add(DistanceEdgeExists.instance());
    querySpecifications.add(SpatialEdgeExists.instance());
    querySpecifications.add(VehicleIsInLaneSegmentEdgeExists.instance());
    querySpecifications.add(LongitudinalRSSViolationEdgeExists.instance());
    querySpecifications.add(LateralRSSViolationEdgeExists.instance());
    querySpecifications.add(DistanceEdgeValue.instance());
    querySpecifications.add(SpatialEdgeValue.instance());
    querySpecifications.add(AngleFromTo.instance());
    querySpecifications.add(SquaredDistance.instance());
    querySpecifications.add(PreCollision.instance());
    querySpecifications.add(SuperNear.instance());
    querySpecifications.add(VeryNear.instance());
    querySpecifications.add(Near.instance());
    querySpecifications.add(VisibleDistance.instance());
    querySpecifications.add(DistanceEdgeToBeRemoved.instance());
    querySpecifications.add(PreCollisionEdgeToBeAdded.instance());
    querySpecifications.add(SuperNearEdgeToBeAdded.instance());
    querySpecifications.add(VeryNearEdgeToBeAdded.instance());
    querySpecifications.add(NearEdgeToBeAdded.instance());
    querySpecifications.add(VisibleDistanceEdgeToBeAdded.instance());
    querySpecifications.add(IsPreCollisionLabel.instance());
    querySpecifications.add(IsSuperNearLabel.instance());
    querySpecifications.add(IsVeryNearLabel.instance());
    querySpecifications.add(IsNearLabel.instance());
    querySpecifications.add(IsVisibleLabel.instance());
    querySpecifications.add(UpdatePreCollision.instance());
    querySpecifications.add(UpdateSuperNear.instance());
    querySpecifications.add(UpdateVeryNear.instance());
    querySpecifications.add(UpdateNear.instance());
    querySpecifications.add(UpdateVisibleDistance.instance());
    querySpecifications.add(Left.instance());
    querySpecifications.add(FrontLeft.instance());
    querySpecifications.add(Front.instance());
    querySpecifications.add(FrontRight.instance());
    querySpecifications.add(Right.instance());
    querySpecifications.add(RearRight.instance());
    querySpecifications.add(Rear.instance());
    querySpecifications.add(RearLeft.instance());
    querySpecifications.add(LeftEdgeToBeAdded.instance());
    querySpecifications.add(FrontLeftEdgeToBeAdded.instance());
    querySpecifications.add(FrontEdgeToBeAdded.instance());
    querySpecifications.add(FrontRightEdgeToBeAdded.instance());
    querySpecifications.add(RightEdgeToBeAdded.instance());
    querySpecifications.add(RearRightEdgeToBeAdded.instance());
    querySpecifications.add(RearEdgeToBeAdded.instance());
    querySpecifications.add(RearLeftEdgeToBeAdded.instance());
    querySpecifications.add(UpdateLeft.instance());
    querySpecifications.add(UpdateFrontLeft.instance());
    querySpecifications.add(UpdateFront.instance());
    querySpecifications.add(UpdateFrontRight.instance());
    querySpecifications.add(UpdateRight.instance());
    querySpecifications.add(UpdateRearRight.instance());
    querySpecifications.add(UpdateRear.instance());
    querySpecifications.add(UpdateRearLeft.instance());
    querySpecifications.add(VehicleOnLaneSegment.instance());
    querySpecifications.add(VehicleOnLaneSegmentEdgeToBeAdded.instance());
    querySpecifications.add(VehicleOnLaneSegmentEdgeToBeRemoved.instance());
    querySpecifications.add(VLongitudinal.instance());
    querySpecifications.add(VLateral.instance());
    querySpecifications.add(IsLeftSector.instance());
    querySpecifications.add(IsFrontLeftSector.instance());
    querySpecifications.add(IsFrontSector.instance());
    querySpecifications.add(IsFrontRightSector.instance());
    querySpecifications.add(IsRightSector.instance());
    querySpecifications.add(IsRearRightSector.instance());
    querySpecifications.add(IsRearSector.instance());
    querySpecifications.add(IsRearLeftSector.instance());
    querySpecifications.add(IsFrontGroupSector.instance());
    querySpecifications.add(IsLeftGroupSector.instance());
    querySpecifications.add(IsRightGroupSector.instance());
    querySpecifications.add(LongitudinalRSSViolation.instance());
    querySpecifications.add(LongitudinalRSSViolationEdgeToBeAdded.instance());
    querySpecifications.add(LongitudinalRSSViolationEdgeToBeRemoved.instance());
    querySpecifications.add(LateralRSSViolation.instance());
    querySpecifications.add(LateralRSSViolationEdgeToBeAdded.instance());
    querySpecifications.add(LateralRSSViolationEdgeToBeRemoved.instance());
  }

  public VehiclesInASceneGraph getVehiclesInASceneGraph() {
    return VehiclesInASceneGraph.instance();
  }

  public VehiclesInASceneGraph.Matcher getVehiclesInASceneGraph(final ViatraQueryEngine engine) {
    return VehiclesInASceneGraph.Matcher.on(engine);
  }

  public DistanceEdgeExists getDistanceEdgeExists() {
    return DistanceEdgeExists.instance();
  }

  public DistanceEdgeExists.Matcher getDistanceEdgeExists(final ViatraQueryEngine engine) {
    return DistanceEdgeExists.Matcher.on(engine);
  }

  public SpatialEdgeExists getSpatialEdgeExists() {
    return SpatialEdgeExists.instance();
  }

  public SpatialEdgeExists.Matcher getSpatialEdgeExists(final ViatraQueryEngine engine) {
    return SpatialEdgeExists.Matcher.on(engine);
  }

  public VehicleIsInLaneSegmentEdgeExists getVehicleIsInLaneSegmentEdgeExists() {
    return VehicleIsInLaneSegmentEdgeExists.instance();
  }

  public VehicleIsInLaneSegmentEdgeExists.Matcher getVehicleIsInLaneSegmentEdgeExists(final ViatraQueryEngine engine) {
    return VehicleIsInLaneSegmentEdgeExists.Matcher.on(engine);
  }

  public LongitudinalRSSViolationEdgeExists getLongitudinalRSSViolationEdgeExists() {
    return LongitudinalRSSViolationEdgeExists.instance();
  }

  public LongitudinalRSSViolationEdgeExists.Matcher getLongitudinalRSSViolationEdgeExists(final ViatraQueryEngine engine) {
    return LongitudinalRSSViolationEdgeExists.Matcher.on(engine);
  }

  public LateralRSSViolationEdgeExists getLateralRSSViolationEdgeExists() {
    return LateralRSSViolationEdgeExists.instance();
  }

  public LateralRSSViolationEdgeExists.Matcher getLateralRSSViolationEdgeExists(final ViatraQueryEngine engine) {
    return LateralRSSViolationEdgeExists.Matcher.on(engine);
  }

  public DistanceEdgeValue getDistanceEdgeValue() {
    return DistanceEdgeValue.instance();
  }

  public DistanceEdgeValue.Matcher getDistanceEdgeValue(final ViatraQueryEngine engine) {
    return DistanceEdgeValue.Matcher.on(engine);
  }

  public SpatialEdgeValue getSpatialEdgeValue() {
    return SpatialEdgeValue.instance();
  }

  public SpatialEdgeValue.Matcher getSpatialEdgeValue(final ViatraQueryEngine engine) {
    return SpatialEdgeValue.Matcher.on(engine);
  }

  public AngleFromTo getAngleFromTo() {
    return AngleFromTo.instance();
  }

  public AngleFromTo.Matcher getAngleFromTo(final ViatraQueryEngine engine) {
    return AngleFromTo.Matcher.on(engine);
  }

  public SquaredDistance getSquaredDistance() {
    return SquaredDistance.instance();
  }

  public SquaredDistance.Matcher getSquaredDistance(final ViatraQueryEngine engine) {
    return SquaredDistance.Matcher.on(engine);
  }

  public PreCollision getPreCollision() {
    return PreCollision.instance();
  }

  public PreCollision.Matcher getPreCollision(final ViatraQueryEngine engine) {
    return PreCollision.Matcher.on(engine);
  }

  public SuperNear getSuperNear() {
    return SuperNear.instance();
  }

  public SuperNear.Matcher getSuperNear(final ViatraQueryEngine engine) {
    return SuperNear.Matcher.on(engine);
  }

  public VeryNear getVeryNear() {
    return VeryNear.instance();
  }

  public VeryNear.Matcher getVeryNear(final ViatraQueryEngine engine) {
    return VeryNear.Matcher.on(engine);
  }

  public Near getNear() {
    return Near.instance();
  }

  public Near.Matcher getNear(final ViatraQueryEngine engine) {
    return Near.Matcher.on(engine);
  }

  public VisibleDistance getVisibleDistance() {
    return VisibleDistance.instance();
  }

  public VisibleDistance.Matcher getVisibleDistance(final ViatraQueryEngine engine) {
    return VisibleDistance.Matcher.on(engine);
  }

  public DistanceEdgeToBeRemoved getDistanceEdgeToBeRemoved() {
    return DistanceEdgeToBeRemoved.instance();
  }

  public DistanceEdgeToBeRemoved.Matcher getDistanceEdgeToBeRemoved(final ViatraQueryEngine engine) {
    return DistanceEdgeToBeRemoved.Matcher.on(engine);
  }

  public PreCollisionEdgeToBeAdded getPreCollisionEdgeToBeAdded() {
    return PreCollisionEdgeToBeAdded.instance();
  }

  public PreCollisionEdgeToBeAdded.Matcher getPreCollisionEdgeToBeAdded(final ViatraQueryEngine engine) {
    return PreCollisionEdgeToBeAdded.Matcher.on(engine);
  }

  public SuperNearEdgeToBeAdded getSuperNearEdgeToBeAdded() {
    return SuperNearEdgeToBeAdded.instance();
  }

  public SuperNearEdgeToBeAdded.Matcher getSuperNearEdgeToBeAdded(final ViatraQueryEngine engine) {
    return SuperNearEdgeToBeAdded.Matcher.on(engine);
  }

  public VeryNearEdgeToBeAdded getVeryNearEdgeToBeAdded() {
    return VeryNearEdgeToBeAdded.instance();
  }

  public VeryNearEdgeToBeAdded.Matcher getVeryNearEdgeToBeAdded(final ViatraQueryEngine engine) {
    return VeryNearEdgeToBeAdded.Matcher.on(engine);
  }

  public NearEdgeToBeAdded getNearEdgeToBeAdded() {
    return NearEdgeToBeAdded.instance();
  }

  public NearEdgeToBeAdded.Matcher getNearEdgeToBeAdded(final ViatraQueryEngine engine) {
    return NearEdgeToBeAdded.Matcher.on(engine);
  }

  public VisibleDistanceEdgeToBeAdded getVisibleDistanceEdgeToBeAdded() {
    return VisibleDistanceEdgeToBeAdded.instance();
  }

  public VisibleDistanceEdgeToBeAdded.Matcher getVisibleDistanceEdgeToBeAdded(final ViatraQueryEngine engine) {
    return VisibleDistanceEdgeToBeAdded.Matcher.on(engine);
  }

  public IsPreCollisionLabel getIsPreCollisionLabel() {
    return IsPreCollisionLabel.instance();
  }

  public IsPreCollisionLabel.Matcher getIsPreCollisionLabel(final ViatraQueryEngine engine) {
    return IsPreCollisionLabel.Matcher.on(engine);
  }

  public IsSuperNearLabel getIsSuperNearLabel() {
    return IsSuperNearLabel.instance();
  }

  public IsSuperNearLabel.Matcher getIsSuperNearLabel(final ViatraQueryEngine engine) {
    return IsSuperNearLabel.Matcher.on(engine);
  }

  public IsVeryNearLabel getIsVeryNearLabel() {
    return IsVeryNearLabel.instance();
  }

  public IsVeryNearLabel.Matcher getIsVeryNearLabel(final ViatraQueryEngine engine) {
    return IsVeryNearLabel.Matcher.on(engine);
  }

  public IsNearLabel getIsNearLabel() {
    return IsNearLabel.instance();
  }

  public IsNearLabel.Matcher getIsNearLabel(final ViatraQueryEngine engine) {
    return IsNearLabel.Matcher.on(engine);
  }

  public IsVisibleLabel getIsVisibleLabel() {
    return IsVisibleLabel.instance();
  }

  public IsVisibleLabel.Matcher getIsVisibleLabel(final ViatraQueryEngine engine) {
    return IsVisibleLabel.Matcher.on(engine);
  }

  public UpdatePreCollision getUpdatePreCollision() {
    return UpdatePreCollision.instance();
  }

  public UpdatePreCollision.Matcher getUpdatePreCollision(final ViatraQueryEngine engine) {
    return UpdatePreCollision.Matcher.on(engine);
  }

  public UpdateSuperNear getUpdateSuperNear() {
    return UpdateSuperNear.instance();
  }

  public UpdateSuperNear.Matcher getUpdateSuperNear(final ViatraQueryEngine engine) {
    return UpdateSuperNear.Matcher.on(engine);
  }

  public UpdateVeryNear getUpdateVeryNear() {
    return UpdateVeryNear.instance();
  }

  public UpdateVeryNear.Matcher getUpdateVeryNear(final ViatraQueryEngine engine) {
    return UpdateVeryNear.Matcher.on(engine);
  }

  public UpdateNear getUpdateNear() {
    return UpdateNear.instance();
  }

  public UpdateNear.Matcher getUpdateNear(final ViatraQueryEngine engine) {
    return UpdateNear.Matcher.on(engine);
  }

  public UpdateVisibleDistance getUpdateVisibleDistance() {
    return UpdateVisibleDistance.instance();
  }

  public UpdateVisibleDistance.Matcher getUpdateVisibleDistance(final ViatraQueryEngine engine) {
    return UpdateVisibleDistance.Matcher.on(engine);
  }

  public Left getLeft() {
    return Left.instance();
  }

  public Left.Matcher getLeft(final ViatraQueryEngine engine) {
    return Left.Matcher.on(engine);
  }

  public FrontLeft getFrontLeft() {
    return FrontLeft.instance();
  }

  public FrontLeft.Matcher getFrontLeft(final ViatraQueryEngine engine) {
    return FrontLeft.Matcher.on(engine);
  }

  public Front getFront() {
    return Front.instance();
  }

  public Front.Matcher getFront(final ViatraQueryEngine engine) {
    return Front.Matcher.on(engine);
  }

  public FrontRight getFrontRight() {
    return FrontRight.instance();
  }

  public FrontRight.Matcher getFrontRight(final ViatraQueryEngine engine) {
    return FrontRight.Matcher.on(engine);
  }

  public Right getRight() {
    return Right.instance();
  }

  public Right.Matcher getRight(final ViatraQueryEngine engine) {
    return Right.Matcher.on(engine);
  }

  public RearRight getRearRight() {
    return RearRight.instance();
  }

  public RearRight.Matcher getRearRight(final ViatraQueryEngine engine) {
    return RearRight.Matcher.on(engine);
  }

  public Rear getRear() {
    return Rear.instance();
  }

  public Rear.Matcher getRear(final ViatraQueryEngine engine) {
    return Rear.Matcher.on(engine);
  }

  public RearLeft getRearLeft() {
    return RearLeft.instance();
  }

  public RearLeft.Matcher getRearLeft(final ViatraQueryEngine engine) {
    return RearLeft.Matcher.on(engine);
  }

  public LeftEdgeToBeAdded getLeftEdgeToBeAdded() {
    return LeftEdgeToBeAdded.instance();
  }

  public LeftEdgeToBeAdded.Matcher getLeftEdgeToBeAdded(final ViatraQueryEngine engine) {
    return LeftEdgeToBeAdded.Matcher.on(engine);
  }

  public FrontLeftEdgeToBeAdded getFrontLeftEdgeToBeAdded() {
    return FrontLeftEdgeToBeAdded.instance();
  }

  public FrontLeftEdgeToBeAdded.Matcher getFrontLeftEdgeToBeAdded(final ViatraQueryEngine engine) {
    return FrontLeftEdgeToBeAdded.Matcher.on(engine);
  }

  public FrontEdgeToBeAdded getFrontEdgeToBeAdded() {
    return FrontEdgeToBeAdded.instance();
  }

  public FrontEdgeToBeAdded.Matcher getFrontEdgeToBeAdded(final ViatraQueryEngine engine) {
    return FrontEdgeToBeAdded.Matcher.on(engine);
  }

  public FrontRightEdgeToBeAdded getFrontRightEdgeToBeAdded() {
    return FrontRightEdgeToBeAdded.instance();
  }

  public FrontRightEdgeToBeAdded.Matcher getFrontRightEdgeToBeAdded(final ViatraQueryEngine engine) {
    return FrontRightEdgeToBeAdded.Matcher.on(engine);
  }

  public RightEdgeToBeAdded getRightEdgeToBeAdded() {
    return RightEdgeToBeAdded.instance();
  }

  public RightEdgeToBeAdded.Matcher getRightEdgeToBeAdded(final ViatraQueryEngine engine) {
    return RightEdgeToBeAdded.Matcher.on(engine);
  }

  public RearRightEdgeToBeAdded getRearRightEdgeToBeAdded() {
    return RearRightEdgeToBeAdded.instance();
  }

  public RearRightEdgeToBeAdded.Matcher getRearRightEdgeToBeAdded(final ViatraQueryEngine engine) {
    return RearRightEdgeToBeAdded.Matcher.on(engine);
  }

  public RearEdgeToBeAdded getRearEdgeToBeAdded() {
    return RearEdgeToBeAdded.instance();
  }

  public RearEdgeToBeAdded.Matcher getRearEdgeToBeAdded(final ViatraQueryEngine engine) {
    return RearEdgeToBeAdded.Matcher.on(engine);
  }

  public RearLeftEdgeToBeAdded getRearLeftEdgeToBeAdded() {
    return RearLeftEdgeToBeAdded.instance();
  }

  public RearLeftEdgeToBeAdded.Matcher getRearLeftEdgeToBeAdded(final ViatraQueryEngine engine) {
    return RearLeftEdgeToBeAdded.Matcher.on(engine);
  }

  public UpdateLeft getUpdateLeft() {
    return UpdateLeft.instance();
  }

  public UpdateLeft.Matcher getUpdateLeft(final ViatraQueryEngine engine) {
    return UpdateLeft.Matcher.on(engine);
  }

  public UpdateFrontLeft getUpdateFrontLeft() {
    return UpdateFrontLeft.instance();
  }

  public UpdateFrontLeft.Matcher getUpdateFrontLeft(final ViatraQueryEngine engine) {
    return UpdateFrontLeft.Matcher.on(engine);
  }

  public UpdateFront getUpdateFront() {
    return UpdateFront.instance();
  }

  public UpdateFront.Matcher getUpdateFront(final ViatraQueryEngine engine) {
    return UpdateFront.Matcher.on(engine);
  }

  public UpdateFrontRight getUpdateFrontRight() {
    return UpdateFrontRight.instance();
  }

  public UpdateFrontRight.Matcher getUpdateFrontRight(final ViatraQueryEngine engine) {
    return UpdateFrontRight.Matcher.on(engine);
  }

  public UpdateRight getUpdateRight() {
    return UpdateRight.instance();
  }

  public UpdateRight.Matcher getUpdateRight(final ViatraQueryEngine engine) {
    return UpdateRight.Matcher.on(engine);
  }

  public UpdateRearRight getUpdateRearRight() {
    return UpdateRearRight.instance();
  }

  public UpdateRearRight.Matcher getUpdateRearRight(final ViatraQueryEngine engine) {
    return UpdateRearRight.Matcher.on(engine);
  }

  public UpdateRear getUpdateRear() {
    return UpdateRear.instance();
  }

  public UpdateRear.Matcher getUpdateRear(final ViatraQueryEngine engine) {
    return UpdateRear.Matcher.on(engine);
  }

  public UpdateRearLeft getUpdateRearLeft() {
    return UpdateRearLeft.instance();
  }

  public UpdateRearLeft.Matcher getUpdateRearLeft(final ViatraQueryEngine engine) {
    return UpdateRearLeft.Matcher.on(engine);
  }

  public VehicleOnLaneSegment getVehicleOnLaneSegment() {
    return VehicleOnLaneSegment.instance();
  }

  public VehicleOnLaneSegment.Matcher getVehicleOnLaneSegment(final ViatraQueryEngine engine) {
    return VehicleOnLaneSegment.Matcher.on(engine);
  }

  public VehicleOnLaneSegmentEdgeToBeAdded getVehicleOnLaneSegmentEdgeToBeAdded() {
    return VehicleOnLaneSegmentEdgeToBeAdded.instance();
  }

  public VehicleOnLaneSegmentEdgeToBeAdded.Matcher getVehicleOnLaneSegmentEdgeToBeAdded(final ViatraQueryEngine engine) {
    return VehicleOnLaneSegmentEdgeToBeAdded.Matcher.on(engine);
  }

  public VehicleOnLaneSegmentEdgeToBeRemoved getVehicleOnLaneSegmentEdgeToBeRemoved() {
    return VehicleOnLaneSegmentEdgeToBeRemoved.instance();
  }

  public VehicleOnLaneSegmentEdgeToBeRemoved.Matcher getVehicleOnLaneSegmentEdgeToBeRemoved(final ViatraQueryEngine engine) {
    return VehicleOnLaneSegmentEdgeToBeRemoved.Matcher.on(engine);
  }

  public VLongitudinal getVLongitudinal() {
    return VLongitudinal.instance();
  }

  public VLongitudinal.Matcher getVLongitudinal(final ViatraQueryEngine engine) {
    return VLongitudinal.Matcher.on(engine);
  }

  public VLateral getVLateral() {
    return VLateral.instance();
  }

  public VLateral.Matcher getVLateral(final ViatraQueryEngine engine) {
    return VLateral.Matcher.on(engine);
  }

  public IsLeftSector getIsLeftSector() {
    return IsLeftSector.instance();
  }

  public IsLeftSector.Matcher getIsLeftSector(final ViatraQueryEngine engine) {
    return IsLeftSector.Matcher.on(engine);
  }

  public IsFrontLeftSector getIsFrontLeftSector() {
    return IsFrontLeftSector.instance();
  }

  public IsFrontLeftSector.Matcher getIsFrontLeftSector(final ViatraQueryEngine engine) {
    return IsFrontLeftSector.Matcher.on(engine);
  }

  public IsFrontSector getIsFrontSector() {
    return IsFrontSector.instance();
  }

  public IsFrontSector.Matcher getIsFrontSector(final ViatraQueryEngine engine) {
    return IsFrontSector.Matcher.on(engine);
  }

  public IsFrontRightSector getIsFrontRightSector() {
    return IsFrontRightSector.instance();
  }

  public IsFrontRightSector.Matcher getIsFrontRightSector(final ViatraQueryEngine engine) {
    return IsFrontRightSector.Matcher.on(engine);
  }

  public IsRightSector getIsRightSector() {
    return IsRightSector.instance();
  }

  public IsRightSector.Matcher getIsRightSector(final ViatraQueryEngine engine) {
    return IsRightSector.Matcher.on(engine);
  }

  public IsRearRightSector getIsRearRightSector() {
    return IsRearRightSector.instance();
  }

  public IsRearRightSector.Matcher getIsRearRightSector(final ViatraQueryEngine engine) {
    return IsRearRightSector.Matcher.on(engine);
  }

  public IsRearSector getIsRearSector() {
    return IsRearSector.instance();
  }

  public IsRearSector.Matcher getIsRearSector(final ViatraQueryEngine engine) {
    return IsRearSector.Matcher.on(engine);
  }

  public IsRearLeftSector getIsRearLeftSector() {
    return IsRearLeftSector.instance();
  }

  public IsRearLeftSector.Matcher getIsRearLeftSector(final ViatraQueryEngine engine) {
    return IsRearLeftSector.Matcher.on(engine);
  }

  public IsFrontGroupSector getIsFrontGroupSector() {
    return IsFrontGroupSector.instance();
  }

  public IsFrontGroupSector.Matcher getIsFrontGroupSector(final ViatraQueryEngine engine) {
    return IsFrontGroupSector.Matcher.on(engine);
  }

  public IsLeftGroupSector getIsLeftGroupSector() {
    return IsLeftGroupSector.instance();
  }

  public IsLeftGroupSector.Matcher getIsLeftGroupSector(final ViatraQueryEngine engine) {
    return IsLeftGroupSector.Matcher.on(engine);
  }

  public IsRightGroupSector getIsRightGroupSector() {
    return IsRightGroupSector.instance();
  }

  public IsRightGroupSector.Matcher getIsRightGroupSector(final ViatraQueryEngine engine) {
    return IsRightGroupSector.Matcher.on(engine);
  }

  public LongitudinalRSSViolation getLongitudinalRSSViolation() {
    return LongitudinalRSSViolation.instance();
  }

  public LongitudinalRSSViolation.Matcher getLongitudinalRSSViolation(final ViatraQueryEngine engine) {
    return LongitudinalRSSViolation.Matcher.on(engine);
  }

  public LongitudinalRSSViolationEdgeToBeAdded getLongitudinalRSSViolationEdgeToBeAdded() {
    return LongitudinalRSSViolationEdgeToBeAdded.instance();
  }

  public LongitudinalRSSViolationEdgeToBeAdded.Matcher getLongitudinalRSSViolationEdgeToBeAdded(final ViatraQueryEngine engine) {
    return LongitudinalRSSViolationEdgeToBeAdded.Matcher.on(engine);
  }

  public LongitudinalRSSViolationEdgeToBeRemoved getLongitudinalRSSViolationEdgeToBeRemoved() {
    return LongitudinalRSSViolationEdgeToBeRemoved.instance();
  }

  public LongitudinalRSSViolationEdgeToBeRemoved.Matcher getLongitudinalRSSViolationEdgeToBeRemoved(final ViatraQueryEngine engine) {
    return LongitudinalRSSViolationEdgeToBeRemoved.Matcher.on(engine);
  }

  public LateralRSSViolation getLateralRSSViolation() {
    return LateralRSSViolation.instance();
  }

  public LateralRSSViolation.Matcher getLateralRSSViolation(final ViatraQueryEngine engine) {
    return LateralRSSViolation.Matcher.on(engine);
  }

  public LateralRSSViolationEdgeToBeAdded getLateralRSSViolationEdgeToBeAdded() {
    return LateralRSSViolationEdgeToBeAdded.instance();
  }

  public LateralRSSViolationEdgeToBeAdded.Matcher getLateralRSSViolationEdgeToBeAdded(final ViatraQueryEngine engine) {
    return LateralRSSViolationEdgeToBeAdded.Matcher.on(engine);
  }

  public LateralRSSViolationEdgeToBeRemoved getLateralRSSViolationEdgeToBeRemoved() {
    return LateralRSSViolationEdgeToBeRemoved.instance();
  }

  public LateralRSSViolationEdgeToBeRemoved.Matcher getLateralRSSViolationEdgeToBeRemoved(final ViatraQueryEngine engine) {
    return LateralRSSViolationEdgeToBeRemoved.Matcher.on(engine);
  }
}
