import java.math.BigDecimal;

public class ProductSource {

    public static final ProductSource national = new ProductSource("National", Tax.noTax);
    public static final ProductSource imported = new ProductSource("Imported", Tax.importTax);

    private String name;
    private Tax tax;

    private ProductSource(String name, Tax tax){
        this.name = name;
        this.tax = tax;
    }

    public BigDecimal calculateTax(BigDecimal price)
    {
        return tax.calculateTax(price);
    }

    public String getName() {
        return name;
    }

    public Tax getTax() {
        return tax;
    }
}
