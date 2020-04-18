package practice.basicfeature;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Calendar.*;

public class Main {
    public static void main(String []args) {
        System.out.println("test");

        List<String> l = new ArrayList<>();
        l.add("=aaa=");
        l.add("=bbb=");
        l.add("=ccc=");
        Main m = new Main();
        Set<String> s = new HashSet<String>(l);
        m.outer(s);
        m.list();
        m.date();

    }

    public void outer(Set<String> list) {
        System.out.println(list.toString());
    }

    public void list() {
//        Long[] scheduleIdList = new Long[]{1l , 200l, 100l, null, 140l, 300l, 170l, 100l, null};
        Long[] scheduleIdList = new Long[]{null, null,  null};
        Set<Long> s2 = new HashSet<Long>(Arrays.stream(scheduleIdList).filter(id -> id != null).collect(Collectors.toList()));

        System.out.println(s2);
    }

    public void map() {
        Map<Long, Integer> map = new HashMap<>();
    }

    public void date () {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.WEEK_OF_MONTH));
        System.out.println(c.get(HOUR_OF_DAY));
        System.out.println(c.get(Calendar.HOUR_OF_DAY));
    }
}
