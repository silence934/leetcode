package xyz.nyist.leetcode.to200;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/15 11:12
 */
public class Solution96 {
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += (numTrees(i - 1) * numTrees(n - i));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution96 solution96 = new Solution96();
        System.out.println(solution96.numTrees(3));
    }
}
