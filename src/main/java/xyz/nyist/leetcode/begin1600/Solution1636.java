package xyz.nyist.leetcode.begin1600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/9/20 18:23
 * @Description:
 */
public class Solution1636 {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (Integer integer : nums) {
            list.add(integer);
            map.put(integer, map.getOrDefault(integer, 0) + 1);
        }


        list.sort((a, b) -> {
            if (map.get(a) > map.get(b)) {
                return 1;
            } else if (map.get(a) < map.get(b)) {
                return -1;
            } else {
                return b - a;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return nums;
    }

}
