package practice.basicfeature.novice.syntax;

import com.sun.jdi.VoidValue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import practice.utils.logger.TimeLogger;

public class Runner {

    /** inner interface for an Anonymous class.  */
    interface Animal {
        default public String getName() {return "unknown";}
        public int getWeight();
        public void bark();
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
    public void main() throws InterruptedException {

        logger.info("startup!! main()!!");
        innerClass();
/*
        boolean isInitialize = true;
        String targetClass = "java.util.list";
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return super.loadClass(name);
            }
        }

        String[] fruitArr = new String[]{"Apple", "Banana", "Citrus"};

        try {

            Class.forName(targetClass,isInitialize,);
        } catch (ClassNotFoundException e) {
           e.printStackTrace();

        }
*/
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

    }
}
