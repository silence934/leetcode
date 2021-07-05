package xyz.nyist.leetcode.begin200;

import java.util.Arrays;

/**
 * @author: fucong
 * @Date: 2021/7/5 10:25
 * @Description:
 */
public class Solution300 {

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
        System.out.println(solution300.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
    }

    public int lengthOfLIS(int[] nums) {

        int res = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
