package xyz.nyist.leetcode.begin600;

/**
 * @author: fucong
 * @Date: 2022/4/22 19:59
 * @Description:
 */
public class Solution785 {

    private boolean[] used;

    private boolean[] color;

    private int[][] graph;


    public static void main(String[] args) {
        Solution785 solution785 = new Solution785();
        System.out.println(solution785.isBipartite(new int[][]{
                new int[]{2, 3, 5, 6, 7, 8, 9},
                new int[]{2, 3, 4, 5, 6, 7, 8, 9},
                new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9},
                new int[]{0, 1, 2, 4, 5, 6, 7, 8, 9},
                new int[]{1, 2, 3, 6, 9},
                new int[]{0, 1, 2, 3, 7, 8, 9},
                new int[]{0, 1, 2, 3, 4, 7, 8, 9},
                new int[]{0, 1, 2, 3, 5, 6, 8, 9},
                new int[]{0, 1, 2, 3, 5, 6, 7},
                new int[]{0, 1, 2, 3, 4, 5, 6, 7},
        }));
    }

    public boolean isBipartite(int[][] graph) {

        used = new boolean[graph.length];
        color = new boolean[graph.length];
        this.graph = graph;

        for (int i = 0; i < graph.length; i++) {
            if (!used[i]) {
                used[i] = true;
                color[i] = false;
                if (traverse(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean traverse(int p) {


        for (int i : graph[p]) {
            if (used[i]) {
                if (color[i] == color[p]) {
                    return true;
                }
            } else {
                color[i] = !color[p];
                used[i] = true;
                if (traverse(i)) {
                    return true;
                }
            }
        }

        return false;
    }


}
