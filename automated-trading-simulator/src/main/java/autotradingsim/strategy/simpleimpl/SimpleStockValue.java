package autotradingsim.strategy.simpleimpl;

import autotradingsim.stocks.IStock;
import autotradingsim.stocks.Stock;
import autotradingsim.stocks.StockDay;
import autotradingsim.strategy.IBufferAdapter;
import autotradingsim.strategy.IFunctionBuilder;
import autotradingsim.strategy.IMeasurement;
import autotradingsim.strategy.exceptions.DataNotProvidedException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Function;

/**
 * Created by Asher on 2015-10-30.
 *
 * IMeasurement implementation which always uses a stock's daily closing value.
 *
 */
public class SimpleStockValue implements IMeasurement, IFunctionBuilder {

    private static final String name = "Simple Stock Value";
    private static final String desc = "Daily closing value of a stock";
    private static final int bufferSize = 1;

    private IStock stock;

    /**
     * The function!
     */
    private static Function<IBufferAdapter, BigDecimal> function =
            (IBufferAdapter stockBuffer) -> (
                    (stockBuffer.getLastEntry() != null) ? ((StockDay) stockBuffer.getLastEntry()).getValue(StockDay.Values.CLOSE) : null);


    public SimpleStockValue () {
        this.stock = null;
    }

    /**
     * Sets the stock to be used to calculate the value of this measurement.<br>
     * See {@link IMeasurement#getValue(LocalDate)}
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
    public BigDecimal getValue(LocalDate date) throws DataNotProvidedException {
        if (this.stock == null) {
            throw new DataNotProvidedException();
        }
        // Calendar prevDate = ((Calendar) date.clone());
        // prevDate.add(Calendar.DATE, -1);
        return function.apply(((Stock) this.stock).getNewDayBuffer(date, this.getBufferSize()));
    }

    @Override
    public Function<IBufferAdapter, BigDecimal> getFunction() {
        return function;
    }

    public int getBufferSize() {
        return bufferSize;
    }

}
