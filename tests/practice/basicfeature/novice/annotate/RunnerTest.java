package practice.basicfeature.novice.annotate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunnerTest {
    @Test
    public void test_go() {
        try {

            new Runner().wakeup();

            assertTrue(true);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
