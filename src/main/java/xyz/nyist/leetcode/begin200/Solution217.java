package xyz.nyist.leetcode.begin200;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/12/19 16:03
 * @Description:
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
