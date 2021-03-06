package autotradingsim.deprecated.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.StockDay;
import autotradingsim.stocks.IBufferAdapter;
import autotradingsim.strategy.rules.IMeasurement;
import autotradingsim.strategy.exceptions.DataNotProvidedException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.function.Function;

/**
 * <p>Created by Asher on 2015-10-30.</p>
 *
 * <p>Measurement implementation which always uses a stock's daily closing value.</p>
 *
 * <p>**Deprecated in favour of {@link autotradingsim.strategy.indicators.SimpleMovingAverage}, which is
 * equivalent to a <tt>SimpleStockValue</tt> object when instantiated using "<tt>new SimpleMovingAverage(1)</tt>".</p>
 *
 */
public class SimpleStockValue implements IMeasurement, Serializable {

	private static final long serialVersionUID = 7222665412381196992L;
	private static final String name = "Simple Stock Value";
    private static final String desc = "Daily closing value of a stock";
    private static final int bufferSize = 1;

    private IStock stock;

    /**
     * The function!
     */
    private static Function<IBufferAdapter, BigDecimal> function =
            (IBufferAdapter stockBuffer) -> (
                    (stockBuffer.getLastEntry() != null) ? (stockBuffer.getLastEntry()).getValue(StockDay.Values.CLOSE) : null);


    public SimpleStockValue () {
        this.stock = null;
    }

    /**
     * Sets the stock to be used to calculate the value of this measurement.<br>
     * See {@link IMeasurement#getValue(IBufferAdapter)}
     * @param stock
     */
    public void setStock(IStock stock) {
        this.stock = stock;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return desc;
    }

    @Override
    public BigDecimal getValue(IBufferAdapter adapter) throws DataNotProvidedException {
        if (this.stock == null) {
            throw new DataNotProvidedException();
        }
        // Calendar prevDate = ((Calendar) date.clone());
        // prevDate.add(Calendar.DATE, -1);
        return function.apply(adapter);
    }

    @Override
    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return function;
    }

    public int getBufferSize() {
        return bufferSize;
    }

}
