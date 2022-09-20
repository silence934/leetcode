package xyz.nyist.leetcode.begin400;

import java.util.Arrays;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Solution539 {

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() >= 60 * 24) {
            return 0;
        }
        int[][] arr = new int[timePoints.size()][2];

        for (int i = 0; i < arr.length; i++) {
            String s = timePoints.get(i);
            String[] split = s.split(":");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else if (b[0] > a[0]) {
                return -1;
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });

        System.out.println(Arrays.deepToString(arr));
        int min = computer(new int[]{0, 0}, arr[0]) + 1 + computer(arr[arr.length - 1], new int[]{23, 59});

        System.out.println(min);
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, computer(arr[i - 1], arr[i]));
        }


        return min;
    }

    private int computer(int[] time1, int[] time2) {
        return (time2[0] - time1[0]) * 60 + time2[1] - time1[1];
    }

}
