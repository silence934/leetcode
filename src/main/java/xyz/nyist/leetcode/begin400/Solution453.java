package xyz.nyist.leetcode.begin400;

/**
 * @author: silence
 * @Date: 2022/11/24 15:15
 * @Description:
 */
public class Solution453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        int ans = 0;
        for (int num : nums) {
            ans += (num - min);
        }
        return ans;
    }
}
