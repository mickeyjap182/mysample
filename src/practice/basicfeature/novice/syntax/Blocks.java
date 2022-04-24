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

        int a0 = 0;
        System.out.println(String.format("nest0 a0: %s ", a0));
        {
            a0 = 1;
            int a1 = 11;
            System.out.println(String.format("nest1 a0: %s ", a0));
            System.out.println(String.format("nest1 a1: %s ", a1));
            {
                a0 = 2;
                a1 = 12;
                int a2 = 22;
                System.out.println(String.format("nest2 a0: %s ", a0));
                System.out.println(String.format("nest2 a1: %s ", a1));
                System.out.println(String.format("nest2 a2: %s ", a2));

            }
            // it is activated of modification by inner scope.
            System.out.println(String.format("nest2 a0: %s ", a0));
            System.out.println(String.format("nest2 a1: %s ", a1));
        }
        //  it is activated of modification by inner scope.
        System.out.println(String.format("nest2 a0: %s ", a0));


    }
}
