package xyz.nyist.leetcode.begin400;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author: fucong
 * @Date: 2021/6/30 16:57
 * @Description:
 */
public class Solution460 {


    public static void main(String[] args) {
        Solution460 solution460 = new Solution460(0);
        solution460.put(1, 1);
        System.out.println(solution460.get(0));
    }

    private int capacity;
    private int minFreq = 0;

    private Map<Integer, Integer> map1 = new HashMap<>();
    private Map<Integer, Integer> map2 = new HashMap<>();
    private Map<Integer, LinkedHashSet<Integer>> map3 = new HashMap<>();

    public Solution460(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map1.containsKey(key)) {
            return -1;
        }
        test(key);

        return map1.get(key);
    }

    public void put(int key, int value) {
        if (map1.size() == capacity && !map1.containsKey(key)) {
            if (map3.containsKey(minFreq)) {
                LinkedHashSet<Integer> integers = map3.get(minFreq);
                Integer removeKey = integers.iterator().next();
                integers.remove(removeKey);

                map2.remove(removeKey);
                map1.remove(removeKey);
                test(key);
                map1.put(key, value);
            }

        } else {
            test(key);
            map1.put(key, value);
        }

    }


    private void test(Integer key) {
        Integer index = map2.getOrDefault(key, 0);
        map2.put(key, index + 1);
        if (index == 0) {
            minFreq = 1;
        }

        if (map3.containsKey(index)) {
            map3.get(index).remove(key);
            if (minFreq == index && map3.get(index).size() == 0) {
                minFreq++;
            }
        }


        LinkedHashSet<Integer> hashSet = map3.get(index + 1);
        if (hashSet == null) {
            LinkedHashSet<Integer> set = new LinkedHashSet<>();
            set.add(key);
            map3.put(index + 1, set);
        } else {
            hashSet.add(key);
        }
    }

}
