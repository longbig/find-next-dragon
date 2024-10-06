package algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yuyunlong
 * @date 2024/10/5 17:22
 * @description 继承JDK的LinkedHashMap来实现LRU缓存
 */
public class LRUCacheForJDK extends LinkedHashMap<Integer, Integer> {

    private int capacity;

    public LRUCacheForJDK(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }


}
