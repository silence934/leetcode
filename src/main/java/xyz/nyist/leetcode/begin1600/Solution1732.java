package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/19 22:21
 * @Description:
 */
public class Solution1732 {
    public int largestAltitude(int[] gain) {
        int max = 0;

        int pre = 0;
        for (int j : gain) {
            pre = pre + j;
            max = Math.max(max, pre);
        }
        
        return max;
    }
}
