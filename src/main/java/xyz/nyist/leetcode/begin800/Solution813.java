package xyz.nyist.leetcode.begin800;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/28 17:22
 * @Description:
 */
public class Solution813 {
    public double largestSumOfAverages(int[] nums, int k) {
        if (k >= nums.length) {
            return Arrays.stream(nums).sum();
        }
        double[] preSum = new double[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }


        double[][] dp = new double[nums.length][k];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    dp[i][j] = preSum[i] / (i + 1);
                } else if (j > i) {
                    dp[i][j] = preSum[i];
                } else {
                    for (int x = 0; x < i; x++) {
                        dp[i][j] = Math.max(dp[i][j], dp[x][j - 1] + (preSum[i] - preSum[x]) / (i - x));
                    }
                }
            }
        }


        return dp[nums.length - 1][k - 1];
    }
}
