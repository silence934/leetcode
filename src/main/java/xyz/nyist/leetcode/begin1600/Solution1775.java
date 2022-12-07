package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/12/7 18:30
 * @Description:
 */
public class Solution1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length) {
            return -1;
        }


        int[] map1 = new int[7];
        int[] map2 = new int[7];

        int diff = 0;

        for (int i : nums1) {
            diff += i;
            map1[i]++;
        }

        for (int i : nums2) {
            diff -= i;
            map2[i]++;
        }

        int[] k = new int[6];
        if (diff == 0) {
            return 0;
        } else if (diff > 0) {
            //map1>map2

            for (int i = 2; i < 7; i++) {
                k[i - 1] += map1[i];
            }

            for (int i = 1; i < 6; i++) {
                k[6 - i] += map2[i];
            }

        } else {
            diff = -diff;

            for (int i = 2; i < 7; i++) {
                k[i - 1] += map2[i];
            }

            for (int i = 1; i < 6; i++) {
                k[6 - i] += map1[i];
            }
        }

        int ans = 0;

        System.out.println(Arrays.toString(k));
        for (int i = 5; i > 0; i--) {
            if (diff <= 0) {
                break;
            }
            ans = ans + Math.min(k[i], (diff + i - 1) / i);
            diff -= (Math.min(k[i], (diff + i - 1) / i) * i);
        }
        return ans;
    }
}
