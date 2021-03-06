package autotradingsim.stocks;

import java.time.LocalDate;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asher on 2015-10-25.
 * Contributors: Bill
 *
 * Used for daily stock data.
 * Holds symbol, date, open, high, low, close, and volume data
 *
 * Public Methods:
 *      getDate()
 *      getOpen()
 *      getHigh()
 *      getLow()
 *      getClose()
 *      getVolume()
 */
public class StockDay implements Comparable<StockDay> {

    public enum Values {
        OPEN, CLOSE, HIGH, LOW
    }

    private String symbol;
    private LocalDate date;
    private int volume;

    // Experimental BigDecimal Map
    private Map<Values, BigDecimal> values;

    public StockDay(String symbol, LocalDate date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close, int volume) {
        StockDay.this.symbol = symbol;
        StockDay.this.date = date;

        // Experimental BigDecimal Map
        values = new HashMap<>();
        values.put(Values.OPEN, open);
        values.put(Values.CLOSE, close);
        values.put(Values.HIGH, high);
        values.put(Values.LOW, low);

        StockDay.this.volume = volume;
    }

    // BigDecimal getter
    public BigDecimal getValue(Values which) {
        return values.get(which);
    }

    public BigDecimal getValue() {
        return values.get(Values.CLOSE);
    }

    public String getSymbol(){
        return StockDay.this.symbol;
    }

    public LocalDate getDate(){
        return StockDay.this.date;
    }

    public int getVolume(){
        return StockDay.this.volume;
    }

    @Override
    public int compareTo(StockDay o) {
        return this.getDate().compareTo(o.getDate());
    }

}
