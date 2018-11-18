import java.math.BigDecimal;

public class ProductType {

    public static final ProductType generic = new ProductType("Generic", Tax.salesTax);
    public static final ProductType book = new ProductType("Book", Tax.noTax);
    public static final ProductType food = new ProductType("Food", Tax.noTax);
    public static final ProductType medical = new ProductType("Medical", Tax.noTax);

    private String name;
    private Tax tax;

    private ProductType(String name, Tax tax)
    {
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

    public void setTax(Tax tax) {
        this.tax = tax;
    }
}
