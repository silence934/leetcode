package xyz.nyist.leetcode.begin2000;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/22 21:35
 * @Description:
 */
public class Solution2279 {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        for (int i = 0; i < capacity.length; i++) {
            capacity[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(capacity);

        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] > additionalRocks) {
                return i;
            }
            additionalRocks -= capacity[i];
        }

        return capacity.length;
    }


}
