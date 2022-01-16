package practice.basicfeature.algorithm.famous;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see <a href="https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes">click here.</a>
 */
public class A002SieveOfEratosthenes {


    public SortedMap<Integer, Boolean> main(int min, int max) {


        // make base tree map.
        SortedMap<Integer, Boolean> list = initial(min, max);
        System.out.println();
        System.out.println(format(list));

        // terminate rule: upper limit is less than or equal to square root of max value.
        int ceil = (int) Math.sqrt(max);

        // until first greater number. and 11 is the greater than or equal to square root of 100 (= 10).
        for(int i = 3; i < ceil ; i++) {

            if (isNotPrimeNumber(list, i)) continue;

            // sieve by Prime number.
            list = sieve(list, i);

        }

        return list;

    }


    /**
     * it seems that this number is a Prime number.
     * */
    public boolean isNotPrimeNumber(Map<Integer, Boolean> map, int target) {
        return !map.get(target);
    }

    /**
     * phase1.
     * make a sieve map and natural number from 2 .
     * */
    public SortedMap<Integer, Boolean> initial(int min, int max) {
        return IntStream.range(min, max)
                .mapToObj(i -> i)
                .collect(
                        Collectors.toMap(
                                k -> k,
                                v -> v < 2 || v % 2 != 0,
                                (b , a) -> { throw new InvalidParameterException(String.format("duplicate key : %d <-> %d")); },
                                TreeMap::new
                        )
                );
    }


    /**
     * phase2.
     * filter map value
     **/
    public SortedMap<Integer, Boolean> sieve(Map<Integer, Boolean> map, int target) {
        final SortedMap<Integer, Boolean> newMap = new TreeMap<>();
        map.entrySet().stream().map(v -> {
            // if sequential number  "a: is invalid -> remain 'false'" or "b: is first number -> remain 'true'" or "c: not multipul Prime number -> remain 'true'" .
            if (v.getValue() == false || Objects.equals(target, v.getKey()) || v.getKey() % target != 0) {
                newMap.put(v.getKey(), v.getValue());
            } else {
                // it is not prime number
                newMap.put(v.getKey(), false);
            }
            return v.getKey() ;
        }).collect(Collectors.toMap(k -> k, v -> v));

        return newMap;
    }

    /**
     * make a print format
     *
     * */
    public static String format(SortedMap<Integer, Boolean> numerics) {
        final String padding = "3";
        final int perLine = 10;

        StringBuffer sb = new StringBuffer();
        String message = numerics.entrySet().stream().map(elm -> {
            String val = elm.getValue() == false ? "/" : Integer.toString(elm.getKey());
            return elm.getKey() % perLine == (perLine - 1) ? String.format("%" + padding + "s\r\n",  val) : String.format("%" + padding + "s", val);
        }).collect(Collectors.joining());

        return sb.append(message).toString();
    }
}
