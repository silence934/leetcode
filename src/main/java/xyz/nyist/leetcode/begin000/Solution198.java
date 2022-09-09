package xyz.nyist.leetcode.begin000;

import java.util.Arrays;

/**
 * @Author : silence
 * @Date: 2020-08-15 18:52
 * @Description :
 */
public class Solution198 {

    int[] memo;

    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        System.out.println(solution198.rob3(new int[]{1, 2, 3, 1}));
        System.out.println(solution198.rob4(new int[]{1, 2, 3, 1}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(Math.max(nums[i] + dp[i - 2], dp[i - 1]), nums[i] + dp[i - 2]);
        }
        return Math.max(dp[length - 1], dp[length - 2]);
    }

    public int rob2(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return test(0, nums);
    }

    public int test(int start, int[] nums) {
        if (start >= nums.length) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(nums[start] + test(start + 2, nums), test(start + 1, nums));
        memo[start] = res;
        return res;
    }

    public int rob3(int[] nums) {
        int m = 0, n = 0, j = 0;
        for (int num : nums) {
            j = Math.max(m + num, n);
            m = n;
            n = j;
        }
        return j;
    }

    public int rob4(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = Math.max(dp[0][i - 1] + nums[i], dp[0][i - 1]);
        }

        return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
    }

}
