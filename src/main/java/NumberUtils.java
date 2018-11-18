import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtils {

    /**
     * rounds UP a BigDecimal value to the nearest 0.05
     */
    public static BigDecimal round(BigDecimal value){
        return round(value, BigDecimal.valueOf(0.05), RoundingMode.UP);
    }

    private static BigDecimal round(BigDecimal value, BigDecimal rounding, RoundingMode roundingMode){
        return rounding.signum() == 0 ? value : (value.divide(rounding,0, roundingMode)).multiply(rounding);
    }
}