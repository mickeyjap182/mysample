package utils.process.datastruct;

import org.junit.jupiter.api.Test;
import practice.utils.datastruct.Que;

import java.util.List;
import java.util.stream.Collectors;

public class QueTest {

    public class Threading extends Thread {
        private String name;
        private int no;
        private Que fifo;
        public Threading(int no, String name, Que que) {
            super();
            this.name = name;
            this.no = no;
            fifo = que;

        }

        public void run() {
            System.out.println("No. " + Integer.toString(no)  + " is started running.");


            fifo.put(name);


            String message = fifo.poll();
            System.out.println("No. " + Integer.toString(no)  + " " + message + " is poped message.");
            System.out.println("No. " + Integer.toString(no)  +  " is finished running.");
        }

        public int getNo() {
            return no;
        }

    }

    @Test
    public void test_bloking_que() {



        System.out.println("=====start main thread=====");
        Que q = new Que(10);

        List<Threading> tasks =  List.of(
                new Threading(1, "apple" , q),
                new Threading(2, "banana", q),
                new Threading(3, "orange", q),
                new Threading(4, "tomato", q),
                new Threading(5, "cherry", q),
                new Threading(6, "melon" , q)

        );

        tasks.parallelStream().map(t -> {
            try {

                t.start();
                // use join() if you wait for all threads.
                t.join(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return t;
        }).collect(Collectors.toList());


        System.out.println("=====end main thread=====");




    }

}
