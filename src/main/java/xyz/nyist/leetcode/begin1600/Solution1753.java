package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/21 14:29
 * @Description:
 */
public class Solution1753 {
    public int maximumScore(int a, int b, int c) {
        int sum = a + b + c;
        int maxVal = Math.max(Math.max(a, b), c);
        return Math.min(sum - maxVal, sum / 2);
    }
}
