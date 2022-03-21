package practice.basicfeature.novice.functionally.essence;

import java.util.function.Consumer;

/**
 * retunr void, just proccess.
 */
public class Consumers {
    public void printSum(int a,  int b) {
        Consumer<Integer> c = new Consumer<>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i.intValue() + b);
            }
        };
        c.accept(a);
    }
}
