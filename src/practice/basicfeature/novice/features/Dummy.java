package practice.basicfeature.novice.features;

import org.apache.commons.lang3.time.FastDateFormat;
import practice.basicfeature.novice.features.lib.TimeBoard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.IntStream;

public class Dummy {
    public static void main(String[] args) {
        TimeBoard mySelf = new TimeBoard();
//        Clock mySelf = new Clock();
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
            Date earlier = f.parse("2019/01/12");
            Date after = f.parse("2019/01/13");
            Date sameafter = f.parse("2019/01/13");

            System.out.println(f.format(earlier));
            System.out.printf("%s compareTo %s = %d %n", f.format(earlier), f.format(after), earlier.compareTo(after));
            System.out.printf("%s compareTo %s = %d %n", f.format(after), f.format(earlier), after.compareTo(earlier));
            System.out.printf("%s compareTo %s = %d %n", f.format(after), f.format(sameafter), after.compareTo(sameafter));

            List<String> anull = null;
            final Dummy d = new Dummy();
            d.verify();

        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void verify() {
        final int cnt = (int) IntStream.rangeClosed(0,100).count();
        System.out.println(String.format( "intStream  : %d", cnt ));

        FastDateFormat fdf = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2021, Calendar.MARCH, 31, 0, 0, 0);
        Date date1 = calendar1.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2021, Calendar.DECEMBER, 31, 0, 0, 0);
        Date date2 = calendar2.getTime();

        List<String> ret1 = new ArrayList<>();
        List<String> ret2 = new ArrayList<>();

        Thread t1 = new Thread(() -> {
            for(int j =0; j< cnt; j++) {
                String s = sdf.format(date1);
                String piece = s.substring(5,7);
                String value = String.format( "1st SimpleDateFormat  %d : %s : %s -> %s", j , Objects.equals(piece, "03") ? "True" :"False", piece, s);
                ret1.add(value);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i =0; i < cnt; i++) {
                String s = sdf.format(date2);
                String piece = s.substring(5,7);
                String value = String.format( "2nd SimpleDateFormat  %d : %s : %s -> %s" , i , Objects.equals(piece, "12") ? "True" :"False", piece, s);
                ret2.add(value);
            }
        });

        // 開始
        t1.start();
        t2.start();

        // 終了待ち
        try {
            t1.join();
            t2.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        // 結果
        ret1.stream().forEach(System.out::println);
        ret2.stream().forEach(System.out::println);

    }

}
