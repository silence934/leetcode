package xyz.nyist.leetcode.to400;

import java.util.Arrays;

/**
 * @Author: silence
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/14 18:32
 */
public class Solution322 {


    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        else if (amount < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub != -1) {
                min = Math.min(min, sub + 1);
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

    public static void main(String[] args) {
        Solution322 solution322 = new Solution322();
        System.out.println(solution322.coinChange1(new int[]{1, 2, 5}, 11));
    }

    int min = Integer.MAX_VALUE;

    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChange(coins.length - 1, coins, amount, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void coinChange(int k, int[] coins, int amount, int count) {
        if (amount == 0) {
            min = Math.min(min, count);
            return;
        }
        else if (amount < 0 || k < 0) {
            return;
        }
        for (int i = amount / coins[k]; i > -1 && count + i < min; i--) {
            coinChange(k - 1, coins, amount - coins[k] * i, count + i);
        }
    }

}
