package practice.basicfeature.novice.syntax;

import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.syntax.Runner;

public class RunnerTest {
    @Test
    public void test_go() {
        try {
            new Runner().main();
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
