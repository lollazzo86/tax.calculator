import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class ProductTypeTest {

    /**
     * check that taxes are calculated correctly for all different types of goods
     */
    @Test
    public void calculateTax(){
        BigDecimal price = BigDecimal.valueOf(12.34);
        BigDecimal salesTax = NumberUtils.round(price.multiply(BigDecimal.valueOf(0.1)));

        assertEquals(BigDecimal.ZERO.compareTo(ProductType.book.calculateTax(price)), 0);
        assertEquals(BigDecimal.ZERO.compareTo(ProductType.food.calculateTax(price)), 0);
        assertEquals(BigDecimal.ZERO.compareTo(ProductType.medical.calculateTax(price)), 0);
        assertEquals(salesTax.compareTo(ProductType.generic.calculateTax(price)), 0);
    }
}
