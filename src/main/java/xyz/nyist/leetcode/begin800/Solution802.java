package xyz.nyist.leetcode.begin800;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2021/8/5 19:32
 * @Description:
 */
public class Solution802 {

    //[[1,2],[2,3],[5],[0],[5],[],[]]
    Boolean[] map;
    List<Integer> list;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        map = new Boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            list = new ArrayList<>();
            if (get(i, graph)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean get(int k, int[][] graph) {
        if (map[k] != null) {
            return map[k];
        }
        boolean res = true;

        if (list.contains(k)) {
            res = false;
        } else {
            list.add(k);
            for (int i : graph[k]) {
                res = res && !get(i, graph);
            }
        }

        map[k] = res;
        return res;
    }


}
