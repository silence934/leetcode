package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/12/19 13:47
 * @Description:
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> ans = new ArrayList<>();

        int[] target = new int[2];

        int indexStart = find(intervals, newInterval[0]);
        System.out.println(indexStart);

        for (int i = 0; i < indexStart; i++) {
            ans.add(intervals[i]);
        }
        if (indexStart > -1) {
            if (newInterval[0] > intervals[indexStart][1]) {
                ans.add(intervals[indexStart]);
                target[0] = newInterval[0];
            } else {
                target[0] = intervals[indexStart][0];
            }
        } else {
            target[0] = newInterval[0];
        }


        int indexEnd = find(intervals, newInterval[1]);
        //System.out.println(indexEnd);
        if (indexEnd < 0) {
            target[1] = newInterval[1];
        } else {
            target[1] = Math.max(newInterval[1], intervals[indexEnd][1]);
        }

        ans.add(target);


        for (int i = indexEnd + 1; i < intervals.length; i++) {
            ans.add(intervals[i]);
        }

        return ans.toArray(new int[0][0]);
    }

    private int find(int[][] intervals, int target) {
        if (target < intervals[0][0]) {
            return -1;
        }

        int l = 0, r = intervals.length - 1;

        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (intervals[mid][0] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return l - 1;
    }

}
