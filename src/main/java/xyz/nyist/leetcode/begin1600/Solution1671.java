package xyz.nyist.leetcode.begin1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1671 {
    public int minimumMountainRemovals(int[] nums) {
        int[] pre = dp(nums);
        nums = reversal(nums);
        int[] post = dp(nums);
        post = reversal(post);

        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(post));


        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] > 1 && post[i] > 1) {
                max = Math.max(max, pre[i] + post[i] - 1);
            }
        }

        return nums.length - max;
    }


    private int[] dp(int[] nums) {
        int[] dp = new int[nums.length];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = search(list, nums[i]);
            System.out.println(nums[i] + " " + index + " " + list);
            if (index == list.size()) {
                list.add(nums[i]);
                dp[i] = list.size();
            } else {
                list.set(index, nums[i]);
                dp[i] = index + 1;
            }
        }

        return dp;
    }

    private int search(List<Integer> list, int tag) {
        int l = 0, r = list.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) >= tag) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int[] reversal(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[nums.length - 1 - i] = nums[i];
        }
        return res;
    }
}
