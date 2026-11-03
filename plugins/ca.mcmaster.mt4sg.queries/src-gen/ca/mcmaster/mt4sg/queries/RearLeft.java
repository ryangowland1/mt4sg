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
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.viatra.query.runtime.matchers.psystem.IValueProvider;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
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
 *         pattern rearLeft(sg: SceneGraph, source: Vehicle, target: Vehicle) {
 *             find angleFromTo(sg, source, target, angle);
 *             check(angle {@literal >}= -2.748894 && angle {@literal <} -1.963495);
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class RearLeft extends BaseGeneratedEMFQuerySpecification<RearLeft.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.rearLeft pattern,
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

    private static List<String> parameterNames = makeImmutableList("sg", "source", "target");

    private Match(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      this.fSg = pSg;
      this.fSource = pSource;
      this.fTarget = pTarget;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "sg": return this.fSg;
          case "source": return this.fSource;
          case "target": return this.fTarget;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSg;
          case 1: return this.fSource;
          case 2: return this.fTarget;
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

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.rearLeft";
    }

    @Override
    public List<String> parameterNames() {
      return RearLeft.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSg, fSource, fTarget};
    }

    @Override
    public RearLeft.Match toImmutable() {
      return isMutable() ? newMatch(fSg, fSource, fTarget) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"sg\"=" + prettyPrintValue(fSg) + ", ");
      result.append("\"source\"=" + prettyPrintValue(fSource) + ", ");
      result.append("\"target\"=" + prettyPrintValue(fTarget));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSg, fSource, fTarget);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof RearLeft.Match)) {
          RearLeft.Match other = (RearLeft.Match) obj;
          return Objects.equals(fSg, other.fSg) && Objects.equals(fSource, other.fSource) && Objects.equals(fTarget, other.fTarget);
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
    public RearLeft specification() {
      return RearLeft.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static RearLeft.Match newEmptyMatch() {
      return new Mutable(null, null, null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static RearLeft.Match newMutableMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return new Mutable(pSg, pSource, pTarget);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static RearLeft.Match newMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return new Immutable(pSg, pSource, pTarget);
    }

    private static final class Mutable extends RearLeft.Match {
      Mutable(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
        super(pSg, pSource, pTarget);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends RearLeft.Match {
      Immutable(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
        super(pSg, pSource, pTarget);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.rearLeft pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern rearLeft(sg: SceneGraph, source: Vehicle, target: Vehicle) {
   *     find angleFromTo(sg, source, target, angle);
   *     check(angle {@literal >}= -2.748894 && angle {@literal <} -1.963495);
   * }
   * </pre></code>
   * 
   * @see Match
   * @see RearLeft
   * 
   */
  public static class Matcher extends BaseMatcher<RearLeft.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static RearLeft.Matcher on(final ViatraQueryEngine engine) {
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
    public static RearLeft.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SG = 0;

    private static final int POSITION_SOURCE = 1;

    private static final int POSITION_TARGET = 2;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(RearLeft.Matcher.class);

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
     * @return matches represented as a Match object.
     * 
     */
    public Collection<RearLeft.Match> getAllMatches(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return rawStreamAllMatches(new Object[]{pSg, pSource, pTarget}).collect(Collectors.toSet());
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
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<RearLeft.Match> streamAllMatches(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return rawStreamAllMatches(new Object[]{pSg, pSource, pTarget});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<RearLeft.Match> getOneArbitraryMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return rawGetOneArbitraryMatch(new Object[]{pSg, pSource, pTarget});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return rawHasMatch(new Object[]{pSg, pSource, pTarget});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return rawCountMatches(new Object[]{pSg, pSource, pTarget});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget, final Consumer<? super RearLeft.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSg, pSource, pTarget}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSg the fixed value of pattern parameter sg, or null if not bound.
     * @param pSource the fixed value of pattern parameter source, or null if not bound.
     * @param pTarget the fixed value of pattern parameter target, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public RearLeft.Match newMatch(final SceneGraph pSg, final Vehicle pSource, final Vehicle pTarget) {
      return RearLeft.Match.newMatch(pSg, pSource, pTarget);
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
    public Stream<SceneGraph> streamAllValuesOfsg(final RearLeft.Match partialMatch) {
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
    public Stream<SceneGraph> streamAllValuesOfsg(final Vehicle pSource, final Vehicle pTarget) {
      return rawStreamAllValuesOfsg(new Object[]{null, pSource, pTarget});
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final RearLeft.Match partialMatch) {
      return rawStreamAllValuesOfsg(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for sg.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SceneGraph> getAllValuesOfsg(final Vehicle pSource, final Vehicle pTarget) {
      return rawStreamAllValuesOfsg(new Object[]{null, pSource, pTarget}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOfsource(final RearLeft.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOfsource(final SceneGraph pSg, final Vehicle pTarget) {
      return rawStreamAllValuesOfsource(new Object[]{pSg, null, pTarget});
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfsource(final RearLeft.Match partialMatch) {
      return rawStreamAllValuesOfsource(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for source.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOfsource(final SceneGraph pSg, final Vehicle pTarget) {
      return rawStreamAllValuesOfsource(new Object[]{pSg, null, pTarget}).collect(Collectors.toSet());
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
    public Stream<Vehicle> streamAllValuesOftarget(final RearLeft.Match partialMatch) {
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
    public Stream<Vehicle> streamAllValuesOftarget(final SceneGraph pSg, final Vehicle pSource) {
      return rawStreamAllValuesOftarget(new Object[]{pSg, pSource, null});
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOftarget(final RearLeft.Match partialMatch) {
      return rawStreamAllValuesOftarget(partialMatch.toArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for target.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<Vehicle> getAllValuesOftarget(final SceneGraph pSg, final Vehicle pSource) {
      return rawStreamAllValuesOftarget(new Object[]{pSg, pSource, null}).collect(Collectors.toSet());
    }

    @Override
    protected RearLeft.Match tupleToMatch(final Tuple t) {
      try {
          return RearLeft.Match.newMatch((SceneGraph) t.get(POSITION_SG), (Vehicle) t.get(POSITION_SOURCE), (Vehicle) t.get(POSITION_TARGET));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected RearLeft.Match arrayToMatch(final Object[] match) {
      try {
          return RearLeft.Match.newMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_SOURCE], (Vehicle) match[POSITION_TARGET]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected RearLeft.Match arrayToMatchMutable(final Object[] match) {
      try {
          return RearLeft.Match.newMutableMatch((SceneGraph) match[POSITION_SG], (Vehicle) match[POSITION_SOURCE], (Vehicle) match[POSITION_TARGET]);
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
    public static IQuerySpecification<RearLeft.Matcher> querySpecification() {
      return RearLeft.instance();
    }
  }

  private RearLeft() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static RearLeft instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected RearLeft.Matcher instantiate(final ViatraQueryEngine engine) {
    return RearLeft.Matcher.on(engine);
  }

  @Override
  public RearLeft.Matcher instantiate() {
    return RearLeft.Matcher.create();
  }

  @Override
  public RearLeft.Match newEmptyMatch() {
    return RearLeft.Match.newEmptyMatch();
  }

  @Override
  public RearLeft.Match newMatch(final Object... parameters) {
    return RearLeft.Match.newMatch((SceneGraph) parameters[0], (Vehicle) parameters[1], (Vehicle) parameters[2]);
  }

  /**
   * Inner class allowing the singleton instance of {@link RearLeft} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link RearLeft#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final RearLeft INSTANCE = new RearLeft();

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
    private static final RearLeft.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_sg = new PParameter("sg", "ca.mcmaster.mt4sg.models.scenegraph.SceneGraph", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")), PParameterDirection.INOUT);

    private final PParameter parameter_source = new PParameter("source", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final PParameter parameter_target = new PParameter("target", "ca.mcmaster.mt4sg.models.scenegraph.Vehicle", new EClassTransitiveInstancesKey((EClass)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_sg, parameter_source, parameter_target);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.rearLeft";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sg","source","target");
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
          PVariable var_angle = body.getOrCreateVariableByName("angle");
          new TypeConstraint(body, Tuples.flatTupleOf(var_sg), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SceneGraph")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_source), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          new TypeConstraint(body, Tuples.flatTupleOf(var_target), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "Vehicle")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_sg, parameter_sg),
             new ExportedParameter(body, var_source, parameter_source),
             new ExportedParameter(body, var_target, parameter_target)
          ));
          //     find angleFromTo(sg, source, target, angle)
          new PositivePatternCall(body, Tuples.flatTupleOf(var_sg, var_source, var_target, var_angle), AngleFromTo.instance().getInternalQueryRepresentation());
          //     check(angle >= -2.748894 && angle < -1.963495)
          new ExpressionEvaluation(body, new IExpressionEvaluator() {
          
              @Override
              public String getShortDescription() {
                  return "Expression evaluation from pattern rearLeft";
              }
              
              @Override
              public Iterable<String> getInputParameterNames() {
                  return Arrays.asList("angle");}
          
              @Override
              public Object evaluateExpression(IValueProvider provider) throws Exception {
                  Double angle = (Double) provider.getValue("angle");
                  return evaluateExpression_1_1(angle);
              }
          },  null, false);
          bodies.add(body);
      }
      return bodies;
    }
  }

  private static boolean evaluateExpression_1_1(final Double angle) {
    return (((angle).doubleValue() >= (-2.748894)) && ((angle).doubleValue() < (-1.963495)));
  }
}
