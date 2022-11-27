package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/27 16:51
 * @Description:
 */
public class Solution1752 {
    public boolean check(int[] nums) {
        boolean t = nums[0] < nums[nums.length - 1];


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (t) {
                    return false;
                }
                t = true;
            }
        }

        return true;
    }
}
