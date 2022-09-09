package xyz.nyist.leetcode.begin800;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/4/1 18:48
 * @Description:
 */
public class Solution954 {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort(Comparator.comparingInt(Math::abs));

        for (Integer k : list) {
            if (map.getOrDefault(k * 2, 0) < map.get(k)) {
                return false;
            }
            map.put(k * 2, map.getOrDefault(k * 2, 0) - map.get(k));
        }

        return true;
    }

}
