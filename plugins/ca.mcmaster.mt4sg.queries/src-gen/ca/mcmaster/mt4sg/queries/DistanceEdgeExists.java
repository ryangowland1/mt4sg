/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.Distance;
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
 *         // Typed edge-existence helpers
 *         // ===================================================================
 *         
 *         pattern distanceEdgeExists(sg: SceneGraph, e: Distance, v1: Vehicle, v2: Vehicle) {
 *             SceneGraph.edges(sg, e);
 *             Distance.source(e, v1);
 *             Distance.target(e, v2);
 *         } or {
 *             SceneGraph.edges(sg, e);
 *             Distance.source(e, v2);
 *             Distance.target(e, v1);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class DistanceEdgeExists extends BaseGeneratedEMFQuerySpecification<DistanceEdgeExists.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.distanceEdgeExists pattern,
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

    private Distance fE;

    private Vehicle fV1;

    private Vehicle fV2;

    private static List<String> parameterNames = makeImmutableList("sg", "e", "v1", "v2");

    private Match(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      this.fSg = pSg;
      this.fE = pE;
      this.fV1 = pV1;
      this.fV2 = pV2;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "sg": return this.fSg;
          case "e": return this.fE;
          case "v1": return this.fV1;
          case "v2": return this.fV2;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSg;
          case 1: return this.fE;
          case 2: return this.fV1;
          case 3: return this.fV2;
          default: return null;
      }
    }

    public SceneGraph getSg() {
      return this.fSg;
    }

    public Distance getE() {
      return this.fE;
    }

    public Vehicle getV1() {
      return this.fV1;
    }

    public Vehicle getV2() {
      return this.fV2;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("sg".equals(parameterName) ) {
          this.fSg = (SceneGraph) newValue;
          return true;
      }
      if ("e".equals(parameterName) ) {
          this.fE = (Distance) newValue;
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
      return false;
    }

    public void setSg(final SceneGraph pSg) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSg = pSg;
    }

    public void setE(final Distance pE) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fE = pE;
    }

    public void setV1(final Vehicle pV1) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fV1 = pV1;
    }

    public void setV2(final Vehicle pV2) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fV2 = pV2;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.distanceEdgeExists";
    }

    @Override
    public List<String> parameterNames() {
      return DistanceEdgeExists.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSg, fE, fV1, fV2};
    }

    @Override
    public DistanceEdgeExists.Match toImmutable() {
      return isMutable() ? newMatch(fSg, fE, fV1, fV2) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
      result.append("\"e\"=" + prettyPrintValue(fE) + ", ");
      result.append("\"v1\"=" + prettyPrintValue(fV1) + ", ");
      result.append("\"v2\"=" + prettyPrintValue(fV2));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSg, fE, fV1, fV2);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof DistanceEdgeExists.Match)) {
          DistanceEdgeExists.Match other = (DistanceEdgeExists.Match) obj;
          return Objects.equals(fSg, other.fSg) && Objects.equals(fE, other.fE) && Objects.equals(fV1, other.fV1) && Objects.equals(fV2, other.fV2);
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
    public DistanceEdgeExists specification() {
      return DistanceEdgeExists.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static DistanceEdgeExists.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static DistanceEdgeExists.Match newMutableMatch(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return new Mutable(pSg, pE, pV1, pV2);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static DistanceEdgeExists.Match newMatch(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return new Immutable(pSg, pE, pV1, pV2);
    }

    private static final class Mutable extends DistanceEdgeExists.Match {
      Mutable(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
        super(pSg, pE, pV1, pV2);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends DistanceEdgeExists.Match {
      Immutable(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
        super(pSg, pE, pV1, pV2);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.distanceEdgeExists pattern,
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
   * // Typed edge-existence helpers
   * // ===================================================================
   * 
   * pattern distanceEdgeExists(sg: SceneGraph, e: Distance, v1: Vehicle, v2: Vehicle) {
   *     SceneGraph.edges(sg, e);
   *     Distance.source(e, v1);
   *     Distance.target(e, v2);
   * } or {
   *     SceneGraph.edges(sg, e);
   *     Distance.source(e, v2);
   *     Distance.target(e, v1);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see DistanceEdgeExists
   * 
   */
  public static class Matcher extends BaseMatcher<DistanceEdgeExists.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static DistanceEdgeExists.Matcher on(final ViatraQueryEngine engine) {
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
    public static DistanceEdgeExists.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SG = 0;

    private static final int POSITION_E = 1;

    private static final int POSITION_V1 = 2;

    private static final int POSITION_V2 = 3;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(DistanceEdgeExists.Matcher.class);

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
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<DistanceEdgeExists.Match> getAllMatches(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllMatches(new Object[]{pSg, pE, pV1, pV2}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<DistanceEdgeExists.Match> streamAllMatches(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllMatches(new Object[]{pSg, pE, pV1, pV2});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<DistanceEdgeExists.Match> getOneArbitraryMatch(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return rawGetOneArbitraryMatch(new Object[]{pSg, pE, pV1, pV2});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return rawHasMatch(new Object[]{pSg, pE, pV1, pV2});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return rawCountMatches(new Object[]{pSg, pE, pV1, pV2});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2, final Consumer<? super DistanceEdgeExists.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSg, pE, pV1, pV2}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pE the fixed value of pattern parameter e, or null if not bound.
     * @param pV1 the fixed value of pattern parameter v1, or null if not bound.
     * @param pV2 the fixed value of pattern parameter v2, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public DistanceEdgeExists.Match newMatch(final SceneGraph pSg, final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return DistanceEdgeExists.Match.newMatch(pSg, pE, pV1, pV2);
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
    public Stream<SceneGraph> streamAllValuesOfsg(final DistanceEdgeExists.Match partialMatch) {
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
    public Stream<SceneGraph> streamAllValuesOfsg(final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfsg(new Object[]{null, pE, pV1, pV2});
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final DistanceEdgeExists.Match partialMatch) {
      return rawStreamAllValuesOfsg(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final Distance pE, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfsg(new Object[]{null, pE, pV1, pV2}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Distance> rawStreamAllValuesOfe(final Object[] parameters) {
      return rawStreamAllValues(POSITION_E, parameters).map(Distance.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Distance> getAllValuesOfe() {
      return rawStreamAllValuesOfe(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Distance> streamAllValuesOfe() {
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
    public Stream<Distance> streamAllValuesOfe(final DistanceEdgeExists.Match partialMatch) {
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
    public Stream<Distance> streamAllValuesOfe(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfe(new Object[]{pSg, null, pV1, pV2});
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Distance> getAllValuesOfe(final DistanceEdgeExists.Match partialMatch) {
      return rawStreamAllValuesOfe(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for e.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Distance> getAllValuesOfe(final SceneGraph pSg, final Vehicle pV1, final Vehicle pV2) {
      return rawStreamAllValuesOfe(new Object[]{pSg, null, pV1, pV2}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOfv1(final DistanceEdgeExists.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOfv1(final SceneGraph pSg, final Distance pE, final Vehicle pV2) {
      return rawStreamAllValuesOfv1(new Object[]{pSg, pE, null, pV2});
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv1(final DistanceEdgeExists.Match partialMatch) {
      return rawStreamAllValuesOfv1(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v1.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv1(final SceneGraph pSg, final Distance pE, final Vehicle pV2) {
      return rawStreamAllValuesOfv1(new Object[]{pSg, pE, null, pV2}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOfv2(final DistanceEdgeExists.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOfv2(final SceneGraph pSg, final Distance pE, final Vehicle pV1) {
      return rawStreamAllValuesOfv2(new Object[]{pSg, pE, pV1, null});
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv2(final DistanceEdgeExists.Match partialMatch) {
      return rawStreamAllValuesOfv2(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for v2.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfv2(final SceneGraph pSg, final Distance pE, final Vehicle pV1) {
      return rawStreamAllValuesOfv2(new Object[]{pSg, pE, pV1, null}).collect(Collectors.toSet());
    }

    @Override
    protected DistanceEdgeExists.Match tupleToMatch(final Tuple t) {
      try {
          return DistanceEdgeExists.Match.newMatch((SceneGraph) t.get(POSITION_SG), (Distance) t.get(POSITION_E), (Vehicle) t.get(POSITION_V1), (Vehicle) t.get(POSITION_V2));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected DistanceEdgeExists.Match arrayToMatch(final Object[] match) {
      try {
          return DistanceEdgeExists.Match.newMatch((SceneGraph) match[POSITION_SG], (Distance) match[POSITION_E], (Vehicle) match[POSITION_V1], (Vehicle) match[POSITION_V2]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected DistanceEdgeExists.Match arrayToMatchMutable(final Object[] match) {
      try {
          return DistanceEdgeExists.Match.newMutableMatch((SceneGraph) match[POSITION_SG], (Distance) match[POSITION_E], (Vehicle) match[POSITION_V1], (Vehicle) match[POSITION_V2]);
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
    public static IQuerySpecification<DistanceEdgeExists.Matcher> querySpecification() {
      return DistanceEdgeExists.instance();
    }
  }

  private DistanceEdgeExists() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static DistanceEdgeExists instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected DistanceEdgeExists.Matcher instantiate(final ViatraQueryEngine engine) {
    return DistanceEdgeExists.Matcher.on(engine);
  }

  @Override
  public DistanceEdgeExists.Matcher instantiate() {
    return DistanceEdgeExists.Matcher.create();
  }

  @Override
  public DistanceEdgeExists.Match newEmptyMatch() {
    return DistanceEdgeExists.Match.newEmptyMatch();
  }

  @Override
  public DistanceEdgeExists.Match newMatch(final Object... parameters) {
    return DistanceEdgeExists.Match.newMatch((SceneGraph) parameters[0], (Distance) parameters[1], (Vehicle) parameters[2], (Vehicle) parameters[3]);
  }

  /**
   * Inner class allowing the singleton instance of {@link DistanceEdgeExists} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link DistanceEdgeExists#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final DistanceEdgeExists INSTANCE = new DistanceEdgeExists();

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
    private static final DistanceEdgeExists.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_sg = new PParameter("sg", "ca.mcmaster.mt4sg.models.scenegraph.SceneGraph", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")), PParameterDirection.INOUT);

    private final PParameter parameter_e = new PParameter("e", "ca.mcmaster.mt4sg.models.scenegraph.Distance", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Distance")), PParameterDirection.INOUT);

    private final PParameter parameter_v1 = new PParameter("v1", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_v2 = new PParameter("v2", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_sg, parameter_e, parameter_v1, parameter_v2);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.distanceEdgeExists";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","e","v1","v2");
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
          PVariable var_e = body.getOrCreateVariableByName("e");
          PVariable var_v1 = body.getOrCreateVariableByName("v1");
          PVariable var_v2 = body.getOrCreateVariableByName("v2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sg, parameter_sg),
             new ExportedParameter(body, var_e, parameter_e),
             new ExportedParameter(body, var_v1, parameter_v1),
             new ExportedParameter(body, var_v2, parameter_v2)
          ));
          //     SceneGraph.edges(sg, e)
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph", "edges")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge")));
          new Equality(body, var__virtual_0_, var_e);
          //     Distance.source(e, v1)
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_e, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_1_, var_v1);
          //     Distance.target(e, v2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_e, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_2_, var_v2);
          bodies.add(body);
      }
      {
          PBody body = new PBody(this);
          PVariable var_sg = body.getOrCreateVariableByName("sg");
          PVariable var_e = body.getOrCreateVariableByName("e");
          PVariable var_v1 = body.getOrCreateVariableByName("v1");
          PVariable var_v2 = body.getOrCreateVariableByName("v2");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v1), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_v2), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sg, parameter_sg),
             new ExportedParameter(body, var_e, parameter_e),
             new ExportedParameter(body, var_v1, parameter_v1),
             new ExportedParameter(body, var_v2, parameter_v2)
          ));
          //     SceneGraph.edges(sg, e)
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph", "edges")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge")));
          new Equality(body, var__virtual_0_, var_e);
          //     Distance.source(e, v2)
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance")));
          PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_e, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge", "source")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_1_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_1_, var_v2);
          //     Distance.target(e, v1)
          new TypeConstraint(body, Tuples.flatTupleOf(var_e), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Distance")));
          PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_e, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "Edge", "target")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_2_), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Node")));
          new Equality(body, var__virtual_2_, var_v1);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
