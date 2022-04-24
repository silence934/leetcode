package xyz.nyist.leetcode.begin600;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/4/22 19:43
 * @Description:
 */
public class Solution797 {

    private List<List<Integer>> ans;

    private LinkedList<Integer> path;

    private boolean[] used;

    private int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        ans = new ArrayList<>();
        path = new LinkedList<>();
        path.add(0);
        used = new boolean[graph.length];
        used[0] = true;
        find(0, graph.length - 1);
        return ans;
    }

    private void find(int index, int target) {
        if (index == target) {
            ans.add(new ArrayList<>(path));
        }

        for (int i : graph[index]) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(i);
            find(i, target);
            used[i] = false;
            path.removeLast();
        }

    }

}
