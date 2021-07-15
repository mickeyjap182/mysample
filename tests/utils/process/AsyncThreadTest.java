package utils.process;

import org.junit.jupiter.api.Test;
import practice.utils.process.AsyncThread;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class AsyncThreadTest {


    @Test
    public void test_サンプル() {

        BiFunction<String, String, String> method = (p , q) -> {
            return p + ":" + q;
        };

        List<Thread> threads = List.of(
            new Thread(new AsyncThread(method, "No.1", "apple")),
            new Thread(new AsyncThread(method, "No.2", "banana")),
            new Thread(new AsyncThread(method, "No.3", "orange")),
            new Thread(new AsyncThread(method, "No.4", "cherry")),
            new Thread(new AsyncThread(method, "No.5", "melon")),
            new Thread(new AsyncThread(method, "No.6", "strawberry")),
            new Thread(new AsyncThread(method, "No.Last", "orange"))
        );

        System.out.println("=====join on each thread=====");
        System.out.println("main:start");
            threads.stream().peek(t -> {
                try {

                System.out.println("sub: a thread will start.");
                t.start();
                t.join(1);
                System.out.println("sub: a thread has joined.");

                } catch(InterruptedException ex) {
                    ex.printStackTrace();
                    return;
                }

            }).collect(Collectors.toList());

        System.out.println("main: all thread has finished on pipline.");

//        prototype <aa extends ?>



    }

}
