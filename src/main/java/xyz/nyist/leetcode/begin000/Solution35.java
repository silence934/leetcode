package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/11/30 21:34
 * @Description: 1 3 5 6
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return nums[l] < target ? l + 1 : l;
    }
}
