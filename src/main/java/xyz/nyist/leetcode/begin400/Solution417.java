package xyz.nyist.leetcode.begin400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/4/27 13:54
 * @Description:
 */
public class Solution417 {


    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] map1 = new boolean[heights.length][heights[0].length];
        boolean[][] map2 = new boolean[heights.length][heights[0].length];
        List<List<Integer>> ans1 = new ArrayList<>();
        List<List<Integer>> ans2 = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            is(i, 0, ans1, heights, map1);
            is(i, heights[0].length - 1, ans2, heights, map2);
        }
        for (int i = 0; i < heights[0].length; i++) {
            is(0, i, ans1, heights, map1);
            is(heights.length - 1, i, ans2, heights, map2);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (List<Integer> list : ans1) {
            if (ans2.contains(list)) {
                ans.add(list);
            }
        }

        return ans;
    }


    private void is(int i, int j, List<List<Integer>> ans, int[][] heights, boolean[][] map) {
        if (map[i][j]) {
            return;
        }
        map[i][j] = true;
        ans.add(Arrays.asList(i, j));
        if (i + 1 < heights.length && heights[i + 1][j] >= heights[i][j]) {
            is(i + 1, j, ans, heights, map);
        }
        if (i != 0 && heights[i - 1][j] >= heights[i][j]) {
            is(i - 1, j, ans, heights, map);
        }

        if (j + 1 < heights[0].length && heights[i][j + 1] >= heights[i][j]) {
            is(i, j + 1, ans, heights, map);
        }
        if (j != 0 && heights[i][j - 1] >= heights[i][j]) {
            is(i, j - 1, ans, heights, map);
        }

    }

}
