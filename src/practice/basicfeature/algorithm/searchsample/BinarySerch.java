package practice.basicfeature.algorithm.searchsample;

import java.util.HashSet;
import java.util.Set;

public class BinarySerch {
//    public T Search(T) {
//
//    }
    public void execute() {
        Set<String> s = new HashSet<>();
        s.add("A");
        s.add("B");
        s.add("C");
        // 重複値はスルーされる。
        s.add("A");
        System.out.println(s);
    }
}
