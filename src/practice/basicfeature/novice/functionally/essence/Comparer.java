package practice.basicfeature.novice.functionally.essence;

import java.util.List;
import java.util.function.BiFunction;

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

}
