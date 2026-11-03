package ca.mcmaster.mt4sg.core.runner;

import ca.mcmaster.carla2ecore.JsonModelUpdater;
import ca.mcmaster.carla2ecore.ZmqSubscriber;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraph;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraphModelFactory;
import ca.mcmaster.mt4sg.visualization.SceneGraphVisualizer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

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
@SuppressWarnings("all")
public class Runner implements IApplication {
  @Extension
  private Logger logger = Logger.getLogger(Runner.class);

  public static String getZmqEndpoint() {
    final String override = System.getProperty("carla.zmq.endpoint");
    if (((override != null) && (!override.isEmpty()))) {
      return override;
    }
    return "tcp://127.0.0.1:5556";
  }

  @Override
  public Object start(final IApplicationContext context) {
    try {
      final ResourceSetImpl rs = new ResourceSetImpl();
      Map<String, Object> _extensionToFactoryMap = rs.getResourceFactoryRegistry().getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
      _extensionToFactoryMap.put("xmi", _xMIResourceFactoryImpl);
      Map<String, Object> _extensionToFactoryMap_1 = rs.getResourceFactoryRegistry().getExtensionToFactoryMap();
      XMIResourceFactoryImpl _xMIResourceFactoryImpl_1 = new XMIResourceFactoryImpl();
      _extensionToFactoryMap_1.put(
        Resource.Factory.Registry.DEFAULT_EXTENSION, _xMIResourceFactoryImpl_1);
      final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rs);
      final Resource resource = rs.createResource(URI.createURI("dummy:///in-memory.xmi"));
      final SceneGraph sceneGraph = SceneGraphModelFactory.eINSTANCE.createSceneGraph();
      sceneGraph.setId("CARLA_Live");
      CommandStack _commandStack = domain.getCommandStack();
      _commandStack.execute(new RecordingCommand(domain) {
        @Override
        protected void doExecute() {
          resource.getContents().add(sceneGraph);
        }
      });
      final Transformations transformations = new Transformations(resource);
      transformations.startExecution();
      this.logger.info("[Runner] EventDrivenTransformation active.");
      final JsonModelUpdater updater = new JsonModelUpdater(sceneGraph);
      final SceneGraphVisualizer visualizer = new SceneGraphVisualizer(sceneGraph);
      final ExecutorService visualizerExecutor = Executors.newSingleThreadExecutor();
      final String endpoint = Runner.getZmqEndpoint();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("[Runner] Subscribing for scene snapshots: ");
      _builder.append(endpoint);
      this.logger.info(_builder);
      final Consumer<String> _function = (String json) -> {
        final Runnable _function_1 = () -> {
          updater.applyJson(json);
        };
        transformations.delayUpdatePropagation(_function_1);
        transformations.schedule();
        final Runnable _function_2 = () -> {
          visualizer.writeSnapshot();
        };
        visualizerExecutor.submit(_function_2);
      };
      new ZmqSubscriber(endpoint, _function).start();
      new CountDownLatch(1).await();
      return IApplication.EXIT_OK;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public void stop() {
  }
}
