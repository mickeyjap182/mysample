package practice.basicfeature.novice.datastruct;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConcurrentQue implements Runnable {
    final static String BASIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String CODE_CHARS = "abcde";

    private Object lock = new Object();
    private static ConcurrentLinkedQueue que;
    private final String name;
    public ConcurrentQue(ConcurrentLinkedQueue c, String n) {
        synchronized (lock) {
            if (que == null) que = c;
        }
        name = n;
    }
    @Override
    public void run() {
        // FIFOでキュー
        final BiFunction<Integer, String, String> f  = (length, chars) -> {
            return IntStream.range(0, length)
                    .map(l ->
                            new Random().nextInt(chars.length())
                    ).mapToObj(i -> {
                        return chars.substring(i, i+1);
                    }).collect(Collectors.joining());
        };

        String company = f.apply(8, BASIC_CHARS);
        String code = f.apply(3, CODE_CHARS);

        Map<String, String> m = new HashMap<>();
        Map<String, String> m2 = new HashMap<>();
        int time = new Random().nextInt(300);
        time = 200;

        try {
            System.out.println(String.format("=== %s : que作成スタート(sleepすると壊れる) sleep時間: %d ===", name, time));
            System.out.println(String.format("=== %s : que1つ目作成中 sleep時間: %d ===", name, time));
            m.put(company, code);
            company = f.apply(8, BASIC_CHARS);
            code = f.apply(3, CODE_CHARS);
            m.put(company, code);
            this.add(m, String.format("=== %s : que1つ目 ConcurrentLinkedQueに登録試行 sleep時間: %d ===",name, time));
            System.out.println(String.format("=== %s : que1つ目作成済 sleep時間: %d ===", name, time));

//            time = new Random().nextInt(300);

            company = f.apply(8, BASIC_CHARS);
            code = f.apply(3, CODE_CHARS);
            m2.put(company, code);

            System.out.println(String.format("=== %s : que2つ目作成中 sleep時間: %d ===", name, time));
            company = f.apply(8, BASIC_CHARS);
            code = f.apply(3, CODE_CHARS);
            m2.put(company, code);
            this.add(m2, String.format("=== %s : que2つ目  ConcurrentLinkedQueに登録試行 sleep時間: %d ===", name, time));
            System.out.println(String.format("=== %s : que2つ目作成済 sleep時間: %d ===", name, time));
            System.out.println(String.format("=== %s : que全て作成完了 sleep時間: %d ===", name, time));
        } catch (InterruptedException e) {
            System.out.println(String.format("===  %s : sleep中に失敗 sleep時間: %d ===", name, time));
        }
    }

    public void add(Map<String, String> m, String message) throws InterruptedException {
        synchronized (lock) {
            System.out.println(message);
            que.add(m);
        }
    }

}
