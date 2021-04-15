package xyz.nyist.sort;

import java.util.Arrays;

/**
 * @Author: silence
 * @Description: 快速排序
 * @Date:Create：in 2020/7/3 11:46
 */
public class Quicksort {


    private static void test(int[] nums, int low, int high) {


        int t = 9;
        int[] a = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        int h = high, l = low;
        if (low >= high) {
            return;
        }
        int k = nums[low];
        while (low != high) {
            while (nums[high] > k && low != high) {
                high--;
            }
            nums[low] = nums[high];
            while (nums[low] < k && low != high) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = k;
        test(nums, low + 1, h);
        test(nums, l, low - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[10000];
        for (int i = 0; i < 10000; i++) {
            nums[i] = 10000 - i;
        }
        int[] nums1 = Arrays.copyOf(nums, 10000);
        int[] nums2 = Arrays.copyOf(nums, 10000);

        long start = System.currentTimeMillis();
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(System.currentTimeMillis() - start);


        start = System.currentTimeMillis();
        test(nums2, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums2));
        System.out.println(System.currentTimeMillis() - start);

    }


}
