/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.LaneSegment;
import ca.mcmaster.mt4sg.models.scenegraph.SceneGraph;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
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
 *         // ===================================================================
 *         // Lane Segment membership
 *         // ===================================================================
 *         
 *         pattern vehicleOnLaneSegment(sg: SceneGraph, vehicle: Vehicle, laneSegment: LaneSegment) {
 *             SceneGraph.nodes(sg, vehicle);
 *             SceneGraph.nodes(sg, road);
 *             Road.lanes(road, parentLane);
 *             Lane.laneSegments(parentLane, lane);
 *         
 *             Vehicle.x(vehicle, vehicleX);
 *             Vehicle.y(vehicle, vehicleY);
 *         
 *             LaneSegment.x(laneSegment, laneX);
 *             LaneSegment.y(laneSegment, laneY);
 *         
 *             Vehicle.heading(vehicle, vehicleHeading);
 *             LaneSegment.heading(laneSegment, laneSegmentHeading);
 *         
 *             LaneSegment.length(laneSegment, length);
 *             LaneSegment.width(laneSegment, width);
 *         
 *             check(
 *                 Math.abs((vehicleX - laneX)  Math.cos(laneSegmentHeading) + (vehicleY - laneY)  Math.sin(laneSegmentHeading)) {@literal <}= length / 2.0 && 
 *                 Math.abs(-(vehicleX - laneX)  Math.sin(laneSegmentHeading) + (vehicleY - laneY)  Math.cos(laneSegmentHeading)) {@literal <}= width / 2.0 
 *             );
 *         
 *             // Prevent membership being assigned to e.g. lanes going in the perpendicular direction at intersections
 *             check(
 *                 Math.abs(Math.atan2(Math.sin(vehicleHeading - laneSegmentHeading), Math.cos(vehicleHeading - laneSegmentHeading))) {@literal <}= 0.15
 *             );
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class VehicleOnLaneSegment extends BaseGeneratedEMFQuerySpecification<VehicleOnLaneSegment.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.vehicleOnLaneSegment pattern,
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
    private SceneGraph fSg;

    private Vehicle fVehicle;

    private LaneSegment fLaneSegment;

    private static List<String> parameterNames = makeImmutableList("sg", "vehicle", "laneSegment");

    private Match(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      this.fSg = pSg;
      this.fVehicle = pVehicle;
      this.fLaneSegment = pLaneSegment;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "sg": return this.fSg;
          case "vehicle": return this.fVehicle;
          case "laneSegment": return this.fLaneSegment;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSg;
          case 1: return this.fVehicle;
          case 2: return this.fLaneSegment;
          default: return null;
      }
    }

    public SceneGraph getSg() {
      return this.fSg;
    }

    public Vehicle getVehicle() {
      return this.fVehicle;
    }

    public LaneSegment getLaneSegment() {
      return this.fLaneSegment;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("sg".equals(parameterName) ) {
          this.fSg = (SceneGraph) newValue;
          return true;
      }
      if ("vehicle".equals(parameterName) ) {
          this.fVehicle = (Vehicle) newValue;
          return true;
      }
      if ("laneSegment".equals(parameterName) ) {
          this.fLaneSegment = (LaneSegment) newValue;
          return true;
      }
      return false;
    }

    public void setSg(final SceneGraph pSg) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSg = pSg;
    }

    public void setVehicle(final Vehicle pVehicle) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fVehicle = pVehicle;
    }

    public void setLaneSegment(final LaneSegment pLaneSegment) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fLaneSegment = pLaneSegment;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.vehicleOnLaneSegment";
    }

    @Override
    public List<String> parameterNames() {
      return VehicleOnLaneSegment.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSg, fVehicle, fLaneSegment};
    }

    @Override
    public VehicleOnLaneSegment.Match toImmutable() {
      return isMutable() ? newMatch(fSg, fVehicle, fLaneSegment) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
      result.append("\"vehicle\"=" + prettyPrintValue(fVehicle) + ", ");
      result.append("\"laneSegment\"=" + prettyPrintValue(fLaneSegment));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSg, fVehicle, fLaneSegment);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof VehicleOnLaneSegment.Match)) {
          VehicleOnLaneSegment.Match other = (VehicleOnLaneSegment.Match) obj;
          return Objects.equals(fSg, other.fSg) && Objects.equals(fVehicle, other.fVehicle) && Objects.equals(fLaneSegment, other.fLaneSegment);
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
    public VehicleOnLaneSegment specification() {
      return VehicleOnLaneSegment.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static VehicleOnLaneSegment.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static VehicleOnLaneSegment.Match newMutableMatch(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return new Mutable(pSg, pVehicle, pLaneSegment);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static VehicleOnLaneSegment.Match newMatch(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return new Immutable(pSg, pVehicle, pLaneSegment);
    }

    private static final class Mutable extends VehicleOnLaneSegment.Match {
      Mutable(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
        super(pSg, pVehicle, pLaneSegment);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends VehicleOnLaneSegment.Match {
      Immutable(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
        super(pSg, pVehicle, pLaneSegment);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.vehicleOnLaneSegment pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * // ===================================================================
   * // Lane Segment membership
   * // ===================================================================
   * 
   * pattern vehicleOnLaneSegment(sg: SceneGraph, vehicle: Vehicle, laneSegment: LaneSegment) {
   *     SceneGraph.nodes(sg, vehicle);
   *     SceneGraph.nodes(sg, road);
   *     Road.lanes(road, parentLane);
   *     Lane.laneSegments(parentLane, lane);
   * 
   *     Vehicle.x(vehicle, vehicleX);
   *     Vehicle.y(vehicle, vehicleY);
   * 
   *     LaneSegment.x(laneSegment, laneX);
   *     LaneSegment.y(laneSegment, laneY);
   * 
   *     Vehicle.heading(vehicle, vehicleHeading);
   *     LaneSegment.heading(laneSegment, laneSegmentHeading);
   * 
   *     LaneSegment.length(laneSegment, length);
   *     LaneSegment.width(laneSegment, width);
   * 
   *     check(
   *         Math.abs((vehicleX - laneX)  Math.cos(laneSegmentHeading) + (vehicleY - laneY)  Math.sin(laneSegmentHeading)) {@literal <}= length / 2.0 && 
   *         Math.abs(-(vehicleX - laneX)  Math.sin(laneSegmentHeading) + (vehicleY - laneY)  Math.cos(laneSegmentHeading)) {@literal <}= width / 2.0 
   *     );
   * 
   *     // Prevent membership being assigned to e.g. lanes going in the perpendicular direction at intersections
   *     check(
   *         Math.abs(Math.atan2(Math.sin(vehicleHeading - laneSegmentHeading), Math.cos(vehicleHeading - laneSegmentHeading))) {@literal <}= 0.15
   *     );
   * }
   * </pre></code>
   * 
   * @see Match
   * @see VehicleOnLaneSegment
   * 
   */
  public static class Matcher extends BaseMatcher<VehicleOnLaneSegment.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static VehicleOnLaneSegment.Matcher on(final ViatraQueryEngine engine) {
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
    public static VehicleOnLaneSegment.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SG = 0;

    private static final int POSITION_VEHICLE = 1;

    private static final int POSITION_LANESEGMENT = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VehicleOnLaneSegment.Matcher.class);

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
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<VehicleOnLaneSegment.Match> getAllMatches(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return rawStreamAllMatches(new Object[]{pSg, pVehicle, pLaneSegment}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<VehicleOnLaneSegment.Match> streamAllMatches(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return rawStreamAllMatches(new Object[]{pSg, pVehicle, pLaneSegment});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<VehicleOnLaneSegment.Match> getOneArbitraryMatch(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return rawGetOneArbitraryMatch(new Object[]{pSg, pVehicle, pLaneSegment});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return rawHasMatch(new Object[]{pSg, pVehicle, pLaneSegment});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return rawCountMatches(new Object[]{pSg, pVehicle, pLaneSegment});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment, final Consumer<? super VehicleOnLaneSegment.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSg, pVehicle, pLaneSegment}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLaneSegment the fixed value of pattern parameter laneSegment, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public VehicleOnLaneSegment.Match newMatch(final SceneGraph pSg, final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return VehicleOnLaneSegment.Match.newMatch(pSg, pVehicle, pLaneSegment);
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<SceneGraph> rawStreamAllValuesOfsg(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SG, parameters).map(SceneGraph.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg() {
      return rawStreamAllValuesOfsg(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<SceneGraph> streamAllValuesOfsg() {
      return rawStreamAllValuesOfsg(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SceneGraph> streamAllValuesOfsg(final VehicleOnLaneSegment.Match partialMatch) {
      return rawStreamAllValuesOfsg(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SceneGraph> streamAllValuesOfsg(final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return rawStreamAllValuesOfsg(new Object[]{null, pVehicle, pLaneSegment});
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final VehicleOnLaneSegment.Match partialMatch) {
      return rawStreamAllValuesOfsg(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final Vehicle pVehicle, final LaneSegment pLaneSegment) {
      return rawStreamAllValuesOfsg(new Object[]{null, pVehicle, pLaneSegment}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOfvehicle(final VehicleOnLaneSegment.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOfvehicle(final SceneGraph pSg, final LaneSegment pLaneSegment) {
      return rawStreamAllValuesOfvehicle(new Object[]{pSg, null, pLaneSegment});
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfvehicle(final VehicleOnLaneSegment.Match partialMatch) {
      return rawStreamAllValuesOfvehicle(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfvehicle(final SceneGraph pSg, final LaneSegment pLaneSegment) {
      return rawStreamAllValuesOfvehicle(new Object[]{pSg, null, pLaneSegment}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for laneSegment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<LaneSegment> rawStreamAllValuesOflaneSegment(final Object[] parameters) {
      return rawStreamAllValues(POSITION_LANESEGMENT, parameters).map(LaneSegment.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for laneSegment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LaneSegment> getAllValuesOflaneSegment() {
      return rawStreamAllValuesOflaneSegment(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for laneSegment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<LaneSegment> streamAllValuesOflaneSegment() {
      return rawStreamAllValuesOflaneSegment(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for laneSegment.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<LaneSegment> streamAllValuesOflaneSegment(final VehicleOnLaneSegment.Match partialMatch) {
      return rawStreamAllValuesOflaneSegment(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for laneSegment.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<LaneSegment> streamAllValuesOflaneSegment(final SceneGraph pSg, final Vehicle pVehicle) {
      return rawStreamAllValuesOflaneSegment(new Object[]{pSg, pVehicle, null});
    }

    /**
     * Retrieve the set of values that occur in matches for laneSegment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LaneSegment> getAllValuesOflaneSegment(final VehicleOnLaneSegment.Match partialMatch) {
      return rawStreamAllValuesOflaneSegment(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for laneSegment.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LaneSegment> getAllValuesOflaneSegment(final SceneGraph pSg, final Vehicle pVehicle) {
      return rawStreamAllValuesOflaneSegment(new Object[]{pSg, pVehicle, null}).collect(Collectors.toSet());
    }

    @Override
    protected VehicleOnLaneSegment.Match tupleToMatch(final Tuple t) {
      try {
          return VehicleOnLaneSegment.Match.newMatch((SceneGraph) t.get(POSITION_SG), (Vehicle) t.get(POSITION_VEHICLE), (LaneSegment) t.get(POSITION_LANESEGMENT));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected VehicleOnLaneSegment.Match arrayToMatch(final Object[] match) {
      try {
          return VehicleOnLaneSegment.Match.newMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_VEHICLE], (LaneSegment) match[POSITION_LANESEGMENT]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected VehicleOnLaneSegment.Match arrayToMatchMutable(final Object[] match) {
      try {
          return VehicleOnLaneSegment.Match.newMutableMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_VEHICLE], (LaneSegment) match[POSITION_LANESEGMENT]);
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
    public static IQuerySpecification<VehicleOnLaneSegment.Matcher> querySpecification() {
      return VehicleOnLaneSegment.instance();
    }
  }

  private VehicleOnLaneSegment() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static VehicleOnLaneSegment instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected VehicleOnLaneSegment.Matcher instantiate(final ViatraQueryEngine engine) {
    return VehicleOnLaneSegment.Matcher.on(engine);
  }

  @Override
  public VehicleOnLaneSegment.Matcher instantiate() {
    return VehicleOnLaneSegment.Matcher.create();
  }

  @Override
  public VehicleOnLaneSegment.Match newEmptyMatch() {
    return VehicleOnLaneSegment.Match.newEmptyMatch();
  }

  @Override
  public VehicleOnLaneSegment.Match newMatch(final Object... parameters) {
    return VehicleOnLaneSegment.Match.newMatch((SceneGraph) parameters[0], (Vehicle) parameters[1], (LaneSegment) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link VehicleOnLaneSegment} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link VehicleOnLaneSegment#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final VehicleOnLaneSegment INSTANCE = new VehicleOnLaneSegment();

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
    private static final VehicleOnLaneSegment.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_sg = new PParameter("sg", "ca.mcmaster.mt4sg.models.scenegraph.SceneGraph", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")), PParameterDirection.INOUT);

    private final PParameter parameter_vehicle = new PParameter("vehicle", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_laneSegment = new PParameter("laneSegment", "ca.mcmaster.mt4sg.models.scenegraph.LaneSegment", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_sg, parameter_vehicle, parameter_laneSegment);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.vehicleOnLaneSegment";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","vehicle","laneSegment");
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
          PVariable var_sg = body.getOrCreateVariableByName("sg");
          PVariable var_vehicle = body.getOrCreateVariableByName("vehicle");
          PVariable var_laneSegment = body.getOrCreateVariableByName("laneSegment");
          PVariable var_road = body.getOrCreateVariableByName("road");
          PVariable var_parentLane = body.getOrCreateVariableByName("parentLane");
          PVariable var_lane = body.getOrCreateVariableByName("lane");
          PVariable var_vehicleX = body.getOrCreateVariableByName("vehicleX");
          PVariable var_vehicleY = body.getOrCreateVariableByName("vehicleY");
          PVariable var_laneX = body.getOrCreateVariableByName("laneX");
          PVariable var_laneY = body.getOrCreateVariableByName("laneY");
          PVariable var_vehicleHeading = body.getOrCreateVariableByName("vehicleHeading");
          PVariable var_laneSegmentHeading = body.getOrCreateVariableByName("laneSegmentHeading");
          PVariable var_length = body.getOrCreateVariableByName("length");
          PVariable var_width = body.getOrCreateVariableByName("width");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sg, parameter_sg),
             new ExportedParameter(body, var_vehicle, parameter_vehicle),
             new ExportedParameter(body, var_laneSegment, parameter_laneSegment)
          ));
          //     SceneGraph.nodes(sg, vehicle)
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph", "nodes")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_0_, var_vehicle);
          //     SceneGraph.nodes(sg, road)
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph", "nodes")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_1_, var_road);
          //     Road.lanes(road, parentLane)
          new TypeConstraint(body, Tuples.flatTupleOf(var_road), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Road")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_road, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Road", "lanes")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Lane")));
          new Equality(body, var__virtual_2_, var_parentLane);
          //     Lane.laneSegments(parentLane, lane)
          new TypeConstraint(body, Tuples.flatTupleOf(var_parentLane), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Lane")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_parentLane, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Lane", "laneSegments")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          new Equality(body, var__virtual_3_, var_lane);
          //     Vehicle.x(vehicle, vehicleX)
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "x")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_4_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_4_, var_vehicleX);
          //     Vehicle.y(vehicle, vehicleY)
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle, var__virtual_5_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "y")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_5_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_5_, var_vehicleY);
          //     LaneSegment.x(laneSegment, laneX)
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment, var__virtual_6_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "x")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_6_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_6_, var_laneX);
          //     LaneSegment.y(laneSegment, laneY)
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment, var__virtual_7_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "y")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_7_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_7_, var_laneY);
          //     Vehicle.heading(vehicle, vehicleHeading)
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_8_ = body.getOrCreateVariableByName(".virtual{8}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle, var__virtual_8_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithOrientation", "heading")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_8_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_8_, var_vehicleHeading);
          //     LaneSegment.heading(laneSegment, laneSegmentHeading)
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          PVariable var__virtual_9_ = body.getOrCreateVariableByName(".virtual{9}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment, var__virtual_9_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithOrientation", "heading")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_9_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_9_, var_laneSegmentHeading);
          //     LaneSegment.length(laneSegment, length)
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          PVariable var__virtual_10_ = body.getOrCreateVariableByName(".virtual{10}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment, var__virtual_10_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithDimensions", "length")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_10_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_10_, var_length);
          //     LaneSegment.width(laneSegment, width)
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          PVariable var__virtual_11_ = body.getOrCreateVariableByName(".virtual{11}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_laneSegment, var__virtual_11_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithDimensions", "width")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_11_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_11_, var_width);
          //     check(        Math.abs((vehicleX - laneX) * Math.cos(laneSegmentHeading) + (vehicleY - laneY) * Math.sin(laneSegmentHeading)) <= length / 2.0 &&         Math.abs(-(vehicleX - laneX) * Math.sin(laneSegmentHeading) + (vehicleY - laneY) * Math.cos(laneSegmentHeading)) <= width / 2.0     )
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern vehicleOnLaneSegment";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("laneSegmentHeading", "laneX", "laneY", "length", "vehicleX", "vehicleY", "width");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Double laneSegmentHeading = (Double) provider.getValue("laneSegmentHeading");
                  Double laneX = (Double) provider.getValue("laneX");
                  Double laneY = (Double) provider.getValue("laneY");
                  Double length = (Double) provider.getValue("length");
                  Double vehicleX = (Double) provider.getValue("vehicleX");
                  Double vehicleY = (Double) provider.getValue("vehicleY");
                  Double width = (Double) provider.getValue("width");
                  return evaluateExpression_1_1(laneSegmentHeading, laneX, laneY, length, vehicleX, vehicleY, width);
              }
          },  null, false);
          //     // Prevent membership being assigned to e.g. lanes going in the perpendicular direction at intersections    check(        Math.abs(Math.atan2(Math.sin(vehicleHeading - laneSegmentHeading), Math.cos(vehicleHeading - laneSegmentHeading))) <= 0.15    )
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern vehicleOnLaneSegment";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("laneSegmentHeading", "vehicleHeading");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Double laneSegmentHeading = (Double) provider.getValue("laneSegmentHeading");
                  Double vehicleHeading = (Double) provider.getValue("vehicleHeading");
                  return evaluateExpression_1_2(laneSegmentHeading, vehicleHeading);
              }
          },  null, false);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static boolean evaluateExpression_1_1(final Double laneSegmentHeading, final Double laneX, final Double laneY, final Double length, final Double vehicleX, final Double vehicleY, final Double width) {
    return ((Math.abs(((DoubleExtensions.operator_minus(vehicleX, laneX) * Math.cos((laneSegmentHeading).doubleValue())) + (DoubleExtensions.operator_minus(vehicleY, laneY) * Math.sin((laneSegmentHeading).doubleValue())))) <= ((length).doubleValue() / 2.0)) && 
      (Math.abs((((-DoubleExtensions.operator_minus(vehicleX, laneX)) * Math.sin((laneSegmentHeading).doubleValue())) + (DoubleExtensions.operator_minus(vehicleY, laneY) * Math.cos((laneSegmentHeading).doubleValue())))) <= ((width).doubleValue() / 2.0)));
  }

  private static boolean evaluateExpression_1_2(final Double laneSegmentHeading, final Double vehicleHeading) {
    double _minus = DoubleExtensions.operator_minus(vehicleHeading, laneSegmentHeading);
    double _minus_1 = DoubleExtensions.operator_minus(vehicleHeading, laneSegmentHeading);
    double _abs = Math.abs(Math.atan2(Math.sin(_minus), Math.cos(_minus_1)));
    boolean _lessEqualsThan = (_abs <= 0.15);
    return _lessEqualsThan;
  }
}
