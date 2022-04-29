package practice.basicfeature.novice.syntax;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ArithmeticErrorTest {
    @Test
    public void testDivide() {
        var a = new ArithmeticError();

        assertEquals(3000, a.divide(3150, 1.05));
        assertEquals(2900, a.divide(3045, 1.05));
        assertEquals(3150, 3000 * 1.05);
        assertEquals(20.6, 20 * 1.03);
        assertEquals(3000, a.divide(3090, 1.03));
        assertEquals(2900, a.divide(3132, 1.08));
        assertEquals(3090, 3000 * 1.03);

        assertEquals(3000, a.divideStrict(3150, 1.05));
        assertEquals(3000, a.divideDecimal(3150, 1.05));
    }

}