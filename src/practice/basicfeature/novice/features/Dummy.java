package practice.basicfeature.novice.features;

import practice.basicfeature.novice.features.lib.TimeBoard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
