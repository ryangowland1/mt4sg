package ca.mcmaster.mt4sg.core.runner

import ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue
import ca.mcmaster.mt4sg.models.scenegraph.Edge
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraph
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelPackage
import ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue
import ca.mcmaster.mt4sg.models.scenegraph.Vehicle
import ca.mcmaster.mt4sg.models.scenegraph.LaneSegment
import ca.mcmaster.mt4sg.models.scenegraph.Node
import ca.mcmaster.mt4sg.queries.Scenegraph
import java.util.concurrent.Callable
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.transaction.RecordingCommand
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.viatra.query.runtime.api.AdvancedViatraQueryEngine
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.IModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.modelmanipulation.SimpleModelManipulations
import org.eclipse.viatra.transformation.runtime.emf.rules.EventDrivenTransformationRuleGroup
import org.eclipse.viatra.transformation.runtime.emf.rules.eventdriven.EventDrivenTransformationRuleFactory
import org.eclipse.viatra.transformation.runtime.emf.transformation.eventdriven.EventDrivenTransformation

/**
 * Event-driven scene-graph transformation. Each rule's precondition pattern in
 * {@code scenegraph.vql} decides exactly when an edge must be created, relabelled,
 * or removed, so the actions here only manipulate the model and never scan it.
 *
 * <p>The metamodel replaces the old single {@code Edge} type (with generic
 * {@code type}/{@code distance}/{@code spatial} string attributes) with a
 * family of typed edges: {@code DistanceEdge} (enum {@code distance}),
 * {@code SpatialEdge} (enum {@code spatialPosition}),
 * {@code VehicleIsInLaneSegmentEdge}, {@code LongitudinalRSSViolationEdge}, and
 * {@code LateralRSSViolationEdge}. Rules below create/relabel/remove the
 * concrete typed edge that matches each firing pattern instead of a generic
 * {@code Edge}. The root container is {@code SceneGraph} (was {@code Scene}).
 *
 * <p>Model writes go through {@link IModelManipulations} (a
 * {@link SimpleModelManipulations} over the same engine), so swapping in an
 * editing-domain implementation later is a one line change in the constructor.
 */
class Transformations {

	extension Logger logger = Logger.getLogger(Transformations)

	extension EventDrivenTransformationRuleFactory ruleFactory = new EventDrivenTransformationRuleFactory
	extension IModelManipulations manipulation
	extension Scenegraph scenegraph = Scenegraph::instance

	var AdvancedViatraQueryEngine engine
	var EventDrivenTransformation transformation
	val TransactionalEditingDomain domain

	new(Resource resource) {
		val scope = new EMFScope(resource)
		engine = AdvancedViatraQueryEngine.from(ViatraQueryEngine.on(scope))
		
		domain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(resource.resourceSet)
		manipulation = new SimpleModelManipulations(engine)

		debug('''Initialize event-driven transformations''')
		transformation = EventDrivenTransformation.forEngine(engine).addRules(rules).build
		debug('''Successfully initialized event-driven transformations''')
	}

	/**
	 * Exposes the engine's delay API so external writers can batch EMF 
	 * modifications before VIATRA attempts to pattern-match.
	 */
	def void delayUpdatePropagation(Runnable runnable) {
		engine.delayUpdatePropagation(new Callable<Object>() {
			override call() throws Exception {
				runnable.run()
				return null
			}
		})
	}
	
	def startExecution() {
		transformation.executionSchema.startUnscheduledExecution
	}

	/**
	 * Fires the enabled activations through the scheduler, which ignores the scheduling the
	 * firings cause, so each rule action finishes before the next activation is picked.
	 */
	def void schedule() {
		domain.commandStack.execute(new RecordingCommand(domain) {
			override protected doExecute() {
				startExecution
			}
		})
	}

	def getRules() {
		val rules = new EventDrivenTransformationRuleGroup(
			createPreCollisionRule,
			createSuperNearRule,
			createVeryNearRule,
			createNearRule,
			createVisibleDistanceRule,
			updatePreCollisionRule,
			updateSuperNearRule,
			updateVeryNearRule,
			updateNearRule,
			updateVisibleDistanceRule,
			removeDistanceEdgeRule,
			createLeftRule,
			createFrontLeftRule,
			createFrontRule,
			createFrontRightRule,
			createRightRule,
			createRearRightRule,
			createRearRule,
			createRearLeftRule,
			updateLeftRule,
			updateFrontLeftRule,
			updateFrontRule,
			updateFrontRightRule,
			updateRightRule,
			updateRearRightRule,
			updateRearRule,
			updateRearLeftRule,
			createVehicleOnLaneSegmentRule,
			removeVehicleOnLaneSegmentRule,
			createLongitudinalRSSViolationRule,
			removeLongitudinalRSSViolationRule,
			createLateralRSSViolationRule,
			removeLateralRSSViolationRule
		)

		return rules
	}

	// ── Distance (proximity) edges ─────────────────────────────────────────

	val createPreCollisionRule = createRule(preCollisionEdgeToBeAdded).name("CreatePreCollisionRule").action [
		createDistanceEdge(v1, v2, SemanticDistanceValue.PRE_COLLISION)
	].build

	val createSuperNearRule = createRule(superNearEdgeToBeAdded).name("CreateSuperNearRule").action [
		createDistanceEdge(v1, v2, SemanticDistanceValue.SUPER_NEAR)
	].build

	val createVeryNearRule = createRule(veryNearEdgeToBeAdded).name("CreateVeryNearRule").action [
		createDistanceEdge(v1, v2, SemanticDistanceValue.VERY_NEAR)
	].build

	val createNearRule = createRule(nearEdgeToBeAdded).name("CreateNearRule").action [
		createDistanceEdge(v1, v2, SemanticDistanceValue.NEAR)
	].build

	val createVisibleDistanceRule = createRule(visibleDistanceEdgeToBeAdded).name("CreateVisibleDistanceRule").action [
		createDistanceEdge(v1, v2, SemanticDistanceValue.VISIBLE)
	].build

	val updatePreCollisionRule = createRule(updatePreCollision).name("UpdatePreCollisionRule").action [
		updateDistance(e, SemanticDistanceValue.PRE_COLLISION)
	].build

	val updateSuperNearRule = createRule(updateSuperNear).name("UpdateSuperNearRule").action [
		updateDistance(e, SemanticDistanceValue.SUPER_NEAR)
	].build

	val updateVeryNearRule = createRule(updateVeryNear).name("UpdateVeryNearRule").action [
		updateDistance(e, SemanticDistanceValue.VERY_NEAR)
	].build

	val updateNearRule = createRule(updateNear).name("UpdateNearRule").action [
		updateDistance(e, SemanticDistanceValue.NEAR)
	].build

	val updateVisibleDistanceRule = createRule(updateVisibleDistance).name("UpdateVisibleDistanceRule").action [
		updateDistance(e, SemanticDistanceValue.VISIBLE)
	].build

	val removeDistanceEdgeRule = createRule(distanceEdgeToBeRemoved).name("RemoveEdgeRule").action [
		deleteEdge(e)
	].build

	// ── Spatial (8-sector bearing) edges ───────────────────────────────────

	val createLeftRule = createRule(leftEdgeToBeAdded).name("CreateLeftRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.LEFT)
	].build

	val createFrontLeftRule = createRule(frontLeftEdgeToBeAdded).name("CreateFrontLeftRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.FRONT_LEFT)
	].build

	val createFrontRule = createRule(frontEdgeToBeAdded).name("CreateFrontRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.FRONT)
	].build

	val createFrontRightRule = createRule(frontRightEdgeToBeAdded).name("CreateFrontRightRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.FRONT_RIGHT)
	].build

	val createRightRule = createRule(rightEdgeToBeAdded).name("CreateRightRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.RIGHT)
	].build

	val createRearRightRule = createRule(rearRightEdgeToBeAdded).name("CreateRearRightRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.REAR_RIGHT)
	].build

	val createRearRule = createRule(rearEdgeToBeAdded).name("CreateRearRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.REAR)
	].build

	val createRearLeftRule = createRule(rearLeftEdgeToBeAdded).name("CreateRearLeftRule").action [
		createSpatialEdge(source, target, SemanticSpatialPositionValue.REAR_LEFT)
	].build

	val updateLeftRule = createRule(updateLeft).name("UpdateLeftRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.LEFT)
	].build

	val updateFrontLeftRule = createRule(updateFrontLeft).name("UpdateFrontLeftRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.FRONT_LEFT)
	].build

	val updateFrontRule = createRule(updateFront).name("UpdateFrontRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.FRONT)
	].build

	val updateFrontRightRule = createRule(updateFrontRight).name("UpdateFrontRightRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.FRONT_RIGHT)
	].build

	val updateRightRule = createRule(updateRight).name("UpdateRightRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.RIGHT)
	].build

	val updateRearRightRule = createRule(updateRearRight).name("UpdateRearRightRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.REAR_RIGHT)
	].build

	val updateRearRule = createRule(updateRear).name("UpdateRearRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.REAR)
	].build

	val updateRearLeftRule = createRule(updateRearLeft).name("UpdateRearLeftRule").action [
		updateSpatial(e, SemanticSpatialPositionValue.REAR_LEFT)
	].build

	// ── Lane membership ─────────────────────────────────────────────────────

	val createVehicleOnLaneSegmentRule = createRule(vehicleOnLaneSegmentEdgeToBeAdded).name("CreateVehicleOnLaneSegmentRule").action [
		createVehicleIsInLaneSegmentEdge(vehicle, lane)
	].build

	val removeVehicleOnLaneSegmentRule = createRule(vehicleOnLaneSegmentEdgeToBeRemoved).name("RemoveVehicleOnLaneSegmentRule").action [
		deleteEdge(e)
	].build

	// ── RSS violations ───────────────────────────────────────────────────────

	val createLongitudinalRSSViolationRule = createRule(longitudinalRSSViolationEdgeToBeAdded).name("CreateLongitudinalRSSViolationRule").action [
		createTypedEdge(v1, v2, SceneGraphModelPackage.Literals.LONGITUDINAL_RSS_VIOLATION)
	].build

	val removeLongitudinalRSSViolationRule = createRule(longitudinalRSSViolationEdgeToBeRemoved).name("RemoveLongitudinalRSSViolationRule").action [
		deleteEdge(e)
	].build

	val createLateralRSSViolationRule = createRule(lateralRSSViolationEdgeToBeAdded).name("CreateLateralRSSViolationRule").action [
		createTypedEdge(v1, v2, SceneGraphModelPackage.Literals.LATERAL_RSS_VIOLATION)
	].build

	val removeLateralRSSViolationRule = createRule(lateralRSSViolationEdgeToBeRemoved).name("RemoveLateralRSSViolationRule").action [
		deleteEdge(e)
	].build

	// ── Model manipulation helpers ───────────────────────────────────────────

	def createDistanceEdge(Vehicle v1, Vehicle v2, SemanticDistanceValue distance) {
		val scene = v1.eContainer as SceneGraph
		val edge = scene.createChild(SceneGraphModelPackage.Literals.SCENE_GRAPH__EDGES,
			SceneGraphModelPackage.Literals.DISTANCE) as Edge
		edge.set(SceneGraphModelPackage.Literals.EDGE__SOURCE, v1)
		edge.set(SceneGraphModelPackage.Literals.EDGE__TARGET, v2)
		edge.set(SceneGraphModelPackage.Literals.DISTANCE__VALUE, distance)
		info('''Created DistanceEdge: «v1.id» -> «v2.id» («distance»)''')
	}
	
	def createSpatialEdge(Vehicle source, Vehicle target, SemanticSpatialPositionValue spatial) {
		val scene = source.eContainer as SceneGraph
		val edge = scene.createChild(SceneGraphModelPackage.Literals.SCENE_GRAPH__EDGES,
			SceneGraphModelPackage.Literals.SPATIAL_POSITION) as Edge
		edge.set(SceneGraphModelPackage.Literals.EDGE__SOURCE, source)
		edge.set(SceneGraphModelPackage.Literals.EDGE__TARGET, target)
		edge.set(SceneGraphModelPackage.Literals.SPATIAL_POSITION__VALUE, spatial)
		info('''Created SpatialEdge: «source.id» -> «target.id» («spatial»)''')
	}

	def createVehicleIsInLaneSegmentEdge(Vehicle vehicle, LaneSegment lane) {
		val scene = vehicle.eContainer as SceneGraph
		val edge = scene.createChild(SceneGraphModelPackage.Literals.SCENE_GRAPH__EDGES,
			SceneGraphModelPackage.Literals.VEHICLE_IN_LANE_SEGMENT) as Edge
		edge.set(SceneGraphModelPackage.Literals.EDGE__SOURCE, vehicle)
		edge.set(SceneGraphModelPackage.Literals.EDGE__TARGET, lane)
		info('''Created VehicleIsInLaneSegmentEdge: «vehicle.id» -> «lane.id»''')
	}

	def createTypedEdge(Node source, Node target, EClass edgeType) {
		val scene = source.eContainer as SceneGraph
		val edge = scene.createChild(SceneGraphModelPackage.Literals.SCENE_GRAPH__EDGES, edgeType) as Edge
		edge.set(SceneGraphModelPackage.Literals.EDGE__SOURCE, source)
		edge.set(SceneGraphModelPackage.Literals.EDGE__TARGET, target)
		info('''Created «edgeType.name»: «source.id» -> «target.id»''')
	}

	def updateDistance(Edge e, SemanticDistanceValue distance) {
		e.set(SceneGraphModelPackage.Literals.DISTANCE__VALUE, distance)
		info('''Updated distance: «e.source.id» -> «e.target.id» = «distance»''')
	}

	def updateSpatial(Edge e, SemanticSpatialPositionValue spatial) {
		e.set(SceneGraphModelPackage.Literals.SPATIAL_POSITION__VALUE, spatial)
		info('''Updated spatial: «e.source.id» -> «e.target.id» = «spatial»''')
	}

	def deleteEdge(Edge e) {
		info('''Removed «e.eClass.name» edge: «e.source.id» -> «e.target.id»''')
		manipulation.remove(e)
	}

}
