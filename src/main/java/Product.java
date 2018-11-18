import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;
    private ProductType productType;
    private ProductSource productSource;

    public Product(ProductType productType, ProductSource productSource, String name, double price){
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.productType = productType;
        this.productSource = productSource;
    }

    public BigDecimal calculateTax(){
        return NumberUtils.round(productType.calculateTax(price).add(productSource.calculateTax(price)));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public ProductSource getProductSource() {
        return productSource;
    }
}
