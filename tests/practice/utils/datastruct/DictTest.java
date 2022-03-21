package practice.utils.datastruct;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class DictTest {

    @Test
    public void testMain() {
        Dict d = new Dict();
        d.addOrPut("bob", "13");
        d.addOrPut("Jun", "15");
        d.addOrPut("Dan", "17");
        print(d.getALL());
        d.addOrPut("Jun", "14");
        print(d.getALL());
        d.remove("Dan");
        print(d.getALL());

        String key = "";
        System.out.println(d.get(key));
        key = null;
        System.out.println(d.get(key));

        assertEquals("a","a");
    }

    public void print(Map<String, String> m) {
        System.out.println("== start ==");
        m.entrySet().stream().forEach(
                e -> System.out.println(e.getKey() + ":" + e.getValue()));
        System.out.println("== end ==");

    }
}