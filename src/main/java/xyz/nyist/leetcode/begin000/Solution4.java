package xyz.nyist.leetcode.begin000;

/**
 * @Author: silence
 * @Description: 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/12 14:42
 */

public class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] rs = new int[nums1.length + nums2.length];
        int m = 0, n = 0;
        for (int i = 0; i < rs.length; i++) {
            if (m == nums1.length) {
                rs[i] = nums2[n];
                n++;
            } else if (n == nums2.length) {
                rs[i] = nums1[m];
                m++;
            } else if (nums1[m] < nums2[n]) {
                rs[i] = nums1[m];
                m++;
            } else {
                rs[i] = nums2[n];
                n++;
            }
        }
        if (rs.length % 2 == 1) {
            return rs[rs.length / 2];
        } else {
            return (rs[rs.length / 2] + rs[rs.length / 2 - 1]) / 2.0;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }
}
