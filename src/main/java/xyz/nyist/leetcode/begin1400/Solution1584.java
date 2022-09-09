package xyz.nyist.leetcode.begin1400;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: silence
 * @Date: 2022/4/19 18:07
 * @Description: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247492575&idx=1&sn=bf63eb391351a0dfed0d03e1ac5992e7&scene=21#wechat_redirect
 */
public class Solution1584 {

    public static void main(String[] args) {
        Solution1584 solution1584 = new Solution1584();
        System.out.println(solution1584.minCostConnectPoints(new int[][]{
                new int[]{0, 0}
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

        Prim prim = new Prim(weights, points.length);
        return prim.allConnected() ? prim.weightSum() : -1;

       /* weights.sort(Comparator.comparingInt(o -> o[2]));

        UF uf = new UF(points.length);

        int ans = 0;

        for (int[] weight : weights) {
            if (!uf.connected(weight[0], weight[1])) {
                uf.union(weight[0], weight[1]);
                ans += weight[2];
            }
        }

        return ans;*/
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


    public static class Prim {

        private int weightSum;

        private final boolean[] inMst;

        private final PriorityQueue<int[]> priorityQueue;

        private final List<int[]>[] graph;

        public Prim(List<int[]> graph, int n) {
            weightSum = 0;
            inMst = new boolean[n];
            this.graph = new List[n];
            for (int[] edge : graph) {
                int form = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if (this.graph[form] == null) {
                    this.graph[form] = new ArrayList<>();
                }
                this.graph[form].add(new int[]{form, to, weight});
                if (this.graph[to] == null) {
                    this.graph[to] = new ArrayList<>();
                }
                this.graph[to].add(new int[]{to, form, weight});
            }

            priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

            inMst[0] = true;
            cut(0);
            while (!priorityQueue.isEmpty()) {
                int[] poll = priorityQueue.poll();

                int to = poll[1];
                int weight = poll[2];
                if (inMst[to]) {
                    continue;
                }

                weightSum += weight;
                inMst[to] = true;
                cut(to);
            }


        }


        // 最小生成树的权重和
        public int weightSum() {
            return weightSum;
        }


        private void cut(int p) {
            if (graph[p] == null) {
                return;
            }
            for (int[] edge : graph[p]) {
                if (!inMst[edge[1]]) {
                    priorityQueue.add(edge);
                }
            }
        }

        // 判断最小生成树是否包含图中的所有节点
        public boolean allConnected() {
            for (boolean b : inMst) {
                if (!b) {
                    return false;
                }
            }
            return true;
        }

    }

}
