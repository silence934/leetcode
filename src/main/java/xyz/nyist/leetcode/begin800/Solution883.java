package xyz.nyist.leetcode.begin800;

/**
 * @author: silence
 * @Date: 2022/4/26 10:51
 * @Description:
 */
public class Solution883 {

    public int projectionArea(int[][] grid) {
        int ans = 0;

        for (int[] value : grid) {
            int max = value[0];
            for (int j = 0; j < grid[0].length; j++) {
                if (value[j] != 0) {
                    ans += 1;
                }
                max = Math.max(max, value[j]);
            }
            ans += max;
        }


        for (int i = 0; i < grid[0].length; i++) {
            int max = grid[0][i];
            for (int[] ints : grid) {
                max = Math.max(max, ints[i]);
            }
            ans += max;
        }


        return ans;
    }

}
