package practice.basicfeature.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class A001FactorialTest {
    @Test
    public void testFactorial(){
        A001Factorial f = new A001Factorial();

        assertEquals(120, f.getFactorial(5));
        assertEquals(720, f.getFactorial(6));
        assertEquals(5040, f.getFactorial(7));
        assertEquals(40320, f.getFactorial(8));
    }
}