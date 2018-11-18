import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.assertEquals;

public class CartEntryTest {

    /**
     * check that quantities and total prices of a cartEntry are calculated correctly
     */
    @Test
    public void checkCartEntryQuantities(){
        Product product = new Product(ProductType.generic, ProductSource.imported, "product", 12.34);
        CartEntry cartEntry = new CartEntry(product, 1);

        BigDecimal estimatedTotalPriceWithoutTax = product.getPrice();
        assertEquals(estimatedTotalPriceWithoutTax.compareTo(cartEntry.getTotalPriceWithoutTax()), 0);

        BigDecimal estimatedTotalTax = product.calculateTax();
        assertEquals(estimatedTotalTax.compareTo(cartEntry.getTotalTax()), 0);

        BigDecimal estimatedTotalPriceWithTax = estimatedTotalPriceWithoutTax.add(estimatedTotalTax);
        assertEquals(estimatedTotalPriceWithTax.compareTo(cartEntry.getTotalPriceWithTax()), 0);

        cartEntry.setQuantity(2);
        BigDecimal factor = BigDecimal.valueOf(2);

        assertEquals((estimatedTotalPriceWithoutTax.multiply(factor)).compareTo(cartEntry.getTotalPriceWithoutTax()), 0);
        assertEquals((estimatedTotalTax.multiply(factor)).compareTo(cartEntry.getTotalTax()), 0);
        assertEquals((estimatedTotalPriceWithTax.multiply(factor)).compareTo(cartEntry.getTotalPriceWithTax()), 0);
    }
}
