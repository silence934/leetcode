package xyz.nyist.leetcode.begin200;

import java.util.Random;

/**
 * @Author: silence
 * @Description:
 */
public class Solution215 {


    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int p;
        int left = -1, right;
        int limitL = 0, limitR = nums.length - 1;

        int index = nums.length - k;
        while (left != index) {
            p = left = limitL;
            right = limitR;
            int i = random.nextInt(right - left + 1) + left;
            int t = nums[i];
            nums[i] = nums[left];
            nums[left] = t;

            int w = nums[p];
            while (left < right) {
                while (left < right && w <= nums[right]) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && w >= nums[left]) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[right] = w;

            if (right > index) {
                limitR = right - 1;
            } else {
                limitL = right + 1;
            }
        }


        return nums[left];
    }

    public static void main(String[] args) {
        Solution215 solution209 = new Solution215();

        System.out.println(solution209.findKthLargest(new int[]{1}, 1));
    }

}
