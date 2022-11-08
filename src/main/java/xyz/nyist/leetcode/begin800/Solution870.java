package xyz.nyist.leetcode.begin800;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/11/1 18:13
 * @Description:
 */
public class Solution870 {

    //[8,2,4,4,5,6,6,0,4,7]
    //[0,8,7,4,4,2,8,5,2,0]
    //[4,7,8,6,5,4,0,6,4,2]
    //[2, 0, 8, 5, 6, 4, 4, 6, 4, 7]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution870().advantageCount(
                new int[]{8, 2, 4, 4, 5, 6, 6, 0, 4, 7},
                new int[]{0, 8, 7, 4, 4, 2, 8, 5, 2, 0}
        )));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        if (nums1.length == 1) {
            return nums1;
        }


        Arrays.sort(nums1);
        Set<Integer> used = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = findAndUse(nums1, used, nums2[i]);
        }

        return nums2;
    }

    private int findAndUse(int[] nums, Set<Integer> used, int target) {
        int l = 0, r = nums.length;
        int mid;

        while (l < r) {
            mid = (l + r) >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (l == nums.length) {
            l = 0;
            while (used.contains(l)) {
                l++;
            }
            used.add(l);
            return nums[l];
        }

        while (l < nums.length && nums[l] <= target) {
            l++;
        }


        while (used.contains(l)) {
            l++;
        }
        if (l >= nums.length) {
            l = 0;
        }
        while (used.contains(l)) {
            l++;
        }
        used.add(l);
        return nums[l];
    }

}
