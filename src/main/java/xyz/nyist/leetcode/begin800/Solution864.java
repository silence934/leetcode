package xyz.nyist.leetcode.begin800;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/11/10 20:53
 * @Description:
 */
public class Solution864 {

    public static void main(String[] args) {
        //System.out.println('B' - 'A');
        System.out.println(new Solution864().shortestPathAllKeys(new String[]{
              
                "##.....a..",
                "...C.#...#",
                "A...#.e.E#",
                "c.@..#...d",
                "#..#.#.b.#"
        }));
    }

    public int shortestPathAllKeys(String[] grid) {

        int x = -1, y = -1, keyNumbers = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if (Character.isLowerCase(c)) {
                    keyNumbers = Math.max(keyNumbers, c - 'a');
                } else if (c == '@') {
                    x = i;
                    y = j;
                }
            }
        }

        keyNumbers = (int) Math.pow(2, keyNumbers + 1) - 1;
        byte[][][] map = new byte[grid.length][grid[0].length()][keyNumbers + 1];
        for (byte[][] ints : map) {
            for (byte[] anInt : ints) {
                Arrays.fill(anInt, (byte) 0);
            }
        }


        int ans = dfs(map, grid, x, y, 0, keyNumbers, 0, Integer.MAX_VALUE);

        return ans == Integer.MAX_VALUE ? -1 : ans - 1;
    }


    private int dfs(byte[][][] map, String[] grid, int x, int y, int keys, int keyNumbers, int step, int min) {
        if (keys == keyNumbers) {
            return step;
        }
        if (x < 0 || x >= map.length || y < 0 || y >= map[0].length || map[x][y][keys] == 1 || step >= min) {
            return Integer.MAX_VALUE;
        }

        char c = grid[x].charAt(y);

        if (c == '-' || c == '#') {
            return Integer.MAX_VALUE;
        }


        if (Character.isUpperCase(c)) {
            int t = c - 'A';
            if ((keys >> t & 1) == 1) {
                map[x][y][keys] = 1;
                int dfs1 = dfs(map, grid, x + 1, y, keys, keyNumbers, step + 1, min);
                min = Math.min(min, dfs1);
                int dfs2 = dfs(map, grid, x - 1, y, keys, keyNumbers, step + 1, min);
                min = Math.min(min, dfs2);
                int dfs3 = dfs(map, grid, x, y + 1, keys, keyNumbers, step + 1, min);
                min = Math.min(min, dfs3);
                int dfs4 = dfs(map, grid, x, y - 1, keys, keyNumbers, step + 1, min);
                map[x][y][keys] = 0;
                return Math.min(Math.min(dfs1, dfs2), Math.min(dfs3, dfs4));

            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (Character.isLowerCase(c)) {
            int t = (int) Math.pow(2, c - 'a');
            keys = (keys | t);
        }
        map[x][y][keys] = 1;

        int dfs1 = dfs(map, grid, x + 1, y, keys, keyNumbers, step + 1, min);
        min = Math.min(min, dfs1);
        int dfs2 = dfs(map, grid, x - 1, y, keys, keyNumbers, step + 1, min);
        min = Math.min(min, dfs2);
        int dfs3 = dfs(map, grid, x, y + 1, keys, keyNumbers, step + 1, min);
        min = Math.min(min, dfs3);
        int dfs4 = dfs(map, grid, x, y - 1, keys, keyNumbers, step + 1, min);
        map[x][y][keys] = 0;


        return Math.min(Math.min(dfs1, dfs2), Math.min(dfs3, dfs4));
    }

}
