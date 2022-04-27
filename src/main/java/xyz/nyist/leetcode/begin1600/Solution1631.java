package xyz.nyist.leetcode.begin1600;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: fucong
 * @Date: 2022/4/27 16:42
 * @Description:
 */
public class Solution1631 {

    public static void main(String[] args) {
        Solution1631 solution1631 = new Solution1631();
        System.out.println(solution1631.minimumEffortPath(new int[][]{
                new int[]{1, 2, 2},
                new int[]{3, 8, 2},
                new int[]{5, 3, 5}
        }));
    }

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
        }
        map[0][0] = 0;
        PriorityQueue<int[]> list = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
        list.add(new int[]{0, 0, 0});
        while (!list.isEmpty()) {
            int[] last = list.poll();
            int x = last[0];
            int y = last[1];
            int d = last[2];

            if (x == m - 1 && y == n - 1) {
                return d;
            }
            if (map[x][y] < d) {
                continue;
            }
            map[x][y] = d;
            int t;
            if (x != 0 && map[x - 1][y] > (t = Math.max(Math.abs(heights[x][y] - heights[x - 1][y]), d))) {
                list.add(new int[]{x - 1, y, t});
            }
            if (x != m - 1 && map[x + 1][y] > (t = Math.max(Math.abs(heights[x][y] - heights[x + 1][y]), d))) {
                list.add(new int[]{x + 1, y, t});
            }
            if (y != 0 && map[x][y - 1] > (t = Math.max(Math.abs(heights[x][y] - heights[x][y - 1]), d))) {
                list.add(new int[]{x, y - 1, t});
            }
            if (y != n - 1 && map[x][y + 1] > (t = Math.max(Math.abs(heights[x][y] - heights[x][y + 1]), d))) {
                list.add(new int[]{x, y + 1, t});
            }

        }

        return map[m - 1][n - 1];
    }

}
