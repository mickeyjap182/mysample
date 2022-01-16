package practice.basicfeature.algorithm.searchsample;

import java.util.*;
import java.util.stream.LongStream;

public class SpeedChecker {

    public static final Integer SIZE = 1000;
    public static final long RAND = 100000;
    public static final long[] baseItems = LongStream.range(0, 1000).toArray();

    static int[] array;

    public Object[] makeRundomArr() {
        Long[] arr = new Long[SIZE];
        final LongValueGenerator gen = new LongValueGenerator(SIZE);
        return Arrays.stream(arr).map(x ->  gen.next()).toArray();
    }

    public static void printElem(Object[] arr) {
        Arrays.stream(arr).forEach(System.out::println);
    }

    public SpeedChecker() {

    }
    public static void main(String[] args) {
        SpeedChecker s = new SpeedChecker();
        printElem(s.makeRundomArr());

    }

// 処理の部分が
//   DB分割を作って奥。やるどうか判断をするところまで、第一段階。
//   段階をする。説明できる材料を。
    // デメリット s2, s3ドメイン分ける。をする。
    //


}
