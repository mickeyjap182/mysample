package practice.basicfeature.novice.syntax.extend;

import org.junit.jupiter.api.Test;

public class RunnersTest {
    @Test
    public void test_go() {
        try {
            new Runners().main();
        } catch(Exception e) {
            e.printStackTrace();
        }
        int[] a = new int[]{1, 3, 5};
        int b = a.length;
        a.clone();

        for (int c = 1 ; c <= 2; c++) {

        }
    }
}
