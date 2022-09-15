package xyz.nyist.leetcode.begin400;

/**
 * @author: silence
 * @Date: 2022/9/15 13:31
 * @Description: <a href="https://leetcode.cn/problems/number-of-islands/solution/dao-yu-lei-wen-ti-de-tong-yong-jie-fa-dfs-bian-li-/">岛屿问题</a>
 */
public class Solution463 {

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }


    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x == grid.length) {
            return 1;
        }
        if (y < 0 || y == grid[0].length) {
            return 1;
        }

        if (grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;

        return dfs(grid, x - 1, y) + dfs(grid, x, y - 1) + dfs(grid, x + 1, y) + dfs(grid, x, y + 1);
    }

}
