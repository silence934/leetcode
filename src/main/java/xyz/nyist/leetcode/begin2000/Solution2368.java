package xyz.nyist.leetcode.begin2000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution2368 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] map = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        Set<Integer> restrictedSet = new HashSet<>();
        Set<Integer> used = new HashSet<>();
        for (int i : restricted) {
            restrictedSet.add(i);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addFirst(0);

        int ans = 0;
        while (!queue.isEmpty()) {
            int p = queue.removeLast();
            used.add(p);
            ans++;
            for (Integer i : map[p]) {
                if (!used.contains(i) && !restrictedSet.contains(i)) {
                    queue.addFirst(i);
                }
            }
        }


        return ans;
    }
}
