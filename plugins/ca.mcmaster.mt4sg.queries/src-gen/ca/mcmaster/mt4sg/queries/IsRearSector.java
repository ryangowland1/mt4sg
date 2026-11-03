/**
 * Generated from platform:/resource/ca.mcmaster.mt4sg.queries/src/ca/mcmaster/mt4sg/queries/scenegraph.vql
 */
package ca.mcmaster.mt4sg.queries;

import ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue;
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
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.viatra.query.runtime.api.IPatternMatch;
import org.eclipse.viatra.query.runtime.api.IQuerySpecification;
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.viatra.query.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.viatra.query.runtime.api.impl.BaseMatcher;
import org.eclipse.viatra.query.runtime.api.impl.BasePatternMatch;
import org.eclipse.viatra.query.runtime.emf.types.EDataTypeInSlotsKey;
import org.eclipse.viatra.query.runtime.matchers.backend.QueryEvaluationHint;
import org.eclipse.viatra.query.runtime.matchers.psystem.PBody;
import org.eclipse.viatra.query.runtime.matchers.psystem.PVariable;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.viatra.query.runtime.matchers.psystem.basicenumerables.ConstantValue;
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
 *         pattern isRearSector(spatial: SemanticSpatialPositionValue) {
 *             spatial == SemanticSpatialPositionValue::REAR;
 *         }
 * </pre></code>
 * 
 * @see Matcher
 * @see Match
 * 
 */
@SuppressWarnings("all")
public final class IsRearSector extends BaseGeneratedEMFQuerySpecification<IsRearSector.Matcher> {
  /**
   * Pattern-specific match representation of the ca.mcmaster.mt4sg.queries.isRearSector pattern,
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
    private SemanticSpatialPositionValue fSpatial;

    private static List<String> parameterNames = makeImmutableList("spatial");

    private Match(final SemanticSpatialPositionValue pSpatial) {
      this.fSpatial = pSpatial;
    }

    @Override
    public Object get(final String parameterName) {
      switch(parameterName) {
          case "spatial": return this.fSpatial;
          default: return null;
      }
    }

    @Override
    public Object get(final int index) {
      switch(index) {
          case 0: return this.fSpatial;
          default: return null;
      }
    }

    public SemanticSpatialPositionValue getSpatial() {
      return this.fSpatial;
    }

    @Override
    public boolean set(final String parameterName, final Object newValue) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      if ("spatial".equals(parameterName) ) {
          this.fSpatial = (SemanticSpatialPositionValue) newValue;
          return true;
      }
      return false;
    }

    public void setSpatial(final SemanticSpatialPositionValue pSpatial) {
      if (!isMutable()) throw new java.lang.UnsupportedOperationException();
      this.fSpatial = pSpatial;
    }

    @Override
    public String patternName() {
      return "ca.mcmaster.mt4sg.queries.isRearSector";
    }

    @Override
    public List<String> parameterNames() {
      return IsRearSector.Match.parameterNames;
    }

    @Override
    public Object[] toArray() {
      return new Object[]{fSpatial};
    }

    @Override
    public IsRearSector.Match toImmutable() {
      return isMutable() ? newMatch(fSpatial) : this;
    }

    @Override
    public String prettyPrint() {
      StringBuilder result = new StringBuilder();
      result.append("\"spatial\"=" + prettyPrintValue(fSpatial));
      return result.toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(fSpatial);
    }

    @Override
    public boolean equals(final Object obj) {
      if (this == obj)
          return true;
      if (obj == null) {
          return false;
      }
      if ((obj instanceof IsRearSector.Match)) {
          IsRearSector.Match other = (IsRearSector.Match) obj;
          return Objects.equals(fSpatial, other.fSpatial);
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
    public IsRearSector specification() {
      return IsRearSector.instance();
    }

    /**
     * Returns an empty, mutable match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @return the empty match.
     * 
     */
    public static IsRearSector.Match newEmptyMatch() {
      return new Mutable(null);
    }

    /**
     * Returns a mutable (partial) match.
     * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
     * 
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return the new, mutable (partial) match object.
     * 
     */
    public static IsRearSector.Match newMutableMatch(final SemanticSpatialPositionValue pSpatial) {
      return new Mutable(pSpatial);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public static IsRearSector.Match newMatch(final SemanticSpatialPositionValue pSpatial) {
      return new Immutable(pSpatial);
    }

    private static final class Mutable extends IsRearSector.Match {
      Mutable(final SemanticSpatialPositionValue pSpatial) {
        super(pSpatial);
      }

      @Override
      public boolean isMutable() {
        return true;
      }
    }

    private static final class Immutable extends IsRearSector.Match {
      Immutable(final SemanticSpatialPositionValue pSpatial) {
        super(pSpatial);
      }

      @Override
      public boolean isMutable() {
        return false;
      }
    }
  }

  /**
   * Generated pattern matcher API of the ca.mcmaster.mt4sg.queries.isRearSector pattern,
   * providing pattern-specific query methods.
   * 
   * <p>Use the pattern matcher on a given model via {@link #on(ViatraQueryEngine)},
   * e.g. in conjunction with {@link ViatraQueryEngine#on(QueryScope)}.
   * 
   * <p>Matches of the pattern will be represented as {@link Match}.
   * 
   * <p>Original source:
   * <code><pre>
   * pattern isRearSector(spatial: SemanticSpatialPositionValue) {
   *     spatial == SemanticSpatialPositionValue::REAR;
   * }
   * </pre></code>
   * 
   * @see Match
   * @see IsRearSector
   * 
   */
  public static class Matcher extends BaseMatcher<IsRearSector.Match> {
    /**
     * Initializes the pattern matcher within an existing VIATRA Query engine.
     * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
     * 
     * @param engine the existing VIATRA Query engine in which this matcher will be created.
     * @throws ViatraQueryRuntimeException if an error occurs during pattern matcher creation
     * 
     */
    public static IsRearSector.Matcher on(final ViatraQueryEngine engine) {
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
    public static IsRearSector.Matcher create() {
      return new Matcher();
    }

    private static final int POSITION_SPATIAL = 0;

    private static final Logger LOGGER = ViatraQueryLoggingUtil.getLogger(IsRearSector.Matcher.class);

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
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return matches represented as a Match object.
     * 
     */
    public Collection<IsRearSector.Match> getAllMatches(final SemanticSpatialPositionValue pSpatial) {
      return rawStreamAllMatches(new Object[]{pSpatial}).collect(Collectors.toSet());
    }

    /**
     * Returns a stream of all matches of the pattern that conform to the given fixed values of some parameters.
     * </p>
     * <strong>NOTE</strong>: It is important not to modify the source model while the stream is being processed.
     * If the match set of the pattern changes during processing, the contents of the stream is <strong>undefined</strong>.
     * In such cases, either rely on {@link #getAllMatches()} or collect the results of the stream in end-user code.
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return a stream of matches represented as a Match object.
     * 
     */
    public Stream<IsRearSector.Match> streamAllMatches(final SemanticSpatialPositionValue pSpatial) {
      return rawStreamAllMatches(new Object[]{pSpatial});
    }

    /**
     * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return a match represented as a Match object, or null if no match is found.
     * 
     */
    public Optional<IsRearSector.Match> getOneArbitraryMatch(final SemanticSpatialPositionValue pSpatial) {
      return rawGetOneArbitraryMatch(new Object[]{pSpatial});
    }

    /**
     * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
     * under any possible substitution of the unspecified parameters (if any).
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return true if the input is a valid (partial) match of the pattern.
     * 
     */
    public boolean hasMatch(final SemanticSpatialPositionValue pSpatial) {
      return rawHasMatch(new Object[]{pSpatial});
    }

    /**
     * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return the number of pattern matches found.
     * 
     */
    public int countMatches(final SemanticSpatialPositionValue pSpatial) {
      return rawCountMatches(new Object[]{pSpatial});
    }

    /**
     * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
     * Neither determinism nor randomness of selection is guaranteed.
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @param processor the action that will process the selected match.
     * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
     * 
     */
    public boolean forOneArbitraryMatch(final SemanticSpatialPositionValue pSpatial, final Consumer<? super IsRearSector.Match> processor) {
      return rawForOneArbitraryMatch(new Object[]{pSpatial}, processor);
    }

    /**
     * Returns a new (partial) match.
     * This can be used e.g. to call the matcher with a partial match.
     * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
     * @param pSpatial the fixed value of pattern parameter spatial, or null if not bound.
     * @return the (partial) match object.
     * 
     */
    public IsRearSector.Match newMatch(final SemanticSpatialPositionValue pSpatial) {
      return IsRearSector.Match.newMatch(pSpatial);
    }

    /**
     * Retrieve the set of values that occur in matches for spatial.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    protected Stream<SemanticSpatialPositionValue> rawStreamAllValuesOfspatial(final Object[] parameters) {
      return rawStreamAllValues(POSITION_SPATIAL, parameters).map(SemanticSpatialPositionValue.class::cast);
    }

    /**
     * Retrieve the set of values that occur in matches for spatial.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Set<SemanticSpatialPositionValue> getAllValuesOfspatial() {
      return rawStreamAllValuesOfspatial(emptyArray()).collect(Collectors.toSet());
    }

    /**
     * Retrieve the set of values that occur in matches for spatial.
     * @return the Set of all values or empty set if there are no matches
     * 
     */
    public Stream<SemanticSpatialPositionValue> streamAllValuesOfspatial() {
      return rawStreamAllValuesOfspatial(emptyArray());
    }

    @Override
    protected IsRearSector.Match tupleToMatch(final Tuple t) {
      try {
          return IsRearSector.Match.newMatch((SemanticSpatialPositionValue) t.get(POSITION_SPATIAL));
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in tuple not properly typed!",e);
          return null;
      }
    }

    @Override
    protected IsRearSector.Match arrayToMatch(final Object[] match) {
      try {
          return IsRearSector.Match.newMatch((SemanticSpatialPositionValue) match[POSITION_SPATIAL]);
      } catch(ClassCastException e) {
          LOGGER.error("Element(s) in array not properly typed!",e);
          return null;
      }
    }

    @Override
    protected IsRearSector.Match arrayToMatchMutable(final Object[] match) {
      try {
          return IsRearSector.Match.newMutableMatch((SemanticSpatialPositionValue) match[POSITION_SPATIAL]);
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
    public static IQuerySpecification<IsRearSector.Matcher> querySpecification() {
      return IsRearSector.instance();
    }
  }

  private IsRearSector() {
    super(GeneratedPQuery.INSTANCE);
  }

  /**
   * @return the singleton instance of the query specification
   * @throws ViatraQueryRuntimeException if the pattern definition could not be loaded
   * 
   */
  public static IsRearSector instance() {
    try{
        return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
        throw processInitializerError(err);
    }
  }

  @Override
  protected IsRearSector.Matcher instantiate(final ViatraQueryEngine engine) {
    return IsRearSector.Matcher.on(engine);
  }

  @Override
  public IsRearSector.Matcher instantiate() {
    return IsRearSector.Matcher.create();
  }

  @Override
  public IsRearSector.Match newEmptyMatch() {
    return IsRearSector.Match.newEmptyMatch();
  }

  @Override
  public IsRearSector.Match newMatch(final Object... parameters) {
    return IsRearSector.Match.newMatch((SemanticSpatialPositionValue) parameters[0]);
  }

  /**
   * Inner class allowing the singleton instance of {@link IsRearSector} to be created 
   *     <b>not</b> at the class load time of the outer class, 
   *     but rather at the first call to {@link IsRearSector#instance()}.
   * 
   * <p> This workaround is required e.g. to support recursion.
   * 
   */
  private static class LazyHolder {
    private static final IsRearSector INSTANCE = new IsRearSector();

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
    private static final IsRearSector.GeneratedPQuery INSTANCE = new GeneratedPQuery();

    private final PParameter parameter_spatial = new PParameter("spatial", "ca.mcmaster.mt4sg.models.scenegraph.SemanticSpatialPositionValue", new EDataTypeInSlotsKey((EDataType)getClassifierLiteralSafe("http://mcscert.ca/mt4sg/scenegraph", "SemanticSpatialPositionValue")), PParameterDirection.INOUT);

    private final List<PParameter> parameters = Arrays.asList(parameter_spatial);

    private GeneratedPQuery() {
      super(PVisibility.PUBLIC);
    }

    @Override
    public String getFullyQualifiedName() {
      return "ca.mcmaster.mt4sg.queries.isRearSector";
    }

    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("spatial");
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
          PVariable var_spatial = body.getOrCreateVariableByName("spatial");
          new TypeConstraint(body, Tuples.flatTupleOf(var_spatial), new EDataTypeInSlotsKey((EDataType)getClassifierLiteral("http://mcscert.ca/mt4sg/scenegraph", "SemanticSpatialPositionValue")));
          body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
             new ExportedParameter(body, var_spatial, parameter_spatial)
          ));
          //     spatial == SemanticSpatialPositionValue::REAR
          PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
          new ConstantValue(body, var__virtual_0_, getEnumLiteral("http://mcscert.ca/mt4sg/scenegraph", "SemanticSpatialPositionValue", "REAR").getInstance());
          new Equality(body, var_spatial, var__virtual_0_);
          bodies.add(body);
      }
      return bodies;
    }
  }
}
