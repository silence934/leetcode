package xyz.nyist.leetcode.begin800;

/**
 * @author: fucong
 * @Date: 2022/4/28 14:18
 * @Description:
 */
public class Solution905 {

    public int[] sortArrayByParity(int[] nums) {

        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right && (nums[left] & 1) != 1) {
                left++;
            }

            while (left < right && (nums[right] & 1) != 0) {
                right--;
            }

            int t = nums[left];
            nums[left] = nums[right];
            nums[right] = t;

        }

        return nums;
    }

}
