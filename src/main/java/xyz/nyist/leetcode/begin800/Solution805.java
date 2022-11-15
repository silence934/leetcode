package xyz.nyist.leetcode.begin800;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/11/14 18:26
 * @Description:
 */
public class Solution805 {
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int n = nums.length, m = n >> 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * n - sum;
        }
        Set<Integer> l = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int total = 0;
            for (int j = 0; j < m; j++) {
                if (((i >> j) & 1) == 1) {
                    total += nums[j];
                }
            }
            if (total == 0) {
                return true;
            }
            l.add(total);
        }
        //System.out.println(l);
        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }

        for (int i = 1; i < (1 << (n - m)); i++) {
            int total = 0;
            for (int j = m; j < n; j++) {
                if (((i >> (j - m)) & 1) == 1) {
                    total += nums[j];
                }
            }
            if (total == 0 || (total != rsum && l.contains(-total))) {
                return true;
            }
        }


        return false;
    }

}
