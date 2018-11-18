import org.junit.Test;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;

public class CartTest {

    /**
     * check that cart contains the correct totals
     */
    @Test
    public void checkCartTotals(){

        Cart cart = createSampleCart();
        assertEquals(cart.getCartEntries().size(), 4);

        BigDecimal totalPriceWithoutTax = BigDecimal.ZERO;
        BigDecimal totalTax = BigDecimal.ZERO;
        BigDecimal totalPriceWithTax = BigDecimal.ZERO;

        for (CartEntry cartEntry : cart.getCartEntries()) {
            totalPriceWithoutTax = totalPriceWithoutTax.add(cartEntry.getTotalPriceWithoutTax());
            totalTax = totalTax.add(cartEntry.getTotalTax());
            totalPriceWithTax = totalPriceWithTax.add(cartEntry.getTotalPriceWithTax());
        }

        assertEquals(totalPriceWithoutTax.compareTo(cart.getTotalPriceWithoutTax()), 0);
        assertEquals(totalTax.compareTo(cart.getTotalTax()), 0);
        assertEquals(totalPriceWithTax.compareTo(cart.getTotalPriceWithTax()), 0);
    }

    private Cart createSampleCart(){
        Product p1 = new Product(ProductType.food, ProductSource.national, "product1", 12.34);
        Product p2 = new Product(ProductType.generic, ProductSource.national, "product2", 12.34);
        Product p3 = new Product(ProductType.medical, ProductSource.imported, "product3", 12.34);
        Product p4 = new Product(ProductType.generic, ProductSource.imported, "product4", 12.34);
        return new Cart(new CartEntry(p1, 1), new CartEntry(p2, 1), new CartEntry(p3, 1), new CartEntry(p4, 1));
    }
}
