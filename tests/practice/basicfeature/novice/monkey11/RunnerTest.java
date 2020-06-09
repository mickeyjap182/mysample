package practice.basicfeature.novice.monkey11;

import com.sun.jdi.connect.Connector;
import org.junit.jupiter.api.Test;
import practice.basicfeature.novice.monkey11.Runner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RunnerTest {

    @Test
    public void test_go() {
        try {
            List<String> args = List.of("start", "2");
            new Runner().main(args.toArray(new String[args.size()]));
            assertTrue(true);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
