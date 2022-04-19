package xyz.nyist.leetcode.begin1400;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/4/19 18:07
 * @Description: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247492575&idx=1&sn=bf63eb391351a0dfed0d03e1ac5992e7&scene=21#wechat_redirect
 */
public class Solution1584 {

    public static void main(String[] args) {
        Solution1584 solution1584 = new Solution1584();
        System.out.println(solution1584.minCostConnectPoints(new int[][]{
                new int[]{0, 0},
                new int[]{2, 2},
                new int[]{3, 10},
                new int[]{5, 2},
                new int[]{7, 0}
        }));
    }

    public int minCostConnectPoints(int[][] points) {
        //点 weight[x][0] 到 weight[x][1]的距离为 weight[x][2]
        List<int[]> weights = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                weights.add(new int[]{i, j, getWeight(points[i], points[j])});
            }
        }

        weights.sort(Comparator.comparingInt(o -> o[2]));

        UF uf = new UF(points.length);

        int ans = 0;

        for (int[] weight : weights) {
            if (!uf.connected(weight[0], weight[1])) {
                uf.union(weight[0], weight[1]);
                ans += weight[2];
            }
        }

        return ans;
    }

    private int getWeight(int[] pointA, int[] pointB) {
        return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
    }


    public static class UF {

        private int count;

        // 节点 x 的节点是 parent[x]
        private final int[] parent;

        //节点 x 的子节点数量
        private final int[] size;

        // 构造函数，n 为图的节点总数
        public UF(int n) {
            // 一开始互不连通
            this.count = n;
            // 父节点指针初始指向自己
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void union(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            if (rootP == rootQ) {
                return;
            }

            if (size[rootP] > size[rootQ]) {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }

        // 判断 p 和 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = findRoot(p);
            int rootQ = findRoot(q);
            return rootP == rootQ;
        }

        // 返回图中有多少个连通分量
        public int count() {
            return count;
        }


        private int findRoot(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }

            return x;
        }

    }

}
