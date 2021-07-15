package practice.basicfeature.novice.functionally;

import java.util.*;

/**
 *
 * ? extends K などの書き方、予約クラスについて
 * thread lockについてのおさらい
 * @param <K>
 * @param <V>
 */
//public class DataHolder<K, V> extends LinkedHashMap<K, V> {
public class DataHolder<K, V>  {

    private Map<? extends K, ? extends V > map;
    private
    // @see https://www.geeksforgeeks.org/generics-in-java/
    DataHolder(K key, V value) {
//        map = new LinkedHashMap<key, value>();
//        map.put("key", "values");
    }

//    @Override
//    public String get(K key) {
//
//        return "";
//    }
}
