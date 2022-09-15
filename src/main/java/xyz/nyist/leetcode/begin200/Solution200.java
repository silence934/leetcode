package xyz.nyist.leetcode.begin200;

/**
 * @author: silence
 * @Date: 2022/9/15 12:16
 * @Description: ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 */
public class Solution200 {

    public static void main(String[] args) {
        Solution200 solution200 = new Solution200();
        char[][] grid = new char[][]{
                new char[]{'0', '1', '0'},
                new char[]{'1', '0', '1'},
                new char[]{'0', '1', '0'}
        };
        System.out.println(solution200.numIslands(grid));
    }


    public int numIslands(char[][] grid) {
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += find(grid, i, j);
            }
        }

        return ans;
    }

    private int find(char[][] grid, int x, int y) {
        if (x < 0 || x == grid.length) {
            return 0;
        }
        if (y < 0 || y == grid[0].length) {
            return 0;
        }
        if (grid[x][y] == '0' || grid[x][y] == '2') {
            return 0;
        }
        grid[x][y] = '2';
        find(grid, x + 1, y);
        find(grid, x - 1, y);
        find(grid, x, y + 1);
        find(grid, x, y - 1);

        return 1;
    }


}
