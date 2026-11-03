/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.LaneSegment;
import ca.mcmaster.mt4sg.models.scenegraph.Vehicle;
import ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment;
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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PParameterDirection;
import org.eclipse.viatra.query.runtime.matchers.psystem.queries.PVisibility;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuple;
import org.eclipse.viatra.query.runtime.matchers.tuple.Tuples;
import org.eclipse.viatra.query.runtime.util.ViatraQueryLoggingUtil;

/**
 * A pattern-specific query specification that can instantiate Matcher in a type-safe way.
 * 
 * <p>Original source:
 *         <code><pre>
 *         pattern vehicleOnLaneSegmentEdgeToBeRemoved(e: VehicleInLaneSegment, vehicle: Vehicle, lane: LaneSegment) {
 *             VehicleInLaneSegment.source(e, vehicle);
 *             VehicleInLaneSegment.target(e, lane);
 *         
 *             neg find vehicleOnLaneSegment(_sg, vehicle, lane);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class VehicleOnLaneSegmentEdgeToBeRemoved extends BaseGeneratedEMFQuerySpecification<VehicleOnLaneSegmentEdgeToBeRemoved.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.vehicleOnLaneSegmentEdgeToBeRemoved pattern,
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
    private VehicleInLaneSegment fE;

    private Vehicle fVehicle;

    private LaneSegment fLane;

    private static List<String> parameterNames = makeImmutableList("e", "vehicle", "lane");

    private Match(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      this.fE = pE;
      this.fVehicle = pVehicle;
      this.fLane = pLane;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "e": return this.fE;
          case "vehicle": return this.fVehicle;
          case "lane": return this.fLane;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fE;
          case 1: return this.fVehicle;
          case 2: return this.fLane;
          default: return null;
      }
    }

    public VehicleInLaneSegment getE() {
      return this.fE;
    }

    public Vehicle getVehicle() {
      return this.fVehicle;
    }

    public LaneSegment getLane() {
      return this.fLane;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("e".equals(parameterName) ) {
          this.fE = (VehicleInLaneSegment) newValue;
          return true;
      }
      if ("vehicle".equals(parameterName) ) {
          this.fVehicle = (Vehicle) newValue;
          return true;
      }
      if ("lane".equals(parameterName) ) {
          this.fLane = (LaneSegment) newValue;
          return true;
      }
      return false;
    }

    public void setE(final VehicleInLaneSegment pE) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fE = pE;
    }

    public void setVehicle(final Vehicle pVehicle) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fVehicle = pVehicle;
    }

    public void setLane(final LaneSegment pLane) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fLane = pLane;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.vehicleOnLaneSegmentEdgeToBeRemoved";
    }

    @Override
    public List<String> parameterNames() {
      return VehicleOnLaneSegmentEdgeToBeRemoved.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fE, fVehicle, fLane};
    }

    @Override
    public VehicleOnLaneSegmentEdgeToBeRemoved.Match toImmutable() {
      return isMutable() ? newMatch(fE, fVehicle, fLane) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"e\"=" + prettyPrintValue(fE) + ", ");
      result.append("\"vehicle\"=" + prettyPrintValue(fVehicle) + ", ");
      result.append("\"lane\"=" + prettyPrintValue(fLane));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fE, fVehicle, fLane);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof VehicleOnLaneSegmentEdgeToBeRemoved.Match)) {
          VehicleOnLaneSegmentEdgeToBeRemoved.Match other = (VehicleOnLaneSegmentEdgeToBeRemoved.Match) obj;
          return Objects.equals(fE, other.fE) && Objects.equals(fVehicle, other.fVehicle) && Objects.equals(fLane, other.fLane);
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
    public VehicleOnLaneSegmentEdgeToBeRemoved specification() {
      return VehicleOnLaneSegmentEdgeToBeRemoved.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static VehicleOnLaneSegmentEdgeToBeRemoved.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static VehicleOnLaneSegmentEdgeToBeRemoved.Match newMutableMatch(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return new Mutable(pE, pVehicle, pLane);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static VehicleOnLaneSegmentEdgeToBeRemoved.Match newMatch(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return new Immutable(pE, pVehicle, pLane);
    }

    private static final class Mutable extends VehicleOnLaneSegmentEdgeToBeRemoved.Match {
      Mutable(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
        super(pE, pVehicle, pLane);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends VehicleOnLaneSegmentEdgeToBeRemoved.Match {
      Immutable(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
        super(pE, pVehicle, pLane);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.vehicleOnLaneSegmentEdgeToBeRemoved pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern vehicleOnLaneSegmentEdgeToBeRemoved(e: VehicleInLaneSegment, vehicle: Vehicle, lane: LaneSegment) {
   *     VehicleInLaneSegment.source(e, vehicle);
   *     VehicleInLaneSegment.target(e, lane);
   * 
   *     neg find vehicleOnLaneSegment(_sg, vehicle, lane);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see VehicleOnLaneSegmentEdgeToBeRemoved
   * 
   */
  public static class Matcher extends BaseMatcher<VehicleOnLaneSegmentEdgeToBeRemoved.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static VehicleOnLaneSegmentEdgeToBeRemoved.Matcher on(final ViatraQueryEngine engine) {
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
    public static VehicleOnLaneSegmentEdgeToBeRemoved.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_E = 0;

    private static final int POSITION_VEHICLE = 1;

    private static final int POSITION_LANE = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(VehicleOnLaneSegmentEdgeToBeRemoved.Matcher.class);

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
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<VehicleOnLaneSegmentEdgeToBeRemoved.Match> getAllMatches(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return rawStreamAllMatches(new Object[]{pE, pVehicle, pLane}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<VehicleOnLaneSegmentEdgeToBeRemoved.Match> streamAllMatches(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return rawStreamAllMatches(new Object[]{pE, pVehicle, pLane});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<VehicleOnLaneSegmentEdgeToBeRemoved.Match> getOneArbitraryMatch(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return rawGetOneArbitraryMatch(new Object[]{pE, pVehicle, pLane});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return rawHasMatch(new Object[]{pE, pVehicle, pLane});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return rawCountMatches(new Object[]{pE, pVehicle, pLane});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane, final Consumer<? super VehicleOnLaneSegmentEdgeToBeRemoved.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pE, pVehicle, pLane}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pVehicle the fixed value of pattern parameter vehicle, or null if not bound.
     * @param pLane the fixed value of pattern parameter lane, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public VehicleOnLaneSegmentEdgeToBeRemoved.Match newMatch(final VehicleInLaneSegment pE, final Vehicle pVehicle, final LaneSegment pLane) {
      return VehicleOnLaneSegmentEdgeToBeRemoved.Match.newMatch(pE, pVehicle, pLane);
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<VehicleInLaneSegment> rawStreamAllValuesOfe(final Object[] parameters) {
      return rawStreamAllValues(POSITION_E, parameters).map(VehicleInLaneSegment.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<VehicleInLaneSegment> getAllValuesOfe() {
      return rawStreamAllValuesOfe(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<VehicleInLaneSegment> streamAllValuesOfe() {
      return rawStreamAllValuesOfe(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<VehicleInLaneSegment> streamAllValuesOfe(final VehicleOnLaneSegmentEdgeToBeRemoved.Match partialMatch) {
      return rawStreamAllValuesOfe(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<VehicleInLaneSegment> streamAllValuesOfe(final Vehicle pVehicle, final LaneSegment pLane) {
      return rawStreamAllValuesOfe(new Object[]{null, pVehicle, pLane});
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<VehicleInLaneSegment> getAllValuesOfe(final VehicleOnLaneSegmentEdgeToBeRemoved.Match partialMatch) {
      return rawStreamAllValuesOfe(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<VehicleInLaneSegment> getAllValuesOfe(final Vehicle pVehicle, final LaneSegment pLane) {
      return rawStreamAllValuesOfe(new Object[]{null, pVehicle, pLane}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOfvehicle(final VehicleOnLaneSegmentEdgeToBeRemoved.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOfvehicle(final VehicleInLaneSegment pE, final LaneSegment pLane) {
      return rawStreamAllValuesOfvehicle(new Object[]{pE, null, pLane});
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfvehicle(final VehicleOnLaneSegmentEdgeToBeRemoved.Match partialMatch) {
      return rawStreamAllValuesOfvehicle(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for vehicle.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfvehicle(final VehicleInLaneSegment pE, final LaneSegment pLane) {
      return rawStreamAllValuesOfvehicle(new Object[]{pE, null, pLane}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for lane.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<LaneSegment> rawStreamAllValuesOflane(final Object[] parameters) {
      return rawStreamAllValues(POSITION_LANE, parameters).map(LaneSegment.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for lane.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LaneSegment> getAllValuesOflane() {
      return rawStreamAllValuesOflane(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for lane.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<LaneSegment> streamAllValuesOflane() {
      return rawStreamAllValuesOflane(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for lane.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<LaneSegment> streamAllValuesOflane(final VehicleOnLaneSegmentEdgeToBeRemoved.Match partialMatch) {
      return rawStreamAllValuesOflane(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for lane.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<LaneSegment> streamAllValuesOflane(final VehicleInLaneSegment pE, final Vehicle pVehicle) {
      return rawStreamAllValuesOflane(new Object[]{pE, pVehicle, null});
    }

    /**
     * Retrieve the set of values that occur in matches for lane.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LaneSegment> getAllValuesOflane(final VehicleOnLaneSegmentEdgeToBeRemoved.Match partialMatch) {
      return rawStreamAllValuesOflane(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for lane.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<LaneSegment> getAllValuesOflane(final VehicleInLaneSegment pE, final Vehicle pVehicle) {
      return rawStreamAllValuesOflane(new Object[]{pE, pVehicle, null}).collect(Collectors.toSet());
    }

    @Override
    protected VehicleOnLaneSegmentEdgeToBeRemoved.Match tupleToMatch(final Tuple t) {
      try {
          return VehicleOnLaneSegmentEdgeToBeRemoved.Match.newMatch((VehicleInLaneSegment) t.get(POSITION_E), (Vehicle) t.get(POSITION_VEHICLE), (LaneSegment) t.get(POSITION_LANE));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected VehicleOnLaneSegmentEdgeToBeRemoved.Match arrayToMatch(final Object[] match) {
      try {
          return VehicleOnLaneSegmentEdgeToBeRemoved.Match.newMatch((VehicleInLaneSegment) match[POSITION_E], (Vehicle) match[POSITION_VEHICLE], (LaneSegment) match[POSITION_LANE]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected VehicleOnLaneSegmentEdgeToBeRemoved.Match arrayToMatchMutable(final Object[] match) {
      try {
          return VehicleOnLaneSegmentEdgeToBeRemoved.Match.newMutableMatch((VehicleInLaneSegment) match[POSITION_E], (Vehicle) match[POSITION_VEHICLE], (LaneSegment) match[POSITION_LANE]);
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
    public static IQuerySpecification<VehicleOnLaneSegmentEdgeToBeRemoved.Matcher> querySpecification() {
      return VehicleOnLaneSegmentEdgeToBeRemoved.instance();
    }
  }

  private VehicleOnLaneSegmentEdgeToBeRemoved() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static VehicleOnLaneSegmentEdgeToBeRemoved instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected VehicleOnLaneSegmentEdgeToBeRemoved.Matcher instantiate(final ViatraQueryEngine engine) {
    return VehicleOnLaneSegmentEdgeToBeRemoved.Matcher.on(engine);
  }

  @Override
  public VehicleOnLaneSegmentEdgeToBeRemoved.Matcher instantiate() {
    return VehicleOnLaneSegmentEdgeToBeRemoved.Matcher.create();
  }

  @Override
  public VehicleOnLaneSegmentEdgeToBeRemoved.Match newEmptyMatch() {
    return VehicleOnLaneSegmentEdgeToBeRemoved.Match.newEmptyMatch();
  }

  @Override
  public VehicleOnLaneSegmentEdgeToBeRemoved.Match newMatch(final Object... parameters) {
    return VehicleOnLaneSegmentEdgeToBeRemoved.Match.newMatch((VehicleInLaneSegment) parameters[0], (Vehicle) parameters[1], (LaneSegment) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link VehicleOnLaneSegmentEdgeToBeRemoved} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link VehicleOnLaneSegmentEdgeToBeRemoved#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final VehicleOnLaneSegmentEdgeToBeRemoved INSTANCE = new VehicleOnLaneSegmentEdgeToBeRemoved();

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
    private static final VehicleOnLaneSegmentEdgeToBeRemoved.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_e = new PParameter("e", "ca.mcmaster.mt4sg.models.scenegraph.VehicleInLaneSegment", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "VehicleInLaneSegment")), PParameterDirection.INOUT);

    private final PParameter parameter_vehicle = new PParameter("vehicle", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_lane = new PParameter("lane", "ca.mcmaster.mt4sg.models.scenegraph.LaneSegment", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_e, parameter_vehicle, parameter_lane);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.vehicleOnLaneSegmentEdgeToBeRemoved";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("e","vehicle","lane");
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
          PVariable var_e = body.getOrCreateVariableByName("e");
          PVariable var_vehicle = body.getOrCreateVariableByName("vehicle");
          PVariable var_lane = body.getOrCreateVariableByName("lane");
          PVariable var__sg = body.getOrCreateVariableByName("_sg");
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "VehicleInLaneSegment")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_vehicle), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_lane), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "LaneSegment")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_e, parameter_e),
             new ExportedParameter(body, var_vehicle, parameter_vehicle),
             new ExportedParameter(body, var_lane, parameter_lane)
          ));
          //     VehicleInLaneSegment.source(e, vehicle)
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "VehicleInLaneSegment")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_e, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_0_, var_vehicle);
          //     VehicleInLaneSegment.target(e, lane)
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "VehicleInLaneSegment")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_e, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_1_, var_lane);
          //     neg find vehicleOnLaneSegment(_sg, vehicle, lane)
          new NegativePatternCall(body, Tuples.flatTupleOf(var__sg, var_vehicle, var_lane), VehicleOnLaneSegment.instance().getInternalQueryRepresentation());
          bodies.add(body);
      }
      return bodies;
    }
  }
}
