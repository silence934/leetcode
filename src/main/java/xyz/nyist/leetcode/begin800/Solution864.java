package xyz.nyist.leetcode.begin800;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/11/10 15:30
 * @Description:
 */
public class Solution864 {

    public int shortestPathAllKeys(String[] grid) {

        int keyNumber = 0;

        int x = -1;
        int y = -1;

        char[][] map = new char[grid.length][grid[0].length()];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if (Character.isLowerCase(c)) {
                    keyNumber = Math.max(keyNumber, c - 'a');
                }
                if (c == '@') {
                    x = i;
                    y = j;
                }
            }
            map[i] = grid[i].toCharArray();
        }


        keyNumber++;


        Set<Character> keys = new HashSet<>();

        return dfs(keys, map, x, y, keyNumber, 0);
    }


    private int dfs(Set<Character> keys, char[][] map, int x, int y, int keyNumber, int step) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[x].length) {
            return Integer.MAX_VALUE;
        }
        if (keys.size() == keyNumber) {
            return step;
        }
        char c = map[x][y];

        if (c == '#' || c == '0') {
            return Integer.MAX_VALUE;
        }

        if (Character.isUpperCase(c)) {
            if (keys.contains(c)) {

            } else {
                return Integer.MAX_VALUE;
            }
        }

        if (Character.isLowerCase(c)) {
            keys.add(Character.toUpperCase(c));
        }

    }


}
