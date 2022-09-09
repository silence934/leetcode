package xyz.nyist.leetcode.begin200;

/**
 * @author: silence
 * @Date: 2021/7/23 16:47
 * @Description:
 */
public class Solution312 {

    public int maxCoins1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = -1;
        for (int i = 0; i < nums.length; i++) {

            int a = (i == 0 ? 1 : nums[i - 1]) * nums[i] * (i == nums.length - 1 ? 1 : nums[i + 1]);
            int[] ints = new int[nums.length - 1];

            for (int j = 0, k = 0; j < nums.length; j++) {
                if (j != i) {
                    ints[k++] = nums[j];
                }
            }

            max = Math.max(max, maxCoins1(ints) + a);
        }

        return max;
    }


    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];

        for (int i = nums.length - 1; i > -1; i--) {
            for (int j = i; j < nums.length; j++) {
                if (i == j) {
                    dp[i][j] = nums[i] * (i == 0 ? 1 : nums[i - 1]) * (i == nums.length - 1 ? 1 : nums[i + 1]);
                } else {
                    for (int k = i; k <= j; k++) {
                        int t = nums[k] * (i == 0 ? 1 : nums[i - 1]) * (j == nums.length - 1 ? 1 : nums[j + 1]);
                        int left = i == k ? 0 : dp[i][k - 1];
                        int right = j == k ? 0 : dp[k + 1][j];
                        dp[i][j] = Math.max(dp[i][j], left + t + right);
                    }
                }
            }
        }

        return dp[0][nums.length - 1];
    }


}
