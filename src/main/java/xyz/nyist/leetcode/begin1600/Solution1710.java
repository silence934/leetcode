package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/15 14:58
 * @Description:
 */
public class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int ans = 0;

        for (int[] boxType : boxTypes) {
            if (boxType[0] <= truckSize) {
                ans += (boxType[0] * boxType[1]);
                truckSize -= boxType[0];
            } else {
                ans += (truckSize * boxType[1]);
                break;
            }
        }

        return ans;
    }
}
