package practice.basicfeature.novice.threading;

import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.syntax.Runner;

public class RunnerTest {

    @Test
    public void test_go() {
        try {
            new Runner().main();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
