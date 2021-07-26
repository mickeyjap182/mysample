package practice.basicfeature.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class A002SieveOfEratosthenes {


    public Map<Integer, Integer>  main(int min, int max) {


        Map<Integer, Integer> list = initial(min, max);
        System.out.println(format(list));

        // fillter
        list.put(0, null);
        list.put(1, null);
        var result = filter(list, 2);
        result = filter(result, 3);
        result = filter(result, 5);
        result = filter(result, 7);
        result = filter(result, 11);

        // 11 > route 99 ... 9.95
        return result;

    }

    /** make a sieve map. */
    public Map<Integer, Integer> initial(int min, int max) {
        return IntStream.range(min, max).mapToObj(v -> v).collect(Collectors.toMap(k -> k, v -> v));
    }

    /** make a filter */
    public Map<Integer, Integer> filter(Map<Integer, Integer> map, int target) {
        final Map<Integer, Integer> newMap = new HashMap<>();
        map.entrySet().stream().map(v -> {
            // 値なしか、最初の値(素数)か、素数の倍数値でない場合は値に変更なし
            if (v.getValue() == null || v.getValue() == 0 || v.getValue() / target == 0 || v.getValue() % target != 0) {
                newMap.put(v.getKey(), v.getValue());
            } else {
                // 素数の倍数値か
                newMap.put(v.getKey(), null);
            }
            return v.getKey() ;
        }).collect(Collectors.toMap(k -> k, v -> v));

        return newMap;
    }

    /** make a format */
    public static String format(Map<Integer, Integer> numerics) {
        final String padding = "3";

        StringBuffer sb = new StringBuffer();
        String message = numerics.entrySet().stream().map(elm -> {
            String val = elm.getValue() == null ? "" : Integer.toString(elm.getValue());
            return elm.getKey() % 10 == 9 ? String.format("%" + padding + "s\r\n",  val) : String.format("%" + padding + "s", val);
        }).collect(Collectors.joining());

        return sb.append(message).toString();
    }
}
