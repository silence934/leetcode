package xyz.nyist.leetcode.begin000;

import java.util.LinkedHashMap;

/**
 * @author: fucong
 * @Date: 2021/6/30 16:26
 * @Description:
 */
public class Solution146 {

    private int capacity;
    private LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public Solution146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Integer i = cache.get(key);
        cache.remove(key);
        cache.put(key, i);
        return i;
    }

    public void put(int key, int value) {

        cache.remove(key);

        if (cache.size() == capacity) {
            Integer r = cache.keySet().iterator().next();
            cache.remove(r);
        }
        cache.put(key, value);

    }

}
