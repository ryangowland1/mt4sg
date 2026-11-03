/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.Vehicle;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.TypeFilterConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;
import org.eclipse.xtext.xbase.lib.DoubleExtensions;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         {@literal @}QueryBasedFeature(feature = "vLateral")
 *         pattern vLateral(vehicle: Vehicle, target: java Double) {
 *             find vehicleOnLaneSegment(_sg, vehicle, laneSegment);
 *             Vehicle.heading(vehicle, vehicleHeading);
 *             LaneSegment.heading(laneSegment, laneHeading);
 *             Vehicle.speed(vehicle, speed);
 *             target == eval(
 *                 speed  Math.sin(vehicleHeading - laneHeading)
 *             );
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class VLateral extends BaseGeneratedEMFQuerySpecification<VLateral.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.vLateral pattern,
   * to be used in conjunction with {@link Matcher}.
   * 
   * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
   * Each instance is a (possibly partial) substitution of pattern parameters,
   * usable to represent a match of the pattern in the result of a query,
   * or to specify the bound (fixed) input parameters when issuing a query.
   * 
   * @see Matcher
   * 
   */
  public static abstract class Match extends BasePatternMatch {
    private Vehicle fVehicle;

    private Double fTarget;

    private static List<String> parameterNames = makeImmutableList("vehicle", "target");

    private Match(final Vehicle pVehicle, final Double pTarget) {
      this.fVehicle = pVehicle;
      this.fTarget = pTarget;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "vehicle": return this.fVehicle;
          case "target": return this.fTarget;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fVehicle;
          case 1: return this.fTarget;
          default: return null;
      }
    }

    public Vehicle getVehicle() {
      return this.fVehicle;
    }

    public Double getTarget() {
      return this.fTarget;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("vehicle".equals(parameterName) ) {
          this.fVehicle = (Vehicle) newValue;
          return true;
      }
      if ("target".equals(parameterName) ) {
          this.fTarget = (Double) newValue;
          return true;
      }
      return false;
    }

    public void setVehicle(final Vehicle pVehicle) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fVehicle = pVehicle;
    }

    public void setTarget(final Double pTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTarget = pTarget;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.vLateral";
    }

    @Override
    public List<String> parameterNames() {
      return VLateral.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fVehicle, fTarget};
    }

    @Override
    public VLateral.Match toImmutable() {
      return isMutable() ? newMatch(fVehicle, fTarget) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"vehicle\"=" + prettyPrintValue(fVehicle) + ", ");
      result.append("\"target\"=" + prettyPrintValue(fTarget));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fVehicle, fTarget);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof VLateral.Match)) {
          VLateral.Match other = (VLateral.Match) obj;
          return Objects.equals(fVehicle, other.fVehicle) && Objects.equals(fTarget, other.fTarget);
      } else {
          // this should be infrequent
          if (!(obj instanceof IPatternMatch)) {
              return false;
          }
          IPatternMatch otherSig  = (IPatternMatch) obj;
          return Objects.equals(specification(), otherSig.specification()) && Arrays.deepEquals(toArray(), otherSig.toArray());
      }
    }

    @Override
    public VLateral specification() {
      return VLateral.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static VLateral.Match newEmptyMatch() {
      return new Mutable(null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static VLateral.Match newMutableMatch(final Vehicle pVehicle, final Double pTarget) {
      return new Mutable(pVehicle, pTarget);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static VLateral.Match newMatch(final Vehicle pVehicle, final Double pTarget) {
      return new Immutable(pVehicle, pTarget);
    }

    private static final class Mutable extends VLateral.Match {
      Mutable(final Vehicle pVehicle, final Double pTarget) {
        super(pVehicle, pTarget);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends VLateral.Match {
      Immutable(final Vehicle pVehicle, final Double pTarget) {
        super(pVehicle, pTarget);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.vLateral pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * {@literal @}QueryBasedFeature(feature = "vLateral")
   * pattern vLateral(vehicle: Vehicle, target: java Double) {
   *     find vehicleOnLaneSegment(_sg, vehicle, laneSegment);
   *     Vehicle.heading(vehicle, vehicleHeading);
   *     LaneSegment.heading(laneSegment, laneHeading);
   *     Vehicle.speed(vehicle, speed);
   *     target == eval(
   *         speed  Math.sin(vehicleHeading - laneHeading)
   *     );
   * }
   * </pre></code>
   * 
   * @see Match
   * @see VLateral
   * 
   */
  public static class Matcher extends BaseMatcher<VLateral.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static VLateral.Matcher on(final ViatraQueryEngine engine) {
      // check if matcher already exists
      Matcher matcher = engine.getExistingMatcher(querySpecification());
      if (matcher == null) {
          matcher = (Matcher)engine.getMatcher(querySpecification());
      }
      return matcher;
    }

    /**
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * @return an initialized matcher
     * @noreference This method is for internal matcher initialization by the framework, do not call it manually.
     * 
     */
    public static VLateral.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_VEHICLE = 0;

    private static final int POSITION_TARGET = 1;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VLateral.Matcher.class);

    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    private Matcher() {
      super(querySpecification());
    }

    /**
     * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<VLateral.Match> getAllMatches(final Vehicle pVehicle, final Double pTarget) {
      return rawStreamAllMatches(new Object[]{pVehicle, pTarget}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<VLateral.Match> streamAllMatches(final Vehicle pVehicle, final Double pTarget) {
      return rawStreamAllMatches(new Object[]{pVehicle, pTarget});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<VLateral.Match> getOneArbitraryMatch(final Vehicle pVehicle, final Double pTarget) {
      return rawGetOneArbitraryMatch(new Object[]{pVehicle, pTarget});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final Vehicle pVehicle, final Double pTarget) {
      return rawHasMatch(new Object[]{pVehicle, pTarget});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final Vehicle pVehicle, final Double pTarget) {
      return rawCountMatches(new Object[]{pVehicle, pTarget});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final Vehicle pVehicle, final Double pTarget, final Consumer<? super VLateral.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pVehicle, pTarget}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public VLateral.Match newMatch(final Vehicle pVehicle, final Double pTarget) {
      return VLateral.Match.newMatch(pVehicle, pTarget);
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vehicle> rawStreamAllValuesOfvehicle(final Object[] parameters) {
      return rawStreamAllValues(POSITION_VEHICLE, parameters).map(Vehicle.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfvehicle() {
      return rawStreamAllValuesOfvehicle(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfvehicle() {
      return rawStreamAllValuesOfvehicle(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfvehicle(final VLateral.Match partialMatch) {
      return rawStreamAllValuesOfvehicle(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfvehicle(final Double pTarget) {
      return rawStreamAllValuesOfvehicle(new Object[]{null, pTarget});
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfvehicle(final VLateral.Match partialMatch) {
      return rawStreamAllValuesOfvehicle(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfvehicle(final Double pTarget) {
      return rawStreamAllValuesOfvehicle(new Object[]{null, pTarget}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Double> rawStreamAllValuesOftarget(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TARGET, parameters).map(Double.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Double> getAllValuesOftarget() {
      return rawStreamAllValuesOftarget(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Double> streamAllValuesOftarget() {
      return rawStreamAllValuesOftarget(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Double> streamAllValuesOftarget(final VLateral.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Double> streamAllValuesOftarget(final Vehicle pVehicle) {
      return rawStreamAllValuesOftarget(new Object[]{pVehicle, null});
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Double> getAllValuesOftarget(final VLateral.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Double> getAllValuesOftarget(final Vehicle pVehicle) {
      return rawStreamAllValuesOftarget(new Object[]{pVehicle, null}).collect(Collectors.toSet());
    }

    @Override
    protected VLateral.Match tupleToMatch(final Tuple t) {
      try {
          return VLateral.Match.newMatch((Vehicle) t.get(POSITION_VEHICLE), (Double) t.get(POSITION_TARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected VLateral.Match arrayToMatch(final Object[] match) {
      try {
          return VLateral.Match.newMatch((Vehicle) match[POSITION_VEHICLE], (Double) match[POSITION_TARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected VLateral.Match arrayToMatchMutable(final Object[] match) {
      try {
          return VLateral.Match.newMutableMatch((Vehicle) match[POSITION_VEHICLE], (Double) match[POSITION_TARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    /**
     * @return the singleton instance of the query specification of this pattern
     * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
     * 
     */
    public static IQuerySpecification<VLateral.Matcher> querySpecification() {
      return VLateral.instance();
    }
  }

  private VLateral() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static VLateral instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected VLateral.Matcher instantiate(final ViatraQueryEngine engine) {
    return VLateral.Matcher.on(engine);
  }

  @Override
  public VLateral.Matcher instantiate() {
    return VLateral.Matcher.create();
  }

  @Override
  public VLateral.Match newEmptyMatch() {
    return VLateral.Match.newEmptyMatch();
  }

  @Override
  public VLateral.Match newMatch(final Object... parameters) {
    return VLateral.Match.newMatch((Vehicle) parameters[0], (Double) parameters[1]);
  }

  /**
   * Inner class allowing the singleton instance of {@link VLateral} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link VLateral#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final VLateral INSTANCE = new VLateral();

    /**
     * Statically initializes the query specification <b>after</b> the field {@link #INSTANCE} is assigned.
     * This initialization order is required to support indirect recursion.
     * 
     * <p> The static initializer is defined using a helper field to work around limitations of the code generator.
     * 
     */
    private static final Object STATIC_INITIALIZER = ensureInitialized();

    public static Object ensureInitialized() {
      INSTANCE.ensureInitializedInternal();
      return null;
    }
  }

  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private static final VLateral.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_vehicle = new PParameter("vehicle", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_target = new PParameter("target", "java.lang.Double", new JavaTransitiveInstancesKey(java.lang.Double.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_vehicle, parameter_target);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.vLateral";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("vehicle","target");
    }

    @Override
    public List<PParameter> getParameters() {
      return parameters;
    }

    @Override
    public Set<PBody> doGetContainedBodies() {
      setEvaluationHints(new QueryEvaluationHint(null, QueryEvaluationHint.BackendRequirement.UNSPECIFIED));
      Set<PBody> bodies = new LinkedHashSet<>();
      {
          PBody body = new PBody(this);
          PVariable var_vehicle = body.getOrCreateVariableByName("vehicle");
          PVariable var_target = body.getOrCreateVariableByName("target");
          PVariable var__sg = body.getOrCreateVariableByName("_sg");
          PVariable var_laneSegment = body.getOrCreateVariableByName("laneSegment");
          PVariable var_vehicleHeading = body.getOrCreateVariableByName("vehicleHeading");
          PVariable var_laneHeading = body.getOrCreateVariableByName("laneHeading");
          PVariable var_speed = body.getOrCreateVariableByName("speed");
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_target), new JavaTransitiveInstancesKey(java.lang.Double.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_vehicle, parameter_vehicle),
             new ExportedParameter(body, var_target, parameter_target)
          ));
          //     find vehicleOnLaneSegment(_sg, vehicle, laneSegment)
          new PositivePatternCall(body, Tuples.flatTupleOf(var__sg, var_vehicle, var_laneSegment), VehicleOnLaneSegment.instance().getInternalQueryRepresentation());
          //     Vehicle.heading(vehicle, vehicleHeading)
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithOrientation", "heading")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_0_, var_vehicleHeading);
          //     LaneSegment.heading(laneSegment, laneHeading)
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithOrientation", "heading")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_1_, var_laneHeading);
          //     Vehicle.speed(vehicle, speed)
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithSpeed", "speed")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_2_, var_speed);
          //     target == eval(        speed * Math.sin(vehicleHeading - laneHeading)    )
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern vLateral";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("laneHeading", "speed", "vehicleHeading");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Double laneHeading = (Double) provider.getValue("laneHeading");
                  Double speed = (Double) provider.getValue("speed");
                  Double vehicleHeading = (Double) provider.getValue("vehicleHeading");
                  return evaluateExpression_1_1(laneHeading, speed, vehicleHeading);
              }
          },  var__virtual_3_ , false);
          new Equality(body, var_target, var__virtual_3_);
          bodies.add(body);
      }
      {
          PAnnotation annotation = new PAnnotation("QueryBasedFeature");
          annotation.addAttribute("feature", "vLateral");
          addAnnotation(annotation);
      }
      return bodies;
    }
  }

  private static double evaluateExpression_1_1(final Double laneHeading, final Double speed, final Double vehicleHeading) {
    double _minus = DoubleExtensions.operator_minus(vehicleHeading, laneHeading);
    double _sin = Math.sin(_minus);
    double _multiply = ((speed).doubleValue() * _sin);
    return _multiply;
  }
}
