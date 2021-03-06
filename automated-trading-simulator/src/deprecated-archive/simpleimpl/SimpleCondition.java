package autotradingsim.deprecated.simpleimpl;

import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.rules.ConfidenceFactor;
import autotradingsim.strategy.rules.ConfidenceFunction;
import autotradingsim.strategy.rules.ICondition;
import autotradingsim.strategy.rules.IMeasurement;
import autotradingsim.util.Pair;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.function.Predicate;

/**
 * Created by Asher on 2015-10-30.
 *
 * <p>Very basic implementation of ICondition, using:<br>
 * <ul><li>{@link SimpleStockValue} as its {@link IMeasurement}</li>
 *     <li>A fixed value to compare the IMeasurement against</li>
 * </ul></p>
 *
 */
public class SimpleCondition implements ICondition, Serializable {

	private static final long serialVersionUID = -5897219926387165114L;
	private SimpleStockValue measurement;
    private Predicate<IBufferAdapter> compare;
    private Predicate<Pair<BigDecimal,BigDecimal>> comparison;

    public SimpleCondition (Comparator comp, BigDecimal value) {
        // Using SimpleStockValue as Measurement
        this.measurement = new SimpleStockValue();

        // Want to use comparison function to check measurement against value
        this.comparison = makeComparator(comp);
        this.compare = (IBufferAdapter buf) ->
            (comparison.test(new Pair<>(measurement.getFunction().apply(buf), value)));

    }

    @Override
    public int getBufferSize() {
        return this.measurement.getBufferSize();
    }

    @Override
    public Predicate<IBufferAdapter> getFunction() {
        return this.compare;
    }

    @Override
    public ConfidenceFactor getConfidenceFactor() {
        return ConfidenceFactor.HIGH;
    }

    @Override
    public void setConfidenceFunction(ConfidenceFunction function) {
        System.out.print("Confidence Function in SimpleCondition is not settable.");
    }

    @Override
    public ConfidenceFunction getConfidenceFunction() {
        return (a, b, c) -> ConfidenceFactor.HIGH;
    }


}
