package xyz.nyist.leetcode.begin1800;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/12/29 19:18
 * @Description:
 */
public class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();
        Set<Integer> ans = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        for (int i : nums3) {
            set3.add(i);
            if (set1.contains(i) || set2.contains(i)) {
                ans.add(i);
            }
        }

        for (int i : nums1) {
            if (set2.contains(i) || set3.contains(i)) {
                ans.add(i);
            }
        }

        for (int i : nums2) {
            if (set1.contains(i) || set3.contains(i)) {
                ans.add(i);
            }
        }


        return new ArrayList<>(ans);
    }
}
