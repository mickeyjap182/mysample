package practice.basicfeature.novice.threading;

import org.junit.jupiter.api.Test;

public class RunnerTest {

    @Test
    public void test_go() {
        try {
            new Runner().main(new String[]{});
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
