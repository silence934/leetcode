package xyz.nyist.leetcode.begin2000;

import xyz.nyist.utils.ArrUtil;

import java.util.*;

public class Solution2846 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new Solution2846().minOperationsQueries(8,
                ArrUtil.String2Arrays("[[1,2,6],[1,3,4],[2,4,6],[2,5,3],[3,6,6],[3,0,8],[7,0,2]]"),
                ArrUtil.String2Arrays("[[4,6],[0,4],[6,5],[7,4]]"))));
    }

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {

        ArrayList<int[]>[] arrayLists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            arrayLists[edge[0]].add(new int[]{edge[0], edge[1], edge[2]});
            arrayLists[edge[1]].add(new int[]{edge[1], edge[0], edge[2]});
        }

        //edges2[i][j]=从0号节点出发到达节点i经历权重为j路径数量
        int[][] edges2 = new int[n][27];

        LinkedList<int[]> list = new LinkedList<>();
        Set<Integer> used = new HashSet<>();
        used.add(0);
        list.add(new int[]{0, 0, 0});
        edges2[0] = new int[27];

        while (!list.isEmpty()) {
            int[] point = list.removeLast();
            int lastPoint = point[0];
            int currentPoint = point[1];
            int w = point[2];

            edges2[currentPoint] = new int[27];
            System.arraycopy(edges2[lastPoint], 0, edges2[currentPoint], 0, 27);
            edges2[currentPoint][w]++;

            for (int[] i : arrayLists[currentPoint]) {
                if (!used.contains(i[1])) {
                    used.add(i[1]);
                    list.addLast(i);
                }
            }

        }


        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            //公共祖先
            int p = queries[i][0];
            int q = queries[i][1];
            Set<Integer> x = new HashSet<>();
            x.add(0);
            int ancestor = ancestor(arrayLists, 0, p, q, x);

            int[] toAncestor = edges2[ancestor];
            int[] toP = edges2[p];
            int[] toQ = edges2[q];


            int count = 0, max = 0;
            for (int j = 1; j < 27; j++) {
                int t = toP[j] + toQ[j] - 2 * toAncestor[j];
                count += t;
                max = Math.max(max, t);
            }
            ans[i] = count - max;

        }

        return ans;
    }


    private int ancestor(ArrayList<int[]>[] arrayLists, int root, int p, int q, Set<Integer> used) {
        if (root == p || root == q) {
            return root;
        }


        List<Integer> ans = new ArrayList<>();
        for (int[] ints : arrayLists[root]) {
            int to = ints[1];
            if (used.contains(to)) {
                continue;
            }
            used.add(to);
            int res = ancestor(arrayLists, to, p, q, used);
            if (res != -1) {
                ans.add(res);
            }
        }

        if (ans.isEmpty()) {
            return -1;
        } else if (ans.size() == 1) {
            return ans.get(0);
        } else {
            return root;
        }
    }


}
