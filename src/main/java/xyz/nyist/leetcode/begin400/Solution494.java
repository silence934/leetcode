package xyz.nyist.leetcode.begin400;

/**
 * @author: silence
 * @Date: 2021/7/11 19:00
 * @Description:
 */
public class Solution494 {

    public static void main(String[] args) {
        System.out.println(new Solution494().findTargetSumWays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (((target + sum) & 1) == 1) {
            return 0;
        }
        target = (target + sum) / 2;

        int[][] dp = new int[target + 1][nums.length + 1];

        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (nums[j - 1] <= i) {
                        dp[i][j] = dp[i - nums[j - 1]][j - 1] + dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        for (int i = 0; i < target + 1; i++) {
            for (int j = 0; j < nums.length + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


        return dp[target][nums.length];
    }

}
