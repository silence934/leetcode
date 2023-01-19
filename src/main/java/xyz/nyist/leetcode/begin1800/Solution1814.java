package xyz.nyist.leetcode.begin1800;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1814 {
    public int countNicePairs(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            int key = nums[i] - rev(nums[i]);
            map.compute(key, (integer, integers) -> {
                if (integers == null) {
                    integers = new ArrayList<>();
                }
                integers.add(finalI);
                return integers;
            });
            nums[i] = key;
        }

        int ans = 0;

        int mod = 1000000007;


        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            ans += (list.size() - 1 - search(list, i) % mod);
            ans = ans % mod;
        }

        return ans;
    }


    private int search(List<Integer> list, int target) {
        int low = 0, high = list.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }


    private int rev(int t) {
        return Integer.parseInt(new StringBuilder("" + t).reverse().toString());
    }
}
