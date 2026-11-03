/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.SceneGraph;
import ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue;
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
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
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
 *         // ===================================================================
 *         // Value helper patterns
 *         // ===================================================================
 *         
 *         pattern distanceEdgeValue(
 *             sg: SceneGraph,
 *             v1: Vehicle,
 *             v2: Vehicle,
 *             distVal: SemanticDistanceValue
 *         ) {
 *             find distanceEdgeExists(sg, edge, v1, v2);
 *             Distance.value(edge, distVal);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class DistanceEdgeValue extends BaseGeneratedEMFQuerySpecification<DistanceEdgeValue.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.distanceEdgeValue pattern,
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

    private Vehicle fV1;

    private Vehicle fV2;

    private SemanticDistanceValue fDistVal;

    private static List<String> parameterNames = makeImmutableList("sg", "v1", "v2", "distVal");

    private Match(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      this.fSg = pSg;
      this.fV1 = pV1;
      this.fV2 = pV2;
      this.fDistVal = pDistVal;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "sg": return this.fSg;
          case "v1": return this.fV1;
          case "v2": return this.fV2;
          case "distVal": return this.fDistVal;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSg;
          case 1: return this.fV1;
          case 2: return this.fV2;
          case 3: return this.fDistVal;
          default: return null;
      }
    }

    public SceneGraph getSg() {
      return this.fSg;
    }

    public Vehicle getV1() {
      return this.fV1;
    }

    public Vehicle getV2() {
      return this.fV2;
    }

    public SemanticDistanceValue getDistVal() {
      return this.fDistVal;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("sg".equals(parameterName) ) {
          this.fSg = (SceneGraph) newValue;
          return true;
      }
      if ("v1".equals(parameterName) ) {
          this.fV1 = (Vehicle) newValue;
          return true;
      }
      if ("v2".equals(parameterName) ) {
          this.fV2 = (Vehicle) newValue;
          return true;
      }
      if ("distVal".equals(parameterName) ) {
          this.fDistVal = (SemanticDistanceValue) newValue;
          return true;
      }
      return false;
    }

    public void setSg(final SceneGraph pSg) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSg = pSg;
    }

    public void setV1(final Vehicle pV1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fV1 = pV1;
    }

    public void setV2(final Vehicle pV2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fV2 = pV2;
    }

    public void setDistVal(final SemanticDistanceValue pDistVal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDistVal = pDistVal;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.distanceEdgeValue";
    }

    @Override
    public List<String> parameterNames() {
      return DistanceEdgeValue.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSg, fV1, fV2, fDistVal};
    }

    @Override
    public DistanceEdgeValue.Match toImmutable() {
      return isMutable() ? newMatch(fSg, fV1, fV2, fDistVal) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
      result.append("\"v1\"=" + prettyPrintValue(fV1) + ", ");
      result.append("\"v2\"=" + prettyPrintValue(fV2) + ", ");
      result.append("\"distVal\"=" + prettyPrintValue(fDistVal));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSg, fV1, fV2, fDistVal);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof DistanceEdgeValue.Match)) {
          DistanceEdgeValue.Match other = (DistanceEdgeValue.Match) obj;
          return Objects.equals(fSg, other.fSg) && Objects.equals(fV1, other.fV1) && Objects.equals(fV2, other.fV2) && Objects.equals(fDistVal, other.fDistVal);
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
    public DistanceEdgeValue specification() {
      return DistanceEdgeValue.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static DistanceEdgeValue.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static DistanceEdgeValue.Match newMutableMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return new Mutable(pSg, pV1, pV2, pDistVal);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static DistanceEdgeValue.Match newMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return new Immutable(pSg, pV1, pV2, pDistVal);
    }

    private static final class Mutable extends DistanceEdgeValue.Match {
      Mutable(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
        super(pSg, pV1, pV2, pDistVal);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends DistanceEdgeValue.Match {
      Immutable(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
        super(pSg, pV1, pV2, pDistVal);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.distanceEdgeValue pattern,
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
   * // Value helper patterns
   * // ===================================================================
   * 
   * pattern distanceEdgeValue(
   *     sg: SceneGraph,
   *     v1: Vehicle,
   *     v2: Vehicle,
   *     distVal: SemanticDistanceValue
   * ) {
   *     find distanceEdgeExists(sg, edge, v1, v2);
   *     Distance.value(edge, distVal);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see DistanceEdgeValue
   * 
   */
  public static class Matcher extends BaseMatcher<DistanceEdgeValue.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static DistanceEdgeValue.Matcher on(final ViatraQueryEngine engine) {
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
    public static DistanceEdgeValue.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SG = 0;

    private static final int POSITION_V1 = 1;

    private static final int POSITION_V2 = 2;

    private static final int POSITION_DISTVAL = 3;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(DistanceEdgeValue.Matcher.class);

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
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<DistanceEdgeValue.Match> getAllMatches(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawStreamAllMatches(new Object[]{pSg, pV1, pV2, pDistVal}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<DistanceEdgeValue.Match> streamAllMatches(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawStreamAllMatches(new Object[]{pSg, pV1, pV2, pDistVal});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<DistanceEdgeValue.Match> getOneArbitraryMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawGetOneArbitraryMatch(new Object[]{pSg, pV1, pV2, pDistVal});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawHasMatch(new Object[]{pSg, pV1, pV2, pDistVal});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawCountMatches(new Object[]{pSg, pV1, pV2, pDistVal});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal, final Consumer<? super DistanceEdgeValue.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSg, pV1, pV2, pDistVal}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistVal the fixed value of pattern parameter distVal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public DistanceEdgeValue.Match newMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return DistanceEdgeValue.Match.newMatch(pSg, pV1, pV2, pDistVal);
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
    public Stream<SceneGraph> streamAllValuesOfsg(final DistanceEdgeValue.Match partialMatch) {
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
    public Stream<SceneGraph> streamAllValuesOfsg(final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawStreamAllValuesOfsg(new Object[]{null, pV1, pV2, pDistVal});
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final DistanceEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfsg(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final Vehicle pV1, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawStreamAllValuesOfsg(new Object[]{null, pV1, pV2, pDistVal}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vehicle> rawStreamAllValuesOfv1(final Object[] parameters) {
      return rawStreamAllValues(POSITION_V1, parameters).map(Vehicle.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv1() {
      return rawStreamAllValuesOfv1(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfv1() {
      return rawStreamAllValuesOfv1(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfv1(final DistanceEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfv1(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfv1(final SceneGraph pSg, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawStreamAllValuesOfv1(new Object[]{pSg, null, pV2, pDistVal});
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv1(final DistanceEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfv1(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv1(final SceneGraph pSg, final Vehicle pV2, final SemanticDistanceValue pDistVal) {
      return rawStreamAllValuesOfv1(new Object[]{pSg, null, pV2, pDistVal}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vehicle> rawStreamAllValuesOfv2(final Object[] parameters) {
      return rawStreamAllValues(POSITION_V2, parameters).map(Vehicle.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv2() {
      return rawStreamAllValuesOfv2(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfv2() {
      return rawStreamAllValuesOfv2(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfv2(final DistanceEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfv2(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfv2(final SceneGraph pSg, final Vehicle pV1, final SemanticDistanceValue pDistVal) {
      return rawStreamAllValuesOfv2(new Object[]{pSg, pV1, null, pDistVal});
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv2(final DistanceEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfv2(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv2(final SceneGraph pSg, final Vehicle pV1, final SemanticDistanceValue pDistVal) {
      return rawStreamAllValuesOfv2(new Object[]{pSg, pV1, null, pDistVal}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for distVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<SemanticDistanceValue> rawStreamAllValuesOfdistVal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DISTVAL, parameters).map(SemanticDistanceValue.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for distVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SemanticDistanceValue> getAllValuesOfdistVal() {
      return rawStreamAllValuesOfdistVal(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for distVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<SemanticDistanceValue> streamAllValuesOfdistVal() {
      return rawStreamAllValuesOfdistVal(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for distVal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SemanticDistanceValue> streamAllValuesOfdistVal(final DistanceEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfdistVal(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for distVal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SemanticDistanceValue> streamAllValuesOfdistVal(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfdistVal(new Object[]{pSg, pV1, pV2, null});
    }

    /**
     * Retrieve the set of values that occur in matches for distVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SemanticDistanceValue> getAllValuesOfdistVal(final DistanceEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfdistVal(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for distVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SemanticDistanceValue> getAllValuesOfdistVal(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfdistVal(new Object[]{pSg, pV1, pV2, null}).collect(Collectors.toSet());
    }

    @Override
    protected DistanceEdgeValue.Match tupleToMatch(final Tuple t) {
      try {
          return DistanceEdgeValue.Match.newMatch((SceneGraph) t.get(POSITION_SG), (Vehicle) t.get(POSITION_V1), (Vehicle) t.get(POSITION_V2), (SemanticDistanceValue) t.get(POSITION_DISTVAL));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected DistanceEdgeValue.Match arrayToMatch(final Object[] match) {
      try {
          return DistanceEdgeValue.Match.newMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_V1], (Vehicle) match[POSITION_V2], (SemanticDistanceValue) match[POSITION_DISTVAL]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected DistanceEdgeValue.Match arrayToMatchMutable(final Object[] match) {
      try {
          return DistanceEdgeValue.Match.newMutableMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_V1], (Vehicle) match[POSITION_V2], (SemanticDistanceValue) match[POSITION_DISTVAL]);
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
    public static IQuerySpecification<DistanceEdgeValue.Matcher> querySpecification() {
      return DistanceEdgeValue.instance();
    }
  }

  private DistanceEdgeValue() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static DistanceEdgeValue instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected DistanceEdgeValue.Matcher instantiate(final ViatraQueryEngine engine) {
    return DistanceEdgeValue.Matcher.on(engine);
  }

  @Override
  public DistanceEdgeValue.Matcher instantiate() {
    return DistanceEdgeValue.Matcher.create();
  }

  @Override
  public DistanceEdgeValue.Match newEmptyMatch() {
    return DistanceEdgeValue.Match.newEmptyMatch();
  }

  @Override
  public DistanceEdgeValue.Match newMatch(final Object... parameters) {
    return DistanceEdgeValue.Match.newMatch((SceneGraph) parameters[0], (Vehicle) parameters[1], (Vehicle) parameters[2], (SemanticDistanceValue) parameters[3]);
  }

  /**
   * Inner class allowing the singleton instance of {@link DistanceEdgeValue} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link DistanceEdgeValue#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final DistanceEdgeValue INSTANCE = new DistanceEdgeValue();

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
    private static final DistanceEdgeValue.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_sg = new PParameter("sg", "ca.mcmaster.mt4sg.models.scenegraph.SceneGraph", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")), PParameterDirection.INOUT);

    private final PParameter parameter_v1 = new PParameter("v1", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_v2 = new PParameter("v2", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_distVal = new PParameter("distVal", "ca.mcmaster.mt4sg.models.scenegraph.SemanticDistanceValue", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SemanticDistanceValue")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_sg, parameter_v1, parameter_v2, parameter_distVal);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.distanceEdgeValue";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","v1","v2","distVal");
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
          PVariable var_v1 = body.getOrCreateVariableByName("v1");
          PVariable var_v2 = body.getOrCreateVariableByName("v2");
          PVariable var_distVal = body.getOrCreateVariableByName("distVal");
          PVariable var_edge = body.getOrCreateVariableByName("edge");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_distVal), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SemanticDistanceValue")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sg, parameter_sg),
             new ExportedParameter(body, var_v1, parameter_v1),
             new ExportedParameter(body, var_v2, parameter_v2),
             new ExportedParameter(body, var_distVal, parameter_distVal)
          ));
          //     find distanceEdgeExists(sg, edge, v1, v2)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_sg, var_edge, var_v1, var_v2), DistanceEdgeExists.instance().getInternalQueryRepresentation());
          //     Distance.value(edge, distVal)
          new TypeConstraint(body, Tuples.flatTupleOf(var_edge), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_edge, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SemanticDistanceValue")));
          new Equality(body, var__virtual_0_, var_distVal);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
