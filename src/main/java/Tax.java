import java.math.BigDecimal;

public class Tax {

    public static final Tax noTax = new Tax("No Tax", BigDecimal.ZERO);
    public static final Tax salesTax = new Tax("Sales Tax", BigDecimal.valueOf(0.1));
    public static final Tax importTax = new Tax("Import Tax", BigDecimal.valueOf(0.05));

    private String name;
    private BigDecimal rate;

    private Tax(String name, BigDecimal rate){
        this.name = name;
        this.rate = rate;
    }

    public BigDecimal calculateTax(BigDecimal price)
    {
        return NumberUtils.round(price.multiply(rate));
    }

    public String getName() {
        return name;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
