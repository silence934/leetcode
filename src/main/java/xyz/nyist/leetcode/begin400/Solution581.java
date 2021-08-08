package xyz.nyist.leetcode.begin400;

/**
 * @author: fucong
 * @Date: 2021/8/4 10:02
 * @Description:
 */
public class Solution581 {

    public int findUnsortedSubarray(int[] nums) {


        int r = -1, max = Integer.MIN_VALUE;
        int l = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            } else {
                r = i;
            }
        }

        for (int i = nums.length - 1; i > -1; i--) {
            if (nums[i] <= min) {
                min = nums[i];
            } else {
                l = i;
            }
        }

        return r == -1 ? 0 : r - l + 1;
    }

}
