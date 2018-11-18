import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductSourceTest {

    /**
     * check that taxes are calculated correctly for both the product source (national or imported)
     */
    @Test
    public void calculateTax(){
        BigDecimal price = BigDecimal.valueOf(12.34);
        BigDecimal importedTax = NumberUtils.round(price.multiply(BigDecimal.valueOf(0.05)));

        assertEquals(BigDecimal.ZERO.compareTo(ProductSource.national.calculateTax(price)), 0);
        assertEquals(importedTax.compareTo(ProductSource.imported.calculateTax(price)), 0);
    }
}
