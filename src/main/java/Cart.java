import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Cart {

    private List<CartEntry> cartEntries;
    private BigDecimal totalTax;
    private BigDecimal totalPriceWithoutTax;
    private BigDecimal totalPriceWithTax;

    public Cart(List<CartEntry> cartEntries){
        if (cartEntries != null && !cartEntries.isEmpty()){
            createCart(cartEntries);
        }
    }

    public Cart(CartEntry... cartEntries){
        if (cartEntries != null && cartEntries.length > 0) {
            createCart(Arrays.asList(cartEntries));
        }
    }

    private void createCart(List<CartEntry> cartEntries){
        this.cartEntries = cartEntries;
        totalTax = BigDecimal.ZERO;
        totalPriceWithoutTax = BigDecimal.ZERO;
        totalPriceWithTax = BigDecimal.ZERO;

        for (CartEntry cartEntry : cartEntries) {
            totalPriceWithoutTax = totalPriceWithoutTax.add(cartEntry.getTotalPriceWithoutTax());
            totalPriceWithTax = totalPriceWithTax.add(cartEntry.getTotalPriceWithTax());
            totalTax = totalTax.add(cartEntry.getTotalTax());
        }
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public BigDecimal getTotalPriceWithoutTax() {
        return totalPriceWithoutTax;
    }

    public BigDecimal getTotalPriceWithTax() {
        return totalPriceWithTax;
    }

    public List<CartEntry> getCartEntries() {
        return cartEntries;
    }
}
