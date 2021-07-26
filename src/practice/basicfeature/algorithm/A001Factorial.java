package practice.basicfeature.algorithm;

import java.security.InvalidParameterException;

public class A001Factorial {

    public int getFactorial(int x) {

        return recurcive(x);

    }

    public static int recurcive(int x) {
        if (x < 1) {
            throw new InvalidParameterException(String.format(" x must be small than 0, but %d . "));
        }
        return x > 1 ? x * recurcive(x - 1) : x;
    }

}
