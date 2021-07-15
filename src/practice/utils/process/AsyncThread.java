package practice.utils.process;

import java.util.function.BiFunction;

public class AsyncThread implements Runnable {


    BiFunction<String, String, String> method;
    public String first;
    public String second;

    public AsyncThread(BiFunction<String, String, String>  method, String first, String second) {
        super();
        this.method = method;
        this.first = first;
        this.second = second;
    }

    public void start(String a, String b) {
        this.first = a;
        this.second = b;
        run();

    }
    @Override
    public void run() {

        try {
            String task = method.apply(this.first , this.second);
            System.out.println(String.format("thread: task %s", task));

            // 間を開ける。
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            return ;
        }

    }

}
