package xyz.nyist.leetcode.begin000;

import java.util.Arrays;

/**
 * @author: fucong
 * @Date: 2021/7/14 12:44
 * @Description:
 */
public class Solution34 {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int index = search(nums, target, 0, nums.length);
        if (index == -1) {
            return new int[]{-1, -1};
        }

        int left = index - 1, right = index + 1;

        while (left > -1 && nums[left] == nums[index]) {
            left--;
        }

        while (right < nums.length && nums[right] == nums[index]) {
            right++;
        }


        return new int[]{left + 1, right - 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{1, 1}, 3)));
    }

    private int search(int[] nums, int target, int start, int end) {
        if (start >= end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] < target) {
            return search(nums, target, mid + 1, end);
        } else if (nums[mid] > target) {
            return search(nums, target, start, mid);
        } else if (nums[mid] == target) {
            return mid;
        } else {
            return -1;
        }
    }

}
