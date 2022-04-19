package xyz.nyist.leetcode.begin1000;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: fucong
 * @Date: 2022/4/19 17:45
 * @Description: Union-Find 并查集算法 最小生成树  待验证
 * https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247492575&idx=1&sn=bf63eb391351a0dfed0d03e1ac5992e7&scene=21#wechat_redirect
 */
public class Solution1135 {

    int minimumCost(int n, int[][] connections) {

        UF uf = new UF(n);

        Arrays.sort(connections, Comparator.comparingInt(o -> o[2]));

        int ans = 0;

        for (int[] connection : connections) {
            if (!uf.connected(connection[0], connection[1])) {
                uf.union(connection[0], connection[1]);
                ans += connection[2];
            }
        }

        return uf.count() == 1 ? ans : -1;
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
