package xyz.nyist.leetcode.begin200;

import java.util.*;

/**
 * @author: fucong
 * @Date: 2021/6/30 18:55
 * @Description:
 */
public class Solution380 {

    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();


    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index == null) {
            return false;
        }
        if (index == list.size() - 1) {
            list.remove(index);
        } else {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            list.remove(list.size() - 1);
            map.put(last, index);
        }
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
