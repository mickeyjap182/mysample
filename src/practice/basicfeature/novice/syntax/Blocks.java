package practice.basicfeature.novice.syntax;

import java.util.HashMap;
import java.util.Map;

public class Blocks {
    public void main() {
        Map<String, String> params;
        {
            params = new HashMap<>();
            params.put("a", "param1");
            params.put("b", "param2");
        }
        params.values().stream().forEach(System.out::println);

    }
}
