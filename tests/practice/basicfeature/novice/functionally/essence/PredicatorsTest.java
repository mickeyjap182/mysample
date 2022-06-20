package practice.basicfeature.novice.functionally.essence;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

public class PredicatorsTest {
    @Test
    public void testPredicators() {
        Predicate<Integer> bool = x -> x + 5 > 10;
        Predicators<Integer> v = new Predicators(bool);
        System.out.println(v.execute(5));;
        System.out.println(v.execute(6));;

        System.out.println(v.gt10());
    }


}