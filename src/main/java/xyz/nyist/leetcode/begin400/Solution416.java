package xyz.nyist.leetcode.begin400;

import java.util.Arrays;

/**
 * @Author : fucong
 * @Date: 2020-09-20 20:12
 * @Description :给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution416 {
    public static void main(String[] args) {
        Solution416 solution416 = new Solution416();
        System.out.println(solution416.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(solution416.canPartition1(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[sum];
    }

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int[][] dp = new int[nums.length + 1][sum + 1];


        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (nums[i - 1] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(nums[i - 1] + dp[i - 1][j - nums[i - 1]], dp[i - 1][j]);
                    }
                }
            }
        }

        return dp[nums.length][sum] == sum;
    }

}
