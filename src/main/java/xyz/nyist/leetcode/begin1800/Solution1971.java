package xyz.nyist.leetcode.begin1800;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/12/19 12:06
 * @Description:
 */
public class Solution1971 {


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }

        boolean[] used = new boolean[n];

        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(source);
        used[source] = true;

        while (!list.isEmpty()) {
            Integer cur = list.removeFirst();
            if (cur == destination) {
                return true;
            }
            for (Integer point : map[cur]) {
                if (!used[point]) {
                    list.addLast(point);
                    used[point] = true;
                }
            }
        }


        return false;
    }

    public boolean validPath1(int n, int[][] edges, int source, int destination) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(parent, edge[0], edge[1]);
        }

        return collection(parent, source, destination);
    }


    private int find(int[] parent, int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    private boolean collection(int[] parent, int p, int q) {
        return find(parent, p) == find(parent, q);
    }


    private void union(int[] parent, int p, int q) {
        int pParent = find(parent, p);
        int qParent = find(parent, q);

        if (pParent == qParent) {
            return;
        }

        parent[pParent] = qParent;
    }

}
