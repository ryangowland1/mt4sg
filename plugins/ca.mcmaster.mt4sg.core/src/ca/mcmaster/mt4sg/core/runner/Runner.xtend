package ca.mcmaster.mt4sg.core.runner

import ca.mcmaster.carla2ecore.JsonModelUpdater
import ca.mcmaster.carla2ecore.ZmqSubscriber
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelFactory
import ca.mcmaster.mt4sg.visualization.SceneGraphVisualizer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.transaction.TransactionalEditingDomain
import org.eclipse.equinox.app.IApplication
import org.eclipse.equinox.app.IApplicationContext

/**
 * Eclipse IApplication that drives the event-based VIATRA scene-graph pipeline.
 *
 * <p>Rule wiring and model writes live in {@link Transformations}. Data ingestion
 * is delegated to {@link ZmqSubscriber} of the Carla2Ecore bridge ({@code ca.mcmaster.carla2ecore}),
 * which subscribes to JSON scene snapshots on a ZeroMQ PUB socket and
 * invokes a callback that diffs each snapshot into the in-memory EMF
 * {@link ca.mcmaster.mt4sg.models.scenegraph.SceneGraph} via {@link JsonModelUpdater}.
 * EMF change notifications then trigger the registered transformation rules.
 *
 * <p>The {@code ResourceSet} backing {@code sceneGraph} is created via
 * {@code TransactionalEditingDomain.Factory}, which registers a
 * {@link TransactionalEditingDomain} against it. {@link JsonModelUpdater} relies
 * on that mapping (via {@code TransactionUtil.getEditingDomain}) to wrap its model
 * diff in a {@code RecordingCommand} — without this registration step the updater
 * NPEs on the first snapshot.
 *
 * <p>The root containment class is {@code SceneGraph} (was {@code Scene}) in the
 * updated metamodel, so the in-memory root is built with
 * {@code SceneGraphModelFactory.eINSTANCE.createSceneGraph} rather than
 * {@code createScene}.
 */
class Runner implements IApplication {

	extension Logger logger = Logger.getLogger(Runner)

	def static getZmqEndpoint() {
		val override = System.getProperty("carla.zmq.endpoint")
		if (override !== null && !override.empty) {
			return override
		}
		return "tcp://127.0.0.1:5556"
	}

	override start(IApplicationContext context) {

		val rs = new ResourceSetImpl
		rs.resourceFactoryRegistry.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		rs.resourceFactoryRegistry.extensionToFactoryMap.put(
			Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl)

		// Creating the domain via the factory (rather than instantiating an impl
		// directly) is what registers rs -> domain, which JsonModelUpdater needs.
		val domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs)

		val resource = rs.createResource(URI.createURI("dummy:///in-memory.xmi"))
		val sceneGraph = SceneGraphModelFactory.eINSTANCE.createSceneGraph
		sceneGraph.id = "CARLA_Live"

		// Adding the root must itself go through the domain's command stack once
		// it exists, to keep the resource's initial state consistent with every
		// later transactional write (and to avoid a "silent" mutation outside
		// any transaction, which EMF Transaction logs as a warning).
		domain.commandStack.execute(new org.eclipse.emf.transaction.RecordingCommand(domain) {
			override protected doExecute() {
				resource.contents.add(sceneGraph)
			}
		})

		val transformations = new Transformations(resource)
		transformations.startExecution
		info("[Runner] EventDrivenTransformation active.")

		val updater = new JsonModelUpdater(sceneGraph)
		val visualizer = new SceneGraphVisualizer(sceneGraph)
		val visualizerExecutor = Executors.newSingleThreadExecutor
		val endpoint = getZmqEndpoint
		info('''[Runner] Subscribing for scene snapshots: «endpoint»''')
		
		// Start the stream bridge. Have VIATRA delay processing updates from the stream bridge until all updates are received
		// Additional documentation: https://eclipse.dev/viatra/documentation/query-api.html#_delaying_query_result_updates
		new ZmqSubscriber(endpoint, [ json |
			transformations.delayUpdatePropagation [
				updater.applyJson(json)
			]

			// The scheduler only sees the delayed changes once the block ends, so start its pass here
			// Its pass fires matches one at a time and rechecks them after each one, ignoring the scheduling the firings cause
			// Firing them in a manual loop lets the scheduler fire inside a rule action instead,
			// which can create 2 distance edges for the same pair, one in each direction
			// Additional documentation: https://eclipse.dev/viatra/documentation/evm.html
			transformations.schedule()

			visualizerExecutor.submit [ visualizer.writeSnapshot ]
		]).start

		new CountDownLatch(1).await
		return IApplication.EXIT_OK
	}

	override stop() {}

}
