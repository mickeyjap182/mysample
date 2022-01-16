package practice.basicfeature.novice.functionally;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamLambda {

    public static final int AAA = 100;
    public static final int BBB = 256;
    public static void main(String[] args) {
        StreamLambda mySelf = new StreamLambda();
        mySelf.easyMethod01();
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
        predicts();
        mySelf.tutorial03();


    }


    /**
     * sample of Stream
     */
    public void tutorial00() {

        int[] nums = IntStream.range(1, 11).toArray();
        new Random().ints();
    }

    /**
     * Inner class of Lambda method
     *
     */
    public static class Joiner {
        public Joiner() {}

        /**
         * It returns function join initial string and parameter string.
         *
         * @param before
         * @return function recieve string as concat param.
         */
        public Function<String, String> join(final String before) {
            return after -> before.join(after);
        }


    }

    /**
     * easy method.
     */
    public void easyMethod01() {
        System.out.println(String.format("==00.お得なメソッド=="));

        int small = 255;
        int large = 256;
        // 少ない記述で制御可能なやつ。
        System.out.println(String.format("==findMaximum(small, large)=%d small=%d large=%d ==", findMaximum(small, large), small, large));
        System.out.println(String.format("==findBadMaximum(small, large)=%d small=%d large=%d ==", findBadMaximum(small, large), small, large));
        System.out.println(String.format("==findMinmum(small, large)=%d small=%d large=%d ==", findMinmum(small, large), small, large));
        System.out.println(String.format("==findBadMinmum(small, large)=%d small=%d large=%d ==", findBadMinimum(small, large), small, large));

    }

    /**
     * sample of Lambda
     */
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

        Map<Integer, String> list = new HashMap<>();

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

        // キャッシュから返す
        System.out.println(lambda.apply(2));

    }

    /**
     * flat
     */
    public void tutorial03() {


        Map<String, List> purchageDateUsers = new HashMap<>();

        List<Purchase> purchases = List.of(
            new Purchase("2021/12/15", "car", "aaa"),
                new Purchase("2021/12/15", "car", "bbb"),
                new Purchase("2021/12/16", "car", "ccc"),
                new Purchase("2021/12/13", "car", "aaa"),
                new Purchase("2021/12/15", "car", "bbb"),
                new Purchase("2021/12/18", "car", "ccc"),
                new Purchase("2021/12/18", "car", "aaa"),
                new Purchase("2021/12/15", "car", "bbb"),
                new Purchase("2021/12/18", "car", "ccc"),
                new Purchase("2021/12/17", "car", "aaa"),
                new Purchase("2021/12/13", "car", "bbb"),
                new Purchase("2021/12/15", "car", "ccc")
        );

        Function<Purchase, String> key = k -> {
            return k.date + k.purchaseName;
        };
        Integer a = 100;
        boolean is_101 = a == 101;
        Map<String, List<Purchase>> purchases2 = purchases.stream().collect(Collectors.groupingBy(key));
//        Map<String, List<Purchase>> purchases2 = purchases.stream().collect(Collectors.groupingBy(key)).entrySet().stream().collect(Collectors.toMap(
//
//        ));
        List<String> user1 = List.of("al", "bl", "cl");
        List<String> user2 = List.of("al", "dl");
        List<String> user3 = List.of("cl", "dl");
        String sss = user2.stream().collect(Collectors.joining(","));
        purchageDateUsers.put("class1", user1);
        purchageDateUsers.put("class2", user2);
        purchageDateUsers.put("class3", user3);
//        purchases2.stream().collect(Collectors.toList());
//        purchageDateUsers.entrySet().forEach(k -> System.out.println(k.getKey() + k.getValue().stream().collect(Collectors.joining(","))));
        purchases2.entrySet().forEach(k -> {
            String values = k.getValue().stream().map(v -> v.userName).collect(
                    Collectors.joining(","));
            System.out.println(k.getKey() + ":" + values);
        });
    }
    public static class Purchase {
        final String date;
        final String purchaseName;
        final String userName;
        Purchase(String date, String purchaseName, String userName) {
            this.date = date;
            this.purchaseName = purchaseName;
            this.userName = userName;
        }

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

    public static int findMaximum(int first, int second) {

        return Math.max(first, second);
    }

    public static int findBadMaximum(int first, int second) {

        return first >= second ? first :second;
    }

    public static int findMinmum(int first, int second) {

        return Math.min(first, second);
    }
    public static int findBadMinimum(int first, int second) {

        return first <= second ? first : second;

    }

    public static void predicts()
    {
        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));

        System.out.println( EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultMale()) );

        System.out.println( EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAdultFemale()) );

        System.out.println( EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35)) );

        //Employees other than above collection of "isAgeMoreThan(35)"
        //can be get using negate()
        System.out.println(EmployeePredicates.filterEmployees(employees, EmployeePredicates.isAgeMoreThan(35).negate()));
    }
}
