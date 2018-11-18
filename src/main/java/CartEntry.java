import java.math.BigDecimal;

public class CartEntry {

    private Product product;
    private long quantity;
    private BigDecimal totalTax;
    private BigDecimal totalPriceWithoutTax;
    private BigDecimal totalPriceWithTax;

    public CartEntry(Product product, long quantity){
        this.product = product;
        setQuantity(quantity);
    }

    public void setQuantity(long quantity){
        this.quantity = quantity;
        if (product != null){
            totalPriceWithoutTax = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            totalTax = product.calculateTax().multiply(BigDecimal.valueOf(quantity));
            totalPriceWithTax = totalPriceWithoutTax.add(totalTax);
        }
    }

    public Product getProduct() {
        return product;
    }

    public long getQuantity() {
        return quantity;
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
}
