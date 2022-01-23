package practice.basicfeature.novice.syntax;

import practice.utils.logger.TimeLogger;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

//import apache.commons.lang.SerializationUtils;

public class Runner {
    enum Bird {
        CROW,
        SPARROW,
        SWAN
    }

    /** inner interface for an Anonymous class.  */
    interface Animal {
        default public String getName() {return "unknown";}
        public int getWeight();
        public void bark();
    }

    interface EvalInstance {
        public Object create(String className, String fullClassName);
    }

    private static String[] learnTask;

    private static TimeLogger logger = TimeLogger.getLogger();

    /** instance initializer */
    List<String> numbers = new ArrayList<>(); {
        numbers.add("One");
        numbers.add("Two");
        numbers.add("Three");

        logger.info("instance initializer!");

    }

    /** static initializer */
    static {
        learnTask = new String[] {
            "initializer",
            "staticInitializer",
            "classLoader",
            "anonymousClass",
            "anonymousMethod",
        };
        logger.info("static initializer!");
    }

    /** constructor as dynamic initializer */
    public Runner(){
        logger.info("in constructor!");
    }

    /**
     * verify class loaders.
     *
     */
    public void main() throws ClassNotFoundException,
            InterruptedException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException {

        logger.info("startup!! main()!!");
        runDataType();
        logger.info("");
        innerClass();

        String className = "practice.basicfeature.novice.syntax.MoneyPod";
//        MoneyPod a = new practice.basicfeature.novice.syntax.MoneyPod();
//        SerializationUtils.clone();


        Class<?> cls = Class.forName(className);
        try {
            Constructor<?> c = cls.getDeclaredConstructor(Integer.class);
            Object instance = c.newInstance(100);
            if (instance instanceof MoneyPod) reflectAndSerialize((MoneyPod) instance);

        } catch (InvocationTargetException ex) {
            System.out.println("===it is instance of other of MoneyPod.==");

        } finally {
            System.out.println("== it is ending.==");
        }
        new Algo().start();
        block();
    }

    private void reflectAndSerialize(MoneyPod mp) {
        System.out.println("===it is instance of MoneyPod.==");
        try {

        } catch (MoneyPodOverflowException ex) {
            ex.printStackTrace();
        }
    }

    private void innerClass() {

        /** Inner classes. */
        // I'm a dog.
        Animal dog = new Animal() {
            @Override
            public String getName(){ return "beagle dog"; }
            public int getWeight() {
                return 20;
            }
            public void bark() {
                System.out.println("bow!!");
            }
        };

        // I'm a cat.
        Animal cat = new Animal() {
            @Override
            public String getName(){ return "samal cat"; }
            public int getWeight() {
                return 10;
            }
            public void bark() {
                System.out.println("mew!!");
            }

        };

        /** Inner Functions. */
        // 2 param and 1 return
        BiFunction<Animal, String, Integer> printWeight = (animal, name) -> {

            System.out.printf("%s's weight is %d kg.\n", name, animal.getWeight());
            return 0;
        };

        // 1 param and 1 return
        Function<Animal,Integer> printBark = (animal) -> {
            System.out.printf("My name is %s ,  and barks that...", animal.getName());
            animal.bark();
            return 0;
        };

        logger.info("=== Anonymous Classes And Functions are here. ===");
        printWeight.apply(cat, "Cat");
        printWeight.apply(dog, "Dog");

        printBark.apply(cat);
        printBark.apply(dog);

        int a = Payment.CREDIT.getValue();

        logger.info(Integer.toString(a));

        String aa = Arrays.stream(Payment.values()).map(Payment::getValue).toString();
        logger.info(aa);

    }
    private void runDataType() {

        System.out.println("====== data type test.====");
        System.out.println("============== enum");
        String[] enumValue = new String[] {"SPARROW", "MORE", null};
        for(var value: enumValue) {
            try {
                Bird.valueOf(value);

            } catch(IllegalArgumentException | NullPointerException e) {
                e.printStackTrace();
            }

        }
        System.out.println("============== List");
        List<String> list;
        list = Arrays.asList();
        System.out.println(String.format("Arrays.asList() Type: %s , Length: %d", list.getClass().getName(), list.size()));
//        HashMap<_Input, _Output> aaa;
        System.out.println("============== Map -- hashmap 同期を取らないhashtable");
        Map<String, String> table =new Hashtable<>();
        // TODO:Concurrent
        table.size();
        // TODO:匿名クラス

        // Runnableで実装とThreadで実装
    }

    void block() {
        new Blocks().main();
    }
}
