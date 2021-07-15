package practice.basicfeature.novice.functionally;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DelayedEvaluation {

    public static final int AAA = 100;
    public static final int BBB = 256;
    public static void main(String[] args) {
        DelayedEvaluation mySelf = new DelayedEvaluation();
        mySelf.tutorial01();
        mySelf.tutorial02();
        // https://stackoverflow.com/questions/32206092/java8-method-reference-used-as-function-object-to-combine-functions

        Integer P = 100;

        System.out.println(String.format("1. (Integer 100 == int 100): %b",(Boolean) (P == AAA)));
        System.out.println(String.format("2. (Integer 100.equals( int 100)): %b",(Boolean) (P.equals(AAA))));

        P = 256;
        System.out.println(String.format("3. (Integer 100 == int 256): %b",(Boolean) (P == BBB)));
        System.out.println(String.format("4. (Integer 100 == int 100): %b",(Boolean) (P.equals(BBB))));

        P = 256;
        IntStream rangeStream = IntStream.range(1, 10);
        Stream boxedStream = rangeStream.boxed();
//        List<Integer> rangeList = boxedStream.collect(Collectors.toList());


//        System.out.println(String.format("3. (Integer 100 == int 256): %b",sum(rangeList, 3));
        System.out.println(String.format("4. (Integer 100 == int 100): %b",(Boolean) (P.equals(BBB))));

    }


    public static class Joiner {
        public Joiner() {}

        public Function<String, String> join(final String before) {
            return after -> before.join(after);
        }


    }

    public void tutorial00() {

        int[] nums = IntStream.range(1, 11).toArray();
        new Random().ints();
    }

    public void tutorial01() {
        System.out.println(String.format("==01.基本的な使い方=="));


        // 関数1 lambda 定義 Function<T, R>
        Function<Integer, String> lambda = seeds ->  {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-512");
                digest.reset();
                digest.update(seeds.toString().getBytes("utf8"));
                return digest.digest().toString();
            } catch( NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;

            }
        };
        // 値をバインドして実行する。  apply(T)
        System.out.println(lambda.apply(3));
        System.out.println(lambda.apply(2));

        // 関数2
        Function<String, String> repeater = seeds -> seeds.repeat(3);

        // 関数1:lambda を適用して関数2:repeater を適用する
        Function<Integer, String> sum = lambda.andThen(repeater);
        System.out.println(sum.apply(2));

        Function<String, String> joiner = new Joiner().join("001");
        joiner.apply("002");

    }

    public void tutorial02() {
        System.out.println(String.format("==02.lambdaを渡してsetupし、その後に実行する=="));

        Map<Integer, String> list  = new HashMap<>();

        // 適用したいメソッドに関数(lambda)を渡す。
        Function<Integer, String> lambda = memorize(
                this.hash()
//                salt -> {
//            try {
//                System.out.println(String.format("--- 交換可能なlambda適用(実行) param: %d ---", salt));
//                MessageDigest digest = MessageDigest.getInstance("SHA-512");
//                digest.reset();
//                digest.update(salt.toString().getBytes("utf8"));
//                return digest.digest().toString();
//            } catch( NoSuchAlgorithmException | UnsupportedEncodingException e) {
//                e.printStackTrace();
//                return "";
//
//            }
        );

        // パラメータを適用する。
        System.out.println(lambda.apply(1));
        System.out.println(lambda.apply(2));
        System.out.println(lambda.apply(3));

        // キャッシュから返す、
        System.out.println(lambda.apply(2));

    }

    public Function<Integer, String> hash() {
        return i -> {
            try {
                System.out.println(String.format("--- 交換可能なlambda適用(実行) param: %d ---", i));
                MessageDigest digest = MessageDigest.getInstance("SHA-512");
                digest.reset();
                digest.update(i.toString().getBytes("utf8"));
                return digest.digest().toString();
            } catch( NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
                String s = "";
                return s;

            }
        };
    }

    public Function<Integer, String> memorize(Function<Integer, String> f) {
        // 初期化処理に該当する
        Map<Integer, String> memo = new HashMap<>();
        System.out.println("---memorizeの初期化---");

        // lambdaの実行結果メソッドをメモ化する。
        return m -> {
            if (memo.get(m) == null) {
                memo.put(m, f.apply(m));
            }
            System.out.println("---memorize適用(実行)---");
            return memo.get(m);
        };
    }

    public static String Arms(Integer count) {

        return "a".repeat(count);
    }

//    public int sum(List<Integer> sumList, int _) {
//
//        return sumList.stream().mapToInt().sum();
//    }
}
