package xyz.nyist.leetcode.begin800;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: silence
 * @Date: 2022/9/16 22:57
 * @Description:
 */
public class Solution850 {

    public int rectangleArea(int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[0]));
        int ans = 0;


        int r1;
        int r2;
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];

        }

        return ans;
    }

}
