package xyz.nyist.leetcode.begin800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/4/24 14:19
 * @Description:
 */
public class Solution886 {

    public static void main(String[] args) {
        Solution886 solution886 = new Solution886();
        System.out.println(solution886.possibleBipartition(4, new int[][]{
                new int[]{1, 2},
                new int[]{1, 3},
                new int[]{2, 4},
        }));
    }


    private boolean[] used;

    private boolean[] color;

    private List<Integer>[] map;

    public boolean possibleBipartition(int n, int[][] dislikes) {
        used = new boolean[n + 1];
        color = new boolean[n + 1];
        map = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            map[dislike[0]].add(dislike[1]);
            map[dislike[1]].add(dislike[0]);
        }

        for (int i = 0; i <= n; i++) {
            if (!used[i]) {
                used[i] = true;
                color[i] = true;
                if (!possibleBipartition(i)) {
                    return false;
                }
            }
        }

        return true;
    }


    private boolean possibleBipartition(int p) {

        for (Integer integer : map[p]) {
            if (used[integer]) {
                if (color[integer] == color[p]) {
                    return false;
                }
            } else {
                used[integer] = true;
                color[integer] = !color[p];
                if (!possibleBipartition(integer)) {
                    return false;
                }
            }
        }

        return true;
    }

}
