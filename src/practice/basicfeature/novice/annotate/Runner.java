package practice.basicfeature.novice.annotate;

import java.util.function.BiFunction;

public class Runner {
    public void wakeup() {

        BiFunction<Integer, Integer, Integer> o = (x1, x2) -> {
            int hex = 0xff00; // 2byte長で、1byte目: 全部1bit立ってる、 2byte目: 全部0bit
            x1 |= x2&hex;  // & でビット積算、|=で関の和
            return x1;
        };
        System.out.println(o.apply(500,400));
        System.out.println(o.apply(500,500));
        System.out.println(o.apply(500,600));
        System.out.println(o.apply(500,700));
        System.out.println(o.apply(15,300));
    }

    public static class Operator {
        public int add(int x1, int x2) {
            return 0;
        }

        public int minus(int x1, int x2) {
            return 0;
        }
        public int multiply(int x1, int x2) {
            return 0;
        }
        public int divide(int x1, int x2) {
            return 0;
        }
        public int amp(int x1, int x2) {
            return 0;
        }
    }
}
