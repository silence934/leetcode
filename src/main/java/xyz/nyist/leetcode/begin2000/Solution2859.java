package xyz.nyist.leetcode.begin2000;

import java.util.List;

public class Solution2859 {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            String s = Integer.toBinaryString(i);
            if (s.length() - s.replaceAll("1", "").length() == k) {
                ans += nums.get(i);
            }
        }

        return ans;
    }
}
