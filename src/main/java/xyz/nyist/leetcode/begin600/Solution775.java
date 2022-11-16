package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/11/16 20:58
 * @Description:
 */
public class Solution775 {
    public boolean isIdealPermutation(int[] nums) {
        int min = nums[nums.length - 1];

        for (int i = nums.length - 3; i > -1; i--) {
            if (nums[i] > min) {
                return false;
            }
            min = Math.min(min, nums[i + 1]);
        }

        return true;
    }
}
