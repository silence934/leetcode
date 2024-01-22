package xyz.nyist.leetcode.begin400;

import java.util.HashMap;
import java.util.Map;

public class Solution410 {
    public static void main(String[] args) {
        System.out.println(new Solution410().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int k) {
        return splitArray(nums, 0, k, new HashMap<>());
    }

    private int splitArray(int[] nums, int index, int k, Map<String, Integer> map) {
        String key = index + "-" + k;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int sum = 0, res = Integer.MAX_VALUE;
        for (int i = index; i < nums.length - k + 1; i++) {
            while (i < nums.length - k && nums[i] == 0) {
                i++;
            }

            sum += nums[i];
            if (k > 1) {
                int t = splitArray(nums, i + 1, k - 1, map);
                res = Math.min(res, Math.max(sum, t));
            }
        }

        if (k == 1) {
            res = sum;
        }

        map.put(key, res);
        return res;
    }

}
