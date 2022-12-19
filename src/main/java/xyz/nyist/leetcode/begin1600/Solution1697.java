package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: silence
 * @Date: 2022/12/17 18:17
 * @Description:
 */
public class Solution1697 {

    int[] parent;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));

        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }

        Arrays.sort(index, Comparator.comparingInt(o -> queries[o][2]));

        boolean[] ans = new boolean[queries.length];


        int start = 0;
        for (Integer i : index) {

            for (; start < edgeList.length; start++) {
                if (edgeList[start][2] >= queries[i][2]) {
                    break;
                }
                union(edgeList[start][0], edgeList[start][1]);
            }

            ans[i] = connected(queries[i][0], queries[i][1]);
        }


        return ans;
    }


    private boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    private void union(int p, int q) {
        int pParent = find(p);
        int qParent = find(q);
        if (pParent == qParent) {
            return;
        }
        parent[pParent] = qParent;
    }

    private int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

}
