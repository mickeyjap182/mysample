package practice.basicfeature.novice.threading;

import java.util.concurrent.ConcurrentHashMap;

public class ItemsConcurrently {
    /**
     * TODO: code : key のマップを使用して非同期で更新を試みる
     * https://docs.oracle.com/javase/jp/8/docs/api/java/util/concurrent/ConcurrentHashMap.html
     * */
    public ConcurrentHashMap<String, Item> map = new ConcurrentHashMap<String, Item>();
}
