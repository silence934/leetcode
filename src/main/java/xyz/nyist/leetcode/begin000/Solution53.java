package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2021/7/6 19:05
 * @Description:
 */
public class Solution53 {

    public int maxSubArray(int[] nums) {
        int t = nums[0];
        int max = t;
        for (int i = 1; i < nums.length; i++) {
            t = Math.max(t + nums[i], nums[i]);
            max = Math.max(max, t);
        }
        return max;
    }


}
