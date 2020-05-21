package practice.basicfeature.novice.searchsample;

import java.util.*;
import java.util.stream.LongStream;

import static java.util.Arrays.stream;

public class SpeedChecker {

    public static final int SIZE = 1000;
    public static final long RAND = 100000;
    public static final long[] baseItems = LongStream.range(0, 1000).toArray();
    static List<Integer> arraylist = new ArrayList<>();

    static int[] array;

    public long[] makeRundomArr() {
        long[] arr = new long[SIZE];
        final LongValueGenerator gen = new LongValueGenerator(SIZE);
        return Arrays.stream(arr).map(x -> gen.next()).toArray();

    }

    public static void printElem(long[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    public SpeedChecker() {

    }
    public static void main(String[] args) {
        SpeedChecker s = new SpeedChecker();
        printElem(s.makeRundomArr());
    }


}
