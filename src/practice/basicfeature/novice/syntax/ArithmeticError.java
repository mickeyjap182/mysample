package practice.basicfeature.novice.syntax;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ArithmeticError {
    private final MathContext mathContext;
    ArithmeticError() {
        this(10, RoundingMode.HALF_EVEN);
    }
    ArithmeticError(int aScale, RoundingMode aRoundingMode) {
        mathContext = new MathContext(aScale, aRoundingMode);
    }
    public double divide(double target, double divide) {
        return target / divide;
    }
    public strictfp double divideStrict(double target, double divide) {
        return target / divide;
    }
    public double divideDecimal(double target, double divide) {
        var decimal = new BigDecimal(target, mathContext);
        return decimal.divide(new BigDecimal(divide), mathContext).doubleValue();
    }
    private static boolean isDividable() {
        return true;
    }
}
