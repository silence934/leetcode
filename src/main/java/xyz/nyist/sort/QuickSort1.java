package xyz.nyist.sort;

import java.util.Arrays;

/**
 * @author: fucong
 * @Date: 2022/3/11 17:10
 * @Description:
 */
public class QuickSort1 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 3, 5, 2, 7, 4, 6, 90, 3, 2, 6, 8, 3, 5, 6, 1, 7, 9};

        sort(nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums, int start, int end) {

        if (start >= end - 1) {
            return;
        }

        int left = start, right = end - 1;
        int t = nums[start];


        while (left < right) {
            while (left < right) {
                if (t > nums[right]) {
                    nums[left] = nums[right];
                    break;
                }
                right--;
            }

            while (left < right) {
                if (t < nums[left]) {
                    nums[right] = nums[left];
                    break;
                }
                left++;
            }
        }


        nums[left] = t;

        sort(nums, start, left);
        sort(nums, left + 1, end);
    }


}
