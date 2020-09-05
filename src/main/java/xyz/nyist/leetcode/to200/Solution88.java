package xyz.nyist.leetcode.to200;

import java.util.Arrays;

/**
 * @Author: silence
 * @Description: 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * <p>
 *  
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/5 16:25
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int i = 0, j = 0, k = 0;
        while (k < m + n) {
            int t;
            if (i == m) {
                t = nums2[j++];
            }
            else if (j == n) {
                t = temp[i++];

            }
            else if (nums2[j] < temp[i]) {
                t = nums2[j++];
            }
            else {
                t = temp[i++];
            }
            nums1[k++] = t;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        solution88.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
