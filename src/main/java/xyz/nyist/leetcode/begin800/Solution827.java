package xyz.nyist.leetcode.begin800;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/9/15 13:38
 * @Description:
 */
public class Solution827 {

    public int largestIsland(int[][] grid) {
        Node[][] nodes = new Node[grid.length][grid[0].length];
        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Node node = new Node(i + "" + j, 0);
                    dfs(nodes, node, grid, i, j);
                    ans = Math.max(node.area, ans);
                }
            }
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    Map<String, Node> map = new HashMap<>();
                    if (i > 0 && nodes[i - 1][j] != null) {
                        map.put(nodes[i - 1][j].key, nodes[i - 1][j]);
                    }
                    if (i != grid.length - 1 && nodes[i + 1][j] != null) {
                        map.put(nodes[i + 1][j].key, nodes[i + 1][j]);
                    }
                    if (j != 0 && nodes[i][j - 1] != null) {
                        map.put(nodes[i][j - 1].key, nodes[i][j - 1]);
                    }
                    if (j != grid[0].length - 1 && nodes[i][j + 1] != null) {
                        map.put(nodes[i][j + 1].key, nodes[i][j + 1]);
                    }
                    int sum = 1;
                    for (Node value : map.values()) {
                        sum += value.area;
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;
    }

    private void dfs(Node[][] nodes, Node node, int[][] grid, int x, int y) {
        if (x < 0 || x == grid.length) {
            return;
        }
        if (y < 0 || y == grid[0].length) {
            return;
        }

        if (grid[x][y] == 0 || grid[x][y] == 2) {
            return;
        }

        grid[x][y] = 2;

        nodes[x][y] = node;
        node.area++;
        dfs(nodes, node, grid, x + 1, y);
        dfs(nodes, node, grid, x - 1, y);
        dfs(nodes, node, grid, x, y - 1);
        dfs(nodes, node, grid, x, y + 1);
    }


    private static class Node {

        String key;

        int area;

        public Node(String key, int area) {
            this.key = key;
            this.area = area;
        }

    }

}
