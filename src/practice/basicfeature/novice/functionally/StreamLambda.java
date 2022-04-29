package practice.basicfeature.novice.functionally;

import org.apache.commons.lang3.time.DateUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamLambda {

    public static final int AAA = 100;
    public static final int BBB = 256;

    /**
     * sample of Stream
     */
    public void numberStream() {
        // int型のやつ。
        Integer P = 100;
        System.out.println(String.format("1. (Integer 100 == int 100): %b",(Boolean) (P == AAA)));
        System.out.println(String.format("2. (Integer 100.equals( int 100)): %b",(Boolean) (P.equals(AAA))));

        P = 256;
        System.out.println(String.format("3. (Integer 100 == int 256): %b",(Boolean) (P == BBB)));
        System.out.println(String.format("4. (Integer 100 == int 100): %b",(Boolean) (P.equals(BBB))));

        IntStream rangeStream = IntStream.range(1, 10);

        System.out.println(String.format("5. (IntStream.count()): %d",rangeStream.count()));
        System.out.println(String.format("6. (IntStream.max()): %d",IntStream.range(1, 10).max().getAsInt()));
        System.out.println(String.format("7. (IntStream.min()): %d",IntStream.range(1, 11).min().getAsInt()));
        System.out.println(String.format("8. (IntStream.average()): %f",IntStream.range(1, 12).average().getAsDouble()));

        IntStream multi = IntStream.of(1, 3, 5, 7, 11, 5, 3);
        System.out.println(String.format("9. (IntStream.distinct()): %d",multi.distinct().count()));

        Predicate<Integer> predicate = x -> x > 20;
        System.out.println(String.format("10. (IntStream.allMatch()): %b", IntStream.of(1, 3, 5, 7, 11, 5, 3).allMatch(predicate::test)));

        new Random().ints();
//        ToIntFunction<int[]>[] x = (x1) -> {
//            Arrays.stream(x1).sorted();
//        };

    }
    public void stringStream() {
        Function<String, Integer> function = StreamLambda.combine(String::length, n -> n * 2);
        System.out.println(function.apply("foo"));

    }

    public void castStream() {
        IntStream rangeStream = IntStream.range(1, 10);
        Stream boxedStream = rangeStream.boxed();
        boxedStream.forEach(System.out::println);

    }


    public static <T1, T2, T3> Function<T1, T3> combine(
            Function<T1, T2> first,
            Function<T2, T3> second) {
        return first.andThen(second);
    }

    /**
     * sample of Stream
     */
    public strictfp void ListMapStreams() {
        Function<Integer, Date> fx = minute -> DateUtils.addMinutes(new Date(), minute);
        var employees = List.of(
            new Employee(1,23,"M","Rick","Beethovan",fx.apply(-89260)),
            new Employee(2,26,"M","Ben","Beethovan",fx.apply(600000)),
            new Employee(3,25,"F","Risa","Beethovan",fx.apply(-344560)),
            new Employee(4,23,"F","Luca","Beethovan",fx.apply(244560)),
            new Employee(5,27,"M","Alex","Beethovan",fx.apply(124560)),
            new Employee(6,23,"M","Dan","Beethovan",fx.apply(-144560)),
            new Employee(7,27,"M","Bob","Beethovan",fx.apply(-560)),
            new Employee(8,26,"F","Anne","Beethovan",fx.apply(304560)),
            new Employee(9,25,"F","Cathy","Beethovan",fx.apply(-644560)),
            new Employee(10,25,"F","Beth","John", fx.apply(944560))
        );
        var ret = employees.stream()
                .collect(
                        Collectors.groupingBy(
                                Employee::getId,
                                Collectors.groupingBy(Employee::getBirthTime, TreeMap::new, Collectors.toList()
                        )
                ));
        // 結果
        ret.entrySet().stream().forEach(map -> {
            StringBuilder sb = new StringBuilder();
            sb.append("key:" + map.getKey());
            map.getValue().entrySet().stream().forEach(treemap -> {
                sb.append("{ key:" + treemap.getKey() + " value:");
                treemap.getValue().stream().forEach(v -> sb.append(v.getFirstName()));
                sb.append(" }");
            });
            sb.append("\n");
            System.out.print(sb.toString());
        });


        // divide into groups.
        BiConsumer<List<Employee>, Map<Integer, List<Employee>>> teamNize = (emp, nodes) -> {
            var index = new AtomicInteger();
            employees.parallelStream()
                    .forEach(
                        e -> {
                            // Mappinf
                            var i = index.getAndIncrement() % nodes.size();
                            nodes.get(i).add(e);
                        }
                    );
        };

        // average age on each of team members.
        Function<Map<Integer, List<Employee>>, Map<Integer,Double>> averageAge = (emps) -> {
            return emps.entrySet().parallelStream()
                .map(e -> {
                    var size = e.getValue().size();
                    var sum = e.getValue().stream().map(Employee::getAge).reduce((accum,  i) -> accum + i).orElse(0);
                    double avg = sum == 0 ? 0 : (double) sum / size;
                    return Map.entry(e.getKey(), avg);
                }).collect(Collectors.toMap(
                    e -> e.getKey(),
                    e -> e.getValue(),
                (e1, e2) -> e1
            ));
        };

        // prepare for grouping.
        final Map<Integer, List<Employee>> nodes = IntStream.range(0, 3).boxed()
                .collect(
                        ConcurrentHashMap::new,
                        (Map<Integer, List<Employee>> m , Integer i) -> m.put(i, new ArrayList<>()),
                        Map::putAll
                );


        long c = nodes.values().stream().map(v -> v.stream().count()).reduce((prev, curr) -> prev + curr).orElse(0L);
        System.out.println(String.format(" reduce total: %d", c));

        // divide employees into 3 groups.
        teamNize.accept(employees, nodes);
        System.out.println(String.format(" nodes.size(): %d", nodes.size()));
        c = nodes.values().stream().map(v -> v.stream().count()).reduce((prev, curr) -> prev + curr).orElse(0L);
        System.out.println(String.format(" reduce total: %d", c));

        // each teams.
        var ages = averageAge.apply(nodes);
        ages.entrySet().forEach(e -> System.out.println(String.format(" reduce team: %d, age(average): %f ",e.getKey() ,e.getValue())));

        var index = new AtomicInteger();
        var i = index.getAndIncrement() % nodes.size();
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
        System.out.println("===end date====");
        Stream<Purchase> purchase = purchases2.entrySet().stream().flatMap(v -> v.getValue().stream());
        purchase.forEach(v -> System.out.println(v.date));
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
