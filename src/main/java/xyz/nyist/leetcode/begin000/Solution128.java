package xyz.nyist.leetcode.begin000;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/11/22 22:47
 * @Description:
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }


        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int t = num + 1;
                while (set.contains(t)) {
                    t++;
                }
                ans = Math.max(ans, t - num);
            }
        }

        return ans;
    }
}
