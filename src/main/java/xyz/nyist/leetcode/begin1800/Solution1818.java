package xyz.nyist.leetcode.begin1800;

import java.util.Arrays;

/**
 * @author: fucong
 * @Date: 2021/7/14 14:49
 * @Description:
 */
public class Solution1818 {


    public static void main(String[] args) {
        new Solution1818().minAbsoluteSumDiff(new int[]{8, 9, 2}, new int[]{7, 7, 3});
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {

        int[] copy = new int[nums1.length];
        System.arraycopy(nums1, 0, copy, 0, nums1.length);
        Arrays.sort(copy);

        long sum = 0;

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums1.length; i++) {
            int dis = Math.abs(nums1[i] - nums2[i]);
            sum += dis;
            max = Math.max(max, dis - find(copy, nums2[i]));
        }

        return (int) ((sum - max) % ((long) Math.pow(10, 9) + 7));
    }


    private int find(int[] copy, int target) {

        int l = 0, r = copy.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (copy[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        int m = Integer.MAX_VALUE, n = Integer.MAX_VALUE;
        if (l > 0) {
            m = Math.abs(target - copy[l - 1]);
        }
        if (l < copy.length - 1) {
            n = Math.abs(target - copy[l + 1]);
        }

        return Math.min(Math.abs(target - copy[l]), Math.min(m, n));
    }


}
