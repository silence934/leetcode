package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/1 19:10
 * @Description:
 */
public class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {

        int ans = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int l = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (l < min) {
                    ans = i;
                    min = l;
                }
            }
        }

        return ans;
    }
}
