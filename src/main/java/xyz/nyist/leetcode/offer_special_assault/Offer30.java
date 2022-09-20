package xyz.nyist.leetcode.offer_special_assault;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer30 {

    List<Integer> list;

    Map<Integer, Integer> map;

    Random random;

    public Offer30() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        Integer index = map.get(val);
        map.remove(val);
        if (index != list.size() - 1) {
            list.set(index, list.get(list.size() - 1));
            map.put(list.get(index), index);
        }
        list.remove(list.size() - 1);

        System.out.println(map);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
