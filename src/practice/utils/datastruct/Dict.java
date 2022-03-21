package practice.utils.datastruct;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Dict {
    private final Map<String, String> dict;
    public Dict() {
        dict = new ConcurrentHashMap<>();
    }
    public void addOrPut(String key, String value) {
        dict.put(key , value);
    }
    public void remove(String key) {
        dict.remove(key);
    }

    public String get(String key) {
        return dict.get(key);
    }

    public Set<Map.Entry<String, String>> entrySet(String key) {
        return dict.entrySet();
    }
    public Map<String, String> getALL() {
        return dict;
    }
}
