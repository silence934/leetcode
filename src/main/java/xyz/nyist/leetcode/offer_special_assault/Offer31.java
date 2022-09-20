package xyz.nyist.leetcode.offer_special_assault;

import java.util.LinkedHashMap;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer31 {


    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    int capacity;

    public Offer31(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer integer = map.get(key);
        if (integer == null) {
            return -1;
        }
        map.remove(key);
        map.put(key, integer);
        return integer;
    }

    public void put(int key, int value) {
        map.remove(key);
        if (map.size() == capacity) {
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }

}
