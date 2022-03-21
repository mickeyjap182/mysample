package practice.basicfeature.novice.functionally.essence;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Predicators<T> implements Predicate<T> {

    /** ラムダ式 filterできるbool結果式? */
    private final Predicate<T> target;

    public Predicators(Predicate<T> func){
        target = func;
//        target = i -> (i - 10 > 10);
//        target = (p<Executor<T>> -> p.execute(t));
    }
    public boolean execute(T e) {
        boolean ret = target.test(e);
        return ret;
    }

    /**
     * 比較メソッドサンプル
     * @return
     */
    public Predicate<Integer> gt10() {
        return i -> (i - 10 > 10);

    }

    /**
     * 比較メソッドサンプル2
     * @return
     */
    public BiPredicate<String, String> isOverLength5() {
        return (s1, s2) -> (s1 + s2).length() > 5;

    }

        /**
         * このメソッドの評価
         * @param t T
         * @return
         */
    @Override
    public boolean test(T t) {
        return false;
    }

    @Override
    public Predicate<T> and(Predicate<? super T> other) {
        return null;
    }

    @Override
    public Predicate<T> negate() {
        return null;
    }

    @Override
    public Predicate<T> or(Predicate<? super T> other) {
        return null;
    }
}
