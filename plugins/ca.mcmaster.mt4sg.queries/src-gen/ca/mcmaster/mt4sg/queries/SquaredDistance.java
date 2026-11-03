/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

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
import org.eclipse.viatra.query.runtime.matchers.context.common.JavaTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
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
 *         // ===================================================================
 *         // Proximity distance patterns
 *         // ===================================================================
 *         
 *         pattern squaredDistance(sg: SceneGraph, v1: Vehicle, v2: Vehicle, distSq: java Double) {
 *             find vehiclesInASceneGraph(sg, v1, v2);
 *         
 *             Vehicle.x(v1, sourceX);
 *             Vehicle.y(v1, sourceY);
 *         
 *             Vehicle.x(v2, targetX);
 *             Vehicle.y(v2, targetY);
 *         
 *             distSq == eval(
 *                 (sourceX - targetX)  (sourceX - targetX) + (sourceY - targetY)  (sourceY - targetY)
 *             );
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SquaredDistance extends BaseGeneratedEMFQuerySpecification<SquaredDistance.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.squaredDistance pattern,
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

    private Double fDistSq;

    private static List<String> parameterNames = makeImmutableList("sg", "v1", "v2", "distSq");

    private Match(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      this.fSg = pSg;
      this.fV1 = pV1;
      this.fV2 = pV2;
      this.fDistSq = pDistSq;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "sg": return this.fSg;
          case "v1": return this.fV1;
          case "v2": return this.fV2;
          case "distSq": return this.fDistSq;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSg;
          case 1: return this.fV1;
          case 2: return this.fV2;
          case 3: return this.fDistSq;
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

    public Double getDistSq() {
      return this.fDistSq;
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
      if ("distSq".equals(parameterName) ) {
          this.fDistSq = (Double) newValue;
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

    public void setDistSq(final Double pDistSq) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fDistSq = pDistSq;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.squaredDistance";
    }

    @Override
    public List<String> parameterNames() {
      return SquaredDistance.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSg, fV1, fV2, fDistSq};
    }

    @Override
    public SquaredDistance.Match toImmutable() {
      return isMutable() ? newMatch(fSg, fV1, fV2, fDistSq) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
      result.append("\"v1\"=" + prettyPrintValue(fV1) + ", ");
      result.append("\"v2\"=" + prettyPrintValue(fV2) + ", ");
      result.append("\"distSq\"=" + prettyPrintValue(fDistSq));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSg, fV1, fV2, fDistSq);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SquaredDistance.Match)) {
          SquaredDistance.Match other = (SquaredDistance.Match) obj;
          return Objects.equals(fSg, other.fSg) && Objects.equals(fV1, other.fV1) && Objects.equals(fV2, other.fV2) && Objects.equals(fDistSq, other.fDistSq);
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
    public SquaredDistance specification() {
      return SquaredDistance.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SquaredDistance.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SquaredDistance.Match newMutableMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return new Mutable(pSg, pV1, pV2, pDistSq);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SquaredDistance.Match newMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return new Immutable(pSg, pV1, pV2, pDistSq);
    }

    private static final class Mutable extends SquaredDistance.Match {
      Mutable(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
        super(pSg, pV1, pV2, pDistSq);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SquaredDistance.Match {
      Immutable(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
        super(pSg, pV1, pV2, pDistSq);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.squaredDistance pattern,
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
   * // Proximity distance patterns
   * // ===================================================================
   * 
   * pattern squaredDistance(sg: SceneGraph, v1: Vehicle, v2: Vehicle, distSq: java Double) {
   *     find vehiclesInASceneGraph(sg, v1, v2);
   * 
   *     Vehicle.x(v1, sourceX);
   *     Vehicle.y(v1, sourceY);
   * 
   *     Vehicle.x(v2, targetX);
   *     Vehicle.y(v2, targetY);
   * 
   *     distSq == eval(
   *         (sourceX - targetX)  (sourceX - targetX) + (sourceY - targetY)  (sourceY - targetY)
   *     );
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SquaredDistance
   * 
   */
  public static class Matcher extends BaseMatcher<SquaredDistance.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SquaredDistance.Matcher on(final ViatraQueryEngine engine) {
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
    public static SquaredDistance.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SG = 0;

    private static final int POSITION_V1 = 1;

    private static final int POSITION_V2 = 2;

    private static final int POSITION_DISTSQ = 3;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SquaredDistance.Matcher.class);

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
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SquaredDistance.Match> getAllMatches(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return rawStreamAllMatches(new Object[]{pSg, pV1, pV2, pDistSq}).collect(Collectors.toSet());
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
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SquaredDistance.Match> streamAllMatches(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return rawStreamAllMatches(new Object[]{pSg, pV1, pV2, pDistSq});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SquaredDistance.Match> getOneArbitraryMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return rawGetOneArbitraryMatch(new Object[]{pSg, pV1, pV2, pDistSq});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return rawHasMatch(new Object[]{pSg, pV1, pV2, pDistSq});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return rawCountMatches(new Object[]{pSg, pV1, pV2, pDistSq});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq, final Consumer<? super SquaredDistance.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSg, pV1, pV2, pDistSq}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param pDistSq the fixed value of pattern parameter distSq, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SquaredDistance.Match newMatch(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return SquaredDistance.Match.newMatch(pSg, pV1, pV2, pDistSq);
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
    public Stream<SceneGraph> streamAllValuesOfsg(final SquaredDistance.Match partialMatch) {
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
    public Stream<SceneGraph> streamAllValuesOfsg(final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return rawStreamAllValuesOfsg(new Object[]{null, pV1, pV2, pDistSq});
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final SquaredDistance.Match partialMatch) {
      return rawStreamAllValuesOfsg(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final Vehicle pV1, final Vehicle pV2, final Double pDistSq) {
      return rawStreamAllValuesOfsg(new Object[]{null, pV1, pV2, pDistSq}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOfv1(final SquaredDistance.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOfv1(final SceneGraph pSg, final Vehicle pV2, final Double pDistSq) {
      return rawStreamAllValuesOfv1(new Object[]{pSg, null, pV2, pDistSq});
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv1(final SquaredDistance.Match partialMatch) {
      return rawStreamAllValuesOfv1(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv1(final SceneGraph pSg, final Vehicle pV2, final Double pDistSq) {
      return rawStreamAllValuesOfv1(new Object[]{pSg, null, pV2, pDistSq}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOfv2(final SquaredDistance.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOfv2(final SceneGraph pSg, final Vehicle pV1, final Double pDistSq) {
      return rawStreamAllValuesOfv2(new Object[]{pSg, pV1, null, pDistSq});
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv2(final SquaredDistance.Match partialMatch) {
      return rawStreamAllValuesOfv2(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv2(final SceneGraph pSg, final Vehicle pV1, final Double pDistSq) {
      return rawStreamAllValuesOfv2(new Object[]{pSg, pV1, null, pDistSq}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for distSq.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Double> rawStreamAllValuesOfdistSq(final Object[] parameters) {
      return rawStreamAllValues(POSITION_DISTSQ, parameters).map(Double.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for distSq.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Double> getAllValuesOfdistSq() {
      return rawStreamAllValuesOfdistSq(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for distSq.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Double> streamAllValuesOfdistSq() {
      return rawStreamAllValuesOfdistSq(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for distSq.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Double> streamAllValuesOfdistSq(final SquaredDistance.Match partialMatch) {
      return rawStreamAllValuesOfdistSq(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for distSq.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Double> streamAllValuesOfdistSq(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfdistSq(new Object[]{pSg, pV1, pV2, null});
    }

    /**
     * Retrieve the set of values that occur in matches for distSq.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Double> getAllValuesOfdistSq(final SquaredDistance.Match partialMatch) {
      return rawStreamAllValuesOfdistSq(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for distSq.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Double> getAllValuesOfdistSq(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfdistSq(new Object[]{pSg, pV1, pV2, null}).collect(Collectors.toSet());
    }

    @Override
    protected SquaredDistance.Match tupleToMatch(final Tuple t) {
      try {
          return SquaredDistance.Match.newMatch((SceneGraph) t.get(POSITION_SG), (Vehicle) t.get(POSITION_V1), (Vehicle) t.get(POSITION_V2), (Double) t.get(POSITION_DISTSQ));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SquaredDistance.Match arrayToMatch(final Object[] match) {
      try {
          return SquaredDistance.Match.newMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_V1], (Vehicle) match[POSITION_V2], (Double) match[POSITION_DISTSQ]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SquaredDistance.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SquaredDistance.Match.newMutableMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_V1], (Vehicle) match[POSITION_V2], (Double) match[POSITION_DISTSQ]);
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
    public static IQuerySpecification<SquaredDistance.Matcher> querySpecification() {
      return SquaredDistance.instance();
    }
  }

  private SquaredDistance() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SquaredDistance instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected SquaredDistance.Matcher instantiate(final ViatraQueryEngine engine) {
    return SquaredDistance.Matcher.on(engine);
  }

  @Override
  public SquaredDistance.Matcher instantiate() {
    return SquaredDistance.Matcher.create();
  }

  @Override
  public SquaredDistance.Match newEmptyMatch() {
    return SquaredDistance.Match.newEmptyMatch();
  }

  @Override
  public SquaredDistance.Match newMatch(final Object... parameters) {
    return SquaredDistance.Match.newMatch((SceneGraph) parameters[0], (Vehicle) parameters[1], (Vehicle) parameters[2], (Double) parameters[3]);
  }

  /**
   * Inner class allowing the singleton instance of {@link SquaredDistance} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SquaredDistance#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SquaredDistance INSTANCE = new SquaredDistance();

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
    private static final SquaredDistance.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_sg = new PParameter("sg", "ca.mcmaster.mt4sg.models.scenegraph.SceneGraph", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")), PParameterDirection.INOUT);

    private final PParameter parameter_v1 = new PParameter("v1", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_v2 = new PParameter("v2", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_distSq = new PParameter("distSq", "java.lang.Double", new JavaTransitiveInstancesKey(java.lang.Double.class), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_sg, parameter_v1, parameter_v2, parameter_distSq);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.squaredDistance";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","v1","v2","distSq");
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
          PVariable var_distSq = body.getOrCreateVariableByName("distSq");
          PVariable var_sourceX = body.getOrCreateVariableByName("sourceX");
          PVariable var_sourceY = body.getOrCreateVariableByName("sourceY");
          PVariable var_targetX = body.getOrCreateVariableByName("targetX");
          PVariable var_targetY = body.getOrCreateVariableByName("targetY");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeFilterConstraint(body, Tuples.flatTupleOf(var_distSq), new JavaTransitiveInstancesKey(java.lang.Double.class));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sg, parameter_sg),
             new ExportedParameter(body, var_v1, parameter_v1),
             new ExportedParameter(body, var_v2, parameter_v2),
             new ExportedParameter(body, var_distSq, parameter_distSq)
          ));
          //     find vehiclesInASceneGraph(sg, v1, v2)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_sg, var_v1, var_v2), VehiclesInASceneGraph.instance().getInternalQueryRepresentation());
          //     Vehicle.x(v1, sourceX)
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "x")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_0_, var_sourceX);
          //     Vehicle.y(v1, sourceY)
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "y")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_1_, var_sourceY);
          //     Vehicle.x(v2, targetX)
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "x")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_2_, var_targetX);
          //     Vehicle.y(v2, targetY)
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "IObjectWithLocation", "y")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_3_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://www.eclipse.org/emf/2002/Ecore", "EDouble")));
          new Equality(body, var__virtual_3_, var_targetY);
          //     distSq == eval(        (sourceX - targetX) * (sourceX - targetX) + (sourceY - targetY) * (sourceY - targetY)    )
          PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern squaredDistance";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("sourceX", "sourceY", "targetX", "targetY");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Double sourceX = (Double) provider.getValue("sourceX");
                  Double sourceY = (Double) provider.getValue("sourceY");
                  Double targetX = (Double) provider.getValue("targetX");
                  Double targetY = (Double) provider.getValue("targetY");
                  return evaluateExpression_1_1(sourceX, sourceY, targetX, targetY);
              }
          },  var__virtual_4_ , false);
          new Equality(body, var_distSq, var__virtual_4_);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static double evaluateExpression_1_1(final Double sourceX, final Double sourceY, final Double targetX, final Double targetY) {
    double _minus = DoubleExtensions.operator_minus(sourceX, targetX);
    double _minus_1 = DoubleExtensions.operator_minus(sourceX, targetX);
    double _multiply = (_minus * _minus_1);
    double _minus_2 = DoubleExtensions.operator_minus(sourceY, targetY);
    double _minus_3 = DoubleExtensions.operator_minus(sourceY, targetY);
    double _multiply_1 = (_minus_2 * _minus_3);
    double _plus = (_multiply + _multiply_1);
    return _plus;
  }
}
