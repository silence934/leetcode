package xyz.nyist.leetcode.begin200;

/**
 * @Author : fucong
 * @Date: 2020-09-06 12:44
 * @Description :
 */
public class Solution213 {
    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        System.out.println(solution213.rob(new int[]{1}));
        System.out.println(solution213.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution213.rob1(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2),
                rob(nums, 1, nums.length - 1));
    }

    public int rob(int[] nums, int start, int end) {
        int m = 0, n = 0, j = 0;
        for (int i = start; i <= end; i++) {
            j = Math.max(n, m + nums[i]);
            m = n;
            n = j;
        }
        return j;
    }


    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1] + nums[i], dp[0][i - 1]);
        }

        return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
    }
}
