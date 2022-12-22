package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/12/19 13:38
 * @Description:
 */
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> ans = new ArrayList<>();

        Integer start = null;
        int end = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] > end) {
                if (start != null) {
                    ans.add(new int[]{start, end});
                }
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }

        if (start != null) {
            ans.add(new int[]{start, end});
        }


        return ans.toArray(new int[0][0]);
    }
}
