package practice.basicfeature.novice.extendsinterface;

import org.junit.jupiter.api.Test;

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
