package practice.basicfeature.novice.functionally.essence;

import practice.utils.logger.DebugLogger;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Comparer {

    private final Object target;
    public Comparer(Object _target){
        this.target = _target;
    }
    public static boolean isNull(BiFunction<Object, Object, Object> func, Object p1, Object p2) {

        boolean ret = List.of(func, p1, p2).stream().anyMatch(x -> x == null);
        if (ret) return true;
        return func.apply(p1,p2) == null;
    }
    public boolean isNull() {
        return target == null ;
    }

//    public static <S> ThreadLocal<S> withInitial(Supplier<? extends S> supplier) {
//        return new ThreadLocal.SuppliedThreadLocal<>(supplier);
//    }
    public Map<Integer, String> sort() {

        var map = Map.of(
                "apple", new Fruit("starKing",60),
                "banana", new Fruit("cavendish",30),
                "orange", new Fruit("mandarine orange",35),
                "water mellon", new Fruit("tikito",20)
        );
        var map1 = Map.of(
                "apple", 60,
                "banana", 30,
                "orange", 35,
                "water mellon", 20
        );
        var list1 = List.of(60, 30, 35, 20);
        var comparator = Comparator.comparingInt(Fruit::getCent);

        var debug = new DebugLogger();
        debug.next("start");
        var sorted = map.values().stream()
                .sorted(comparator).collect(Collectors.toList());
        sorted.stream().forEach(v -> System.out.println(v.getCent()));

        debug.logging(System.out, DebugLogger.IOResource.CONSOLE);
        list1.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);

//        var sortedMap = map.entrySet().stream()
//                .sorted(e -> Comparator.comparing(e))
//                .collect(Collectors.toMap(
//                    c -> c.getCent(),
//                    c -> c.getName(),
//                    (o, n) -> o,
//                    HashMap::new
//        ));
//        sorted.stream().forEach(v -> System.out.println(v.getCent()));

        return Map.of(1,"a");

//        return map.values().stream()
//                .sorted(comparator)
//                .collect(Collectors.toMap(
//                    c -> c.getCent(),
//                    c -> c.getName(),
//                    (o, n) -> o,
//                    HashMap::new
//        ));

    }
    private static class Fruit {
        private final String name;
        private final Integer cent;
        public Fruit(String name, Integer cent) {
            this.name = name;
            this.cent = cent;
        }
        public String getName() {
            return name;
        }
        public Integer getCent() {
            return cent;
        }
    }
}
