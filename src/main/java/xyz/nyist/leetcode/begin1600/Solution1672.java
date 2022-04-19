package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/4/14 20:28
 * @Description:
 */
public class Solution1672 {
    public int maximumWealth(int[][] accounts) {

        int max=0;

        for (int[] account : accounts) {
           int sum=0;
            for (int i : account) {
                sum+=i;
            }
            max=Math.max(sum,max);
        }

        return max;
    }
}
