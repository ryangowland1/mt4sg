/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.SceneGraph;
import ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue;
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
 *         pattern spatialEdgeValue(
 *             sg: SceneGraph,
 *             source: Vehicle,
 *             target: Vehicle,
 *             spatialVal: SemanticSpatialPositionValue
 *         ) {
 *             find spatialEdgeExists(sg, edge, source, target);
 *             SpatialPosition.value(edge, spatialVal);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class SpatialEdgeValue extends BaseGeneratedEMFQuerySpecification<SpatialEdgeValue.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.spatialEdgeValue pattern,
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

    private Vehicle fSource;

    private Vehicle fTarget;

    private SemanticSpatialPositionValue fSpatialVal;

    private static List<String> parameterNames = makeImmutableList("sg", "source", "target", "spatialVal");

    private Match(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      this.fSg = pSg;
      this.fSource = pSource;
      this.fTarget = pTarget;
      this.fSpatialVal = pSpatialVal;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "sg": return this.fSg;
          case "source": return this.fSource;
          case "target": return this.fTarget;
          case "spatialVal": return this.fSpatialVal;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSg;
          case 1: return this.fSource;
          case 2: return this.fTarget;
          case 3: return this.fSpatialVal;
          default: return null;
      }
    }

    public SceneGraph getSg() {
      return this.fSg;
    }

    public Vehicle getSource() {
      return this.fSource;
    }

    public Vehicle getTarget() {
      return this.fTarget;
    }

    public SemanticSpatialPositionValue getSpatialVal() {
      return this.fSpatialVal;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("sg".equals(parameterName) ) {
          this.fSg = (SceneGraph) newValue;
          return true;
      }
      if ("source".equals(parameterName) ) {
          this.fSource = (Vehicle) newValue;
          return true;
      }
      if ("target".equals(parameterName) ) {
          this.fTarget = (Vehicle) newValue;
          return true;
      }
      if ("spatialVal".equals(parameterName) ) {
          this.fSpatialVal = (SemanticSpatialPositionValue) newValue;
          return true;
      }
      return false;
    }

    public void setSg(final SceneGraph pSg) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSg = pSg;
    }

    public void setSource(final Vehicle pSource) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSource = pSource;
    }

    public void setTarget(final Vehicle pTarget) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fTarget = pTarget;
    }

    public void setSpatialVal(final SemanticSpatialPositionValue pSpatialVal) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSpatialVal = pSpatialVal;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.spatialEdgeValue";
    }

    @Override
    public List<String> parameterNames() {
      return SpatialEdgeValue.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSg, fSource, fTarget, fSpatialVal};
    }

    @Override
    public SpatialEdgeValue.Match toImmutable() {
      return isMutable() ? newMatch(fSg, fSource, fTarget, fSpatialVal) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
      result.append("\"source\"=" + prettyPrintValue(fSource) + ", ");
      result.append("\"target\"=" + prettyPrintValue(fTarget) + ", ");
      result.append("\"spatialVal\"=" + prettyPrintValue(fSpatialVal));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSg, fSource, fTarget, fSpatialVal);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof SpatialEdgeValue.Match)) {
          SpatialEdgeValue.Match other = (SpatialEdgeValue.Match) obj;
          return Objects.equals(fSg, other.fSg) && Objects.equals(fSource, other.fSource) && Objects.equals(fTarget, other.fTarget) && Objects.equals(fSpatialVal, other.fSpatialVal);
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
    public SpatialEdgeValue specification() {
      return SpatialEdgeValue.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static SpatialEdgeValue.Match newEmptyMatch() {
      return new Mutable(null, null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static SpatialEdgeValue.Match newMutableMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return new Mutable(pSg, pSource, pTarget, pSpatialVal);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static SpatialEdgeValue.Match newMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return new Immutable(pSg, pSource, pTarget, pSpatialVal);
    }

    private static final class Mutable extends SpatialEdgeValue.Match {
      Mutable(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
        super(pSg, pSource, pTarget, pSpatialVal);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends SpatialEdgeValue.Match {
      Immutable(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
        super(pSg, pSource, pTarget, pSpatialVal);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.spatialEdgeValue pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern spatialEdgeValue(
   *     sg: SceneGraph,
   *     source: Vehicle,
   *     target: Vehicle,
   *     spatialVal: SemanticSpatialPositionValue
   * ) {
   *     find spatialEdgeExists(sg, edge, source, target);
   *     SpatialPosition.value(edge, spatialVal);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see SpatialEdgeValue
   * 
   */
  public static class Matcher extends BaseMatcher<SpatialEdgeValue.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static SpatialEdgeValue.Matcher on(final ViatraQueryEngine engine) {
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
    public static SpatialEdgeValue.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SG = 0;

    private static final int POSITION_SOURCE = 1;

    private static final int POSITION_TARGET = 2;

    private static final int POSITION_SPATIALVAL = 3;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(SpatialEdgeValue.Matcher.class);

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
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<SpatialEdgeValue.Match> getAllMatches(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllMatches(new Object[]{pSg, pSource, pTarget, pSpatialVal}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<SpatialEdgeValue.Match> streamAllMatches(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllMatches(new Object[]{pSg, pSource, pTarget, pSpatialVal});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<SpatialEdgeValue.Match> getOneArbitraryMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawGetOneArbitraryMatch(new Object[]{pSg, pSource, pTarget, pSpatialVal});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawHasMatch(new Object[]{pSg, pSource, pTarget, pSpatialVal});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawCountMatches(new Object[]{pSg, pSource, pTarget, pSpatialVal});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal, final Consumer<? super SpatialEdgeValue.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSg, pSource, pTarget, pSpatialVal}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param pSpatialVal the fixed value of pattern parameter spatialVal, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public SpatialEdgeValue.Match newMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return SpatialEdgeValue.Match.newMatch(pSg, pSource, pTarget, pSpatialVal);
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
    public Stream<SceneGraph> streamAllValuesOfsg(final SpatialEdgeValue.Match partialMatch) {
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
    public Stream<SceneGraph> streamAllValuesOfsg(final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllValuesOfsg(new Object[]{null, pSource, pTarget, pSpatialVal});
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final SpatialEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfsg(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final Vehicle pSource, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllValuesOfsg(new Object[]{null, pSource, pTarget, pSpatialVal}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vehicle> rawStreamAllValuesOfsource(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SOURCE, parameters).map(Vehicle.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfsource() {
      return rawStreamAllValuesOfsource(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfsource() {
      return rawStreamAllValuesOfsource(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfsource(final SpatialEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfsource(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOfsource(final SceneGraph pSg, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllValuesOfsource(new Object[]{pSg, null, pTarget, pSpatialVal});
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfsource(final SpatialEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfsource(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfsource(final SceneGraph pSg, final Vehicle pTarget, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllValuesOfsource(new Object[]{pSg, null, pTarget, pSpatialVal}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<Vehicle> rawStreamAllValuesOftarget(final Object[] parameters) {
      return rawStreamAllValues(POSITION_TARGET, parameters).map(Vehicle.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOftarget() {
      return rawStreamAllValuesOftarget(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<Vehicle> streamAllValuesOftarget() {
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
    public Stream<Vehicle> streamAllValuesOftarget(final SpatialEdgeValue.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOftarget(final SceneGraph pSg, final Vehicle pSource, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllValuesOftarget(new Object[]{pSg, pSource, null, pSpatialVal});
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOftarget(final SpatialEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOftarget(final SceneGraph pSg, final Vehicle pSource, final SemanticSpatialPositionValue pSpatialVal) {
      return rawStreamAllValuesOftarget(new Object[]{pSg, pSource, null, pSpatialVal}).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for spatialVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<SemanticSpatialPositionValue> rawStreamAllValuesOfspatialVal(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SPATIALVAL, parameters).map(SemanticSpatialPositionValue.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for spatialVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SemanticSpatialPositionValue> getAllValuesOfspatialVal() {
      return rawStreamAllValuesOfspatialVal(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for spatialVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<SemanticSpatialPositionValue> streamAllValuesOfspatialVal() {
      return rawStreamAllValuesOfspatialVal(emptyArray());
    }

    /**
     * Retrieve the set of values that occur in matches for spatialVal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SemanticSpatialPositionValue> streamAllValuesOfspatialVal(final SpatialEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfspatialVal(partialMatch.toArray());
    }

    /**
     * Retrieve the set of values that occur in matches for spatialVal.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     *      
     * @return the Stream of all values or empty set if there are no matches
     * 
     */
    public Stream<SemanticSpatialPositionValue> streamAllValuesOfspatialVal(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return rawStreamAllValuesOfspatialVal(new Object[]{pSg, pSource, pTarget, null});
    }

    /**
     * Retrieve the set of values that occur in matches for spatialVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SemanticSpatialPositionValue> getAllValuesOfspatialVal(final SpatialEdgeValue.Match partialMatch) {
      return rawStreamAllValuesOfspatialVal(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for spatialVal.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SemanticSpatialPositionValue> getAllValuesOfspatialVal(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return rawStreamAllValuesOfspatialVal(new Object[]{pSg, pSource, pTarget, null}).collect(Collectors.toSet());
    }

    @Override
    protected SpatialEdgeValue.Match tupleToMatch(final Tuple t) {
      try {
          return SpatialEdgeValue.Match.newMatch((SceneGraph) t.get(POSITION_SG), (Vehicle) t.get(POSITION_SOURCE), (Vehicle) t.get(POSITION_TARGET), (SemanticSpatialPositionValue) t.get(POSITION_SPATIALVAL));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SpatialEdgeValue.Match arrayToMatch(final Object[] match) {
      try {
          return SpatialEdgeValue.Match.newMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_SOURCE], (Vehicle) match[POSITION_TARGET], (SemanticSpatialPositionValue) match[POSITION_SPATIALVAL]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected SpatialEdgeValue.Match arrayToMatchMutable(final Object[] match) {
      try {
          return SpatialEdgeValue.Match.newMutableMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_SOURCE], (Vehicle) match[POSITION_TARGET], (SemanticSpatialPositionValue) match[POSITION_SPATIALVAL]);
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
    public static IQuerySpecification<SpatialEdgeValue.Matcher> querySpecification() {
      return SpatialEdgeValue.instance();
    }
  }

  private SpatialEdgeValue() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static SpatialEdgeValue instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected SpatialEdgeValue.Matcher instantiate(final ViatraQueryEngine engine) {
    return SpatialEdgeValue.Matcher.on(engine);
  }

  @Override
  public SpatialEdgeValue.Matcher instantiate() {
    return SpatialEdgeValue.Matcher.create();
  }

  @Override
  public SpatialEdgeValue.Match newEmptyMatch() {
    return SpatialEdgeValue.Match.newEmptyMatch();
  }

  @Override
  public SpatialEdgeValue.Match newMatch(final Object... parameters) {
    return SpatialEdgeValue.Match.newMatch((SceneGraph) parameters[0], (Vehicle) parameters[1], (Vehicle) parameters[2], (SemanticSpatialPositionValue) parameters[3]);
  }

  /**
   * Inner class allowing the singleton instance of {@link SpatialEdgeValue} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link SpatialEdgeValue#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final SpatialEdgeValue INSTANCE = new SpatialEdgeValue();

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
    private static final SpatialEdgeValue.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_sg = new PParameter("sg", "ca.mcmaster.mt4sg.models.scenegraph.SceneGraph", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")), PParameterDirection.INOUT);

    private final PParameter parameter_source = new PParameter("source", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_target = new PParameter("target", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_spatialVal = new PParameter("spatialVal", "ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SemanticSpatialPositionValue")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_sg, parameter_source, parameter_target, parameter_spatialVal);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.spatialEdgeValue";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","source","target","spatialVal");
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
          PVariable var_source = body.getOrCreateVariableByName("source");
          PVariable var_target = body.getOrCreateVariableByName("target");
          PVariable var_spatialVal = body.getOrCreateVariableByName("spatialVal");
          PVariable var_edge = body.getOrCreateVariableByName("edge");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_source), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_target), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_spatialVal), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SemanticSpatialPositionValue")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sg, parameter_sg),
             new ExportedParameter(body, var_source, parameter_source),
             new ExportedParameter(body, var_target, parameter_target),
             new ExportedParameter(body, var_spatialVal, parameter_spatialVal)
          ));
          //     find spatialEdgeExists(sg, edge, source, target)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_sg, var_edge, var_source, var_target), SpatialEdgeExists.instance().getInternalQueryRepresentation());
          //     SpatialPosition.value(edge, spatialVal)
          new TypeConstraint(body, Tuples.flatTupleOf(var_edge), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SpatialPosition")));
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new TypeConstraint(body, Tuples.flatTupleOf(var_edge, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://mcscert.ca/mt4sg/scenegraph", "SpatialPosition", "value")));
          new TypeConstraint(body, Tuples.flatTupleOf(var__virtual_0_), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SemanticSpatialPositionValue")));
          new Equality(body, var__virtual_0_, var_spatialVal);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
