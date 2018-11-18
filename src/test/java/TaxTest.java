import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class TaxTest {

    /**
     * check that taxes are calculated correctly for both sales and import
     */
    @Test
    public void calculateTax(){
        BigDecimal price = BigDecimal.valueOf(12.34);
        BigDecimal salesTax = NumberUtils.round(price.multiply(BigDecimal.valueOf(0.1)));
        BigDecimal importTax = NumberUtils.round(price.multiply(BigDecimal.valueOf(0.05)));

        assertEquals(BigDecimal.ZERO.compareTo(Tax.noTax.calculateTax(price)), 0);
        assertEquals(salesTax.compareTo(Tax.salesTax.calculateTax(price)), 0);
        assertEquals(importTax.compareTo(Tax.importTax.calculateTax(price)), 0);
    }
}
