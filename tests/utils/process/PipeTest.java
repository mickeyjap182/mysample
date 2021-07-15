package utils.process;

import org.junit.jupiter.api.Test;
import practice.utils.process.Pipe;

import java.util.StringJoiner;

public class PipeTest {

    @Test
    public void test_サンプル() {

        long num = Long.parseLong("10") + 20L;
        String ret = String.valueOf(num);
        System.out.println(String.format("str: %s", ret));

        Pipe p = new Pipe();
        p.tmp("go");

        String asb = "Hello まいう!";
        for(int index = 0; index < 10; index++) {
            System.out.println(String.format("str index: %d -> %c", index, asb.charAt(index)));
        }


        StringJoiner j = new StringJoiner(",");
        Pipe.Status[] s = Pipe.Status.values();
//        Arrays.stream(s).map({sval -> System.out.println()});
        System.out.println();
    }

    @Test
    public void test_サンプルsendCommand() {

        Pipe p = new Pipe();
        p.sendCommand("go");
    }

}
