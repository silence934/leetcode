package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/9/14 16:07
 * @Description:
 */
public class Solution1619 {

    public double trimMean(int[] arr) {
        int k = arr.length / 20;
        Arrays.sort(arr);
        int sum = 0;
        for (int i = k; i < arr.length - k; i++) {
            sum += arr[i];
        }

        return ((double) sum) / (arr.length - k - k);
    }

}
