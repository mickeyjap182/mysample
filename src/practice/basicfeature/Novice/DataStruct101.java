package practice.basicfeature.Novice;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Calendar.HOUR_OF_DAY;

public class DataStruct101 {
    public boolean run() {
        System.out.println("test");

        DataStruct101 m = new DataStruct101();
        m.set();
        m.list();
        m.date();
        return true;
    }

    public void set() {
        List<String> list = new ArrayList<>(Arrays.asList("aaa","bbb","ccc"));

        Set<String> set = new HashSet<>(list);
        System.out.println(set.toString());
        Long[] nullList = new Long[]{null, null, null};
        Set<Long> s2 = new HashSet<Long>(Arrays.stream(nullList).filter(id -> id != null).collect(Collectors.toList()));
        System.out.println(set.toString());
    }
    public void list() {
//        Long[] scheduleIdList = new Long[]{1l , 200l, 100l, null, 140l, 300l, 170l, 100l, null};
        List<String> list = new ArrayList<>(Arrays.asList("aaa","bbb","ccc"));

        System.out.println(list);

        List<String> list2 = new ArrayList<>();
        list2.add("ddd");

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
