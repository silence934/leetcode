package xyz.nyist.leetcode.begin1400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: silence
 * @Date: 2022/4/27 17:33
 * @Description: https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247492167&idx=1&sn=bc96c8f97252afdb3973c7d760edb9c0&scene=21#wechat_redirect
 */
public class Solution1514 {

    public static void main(String[] args) {
        Solution1514 solution1514 = new Solution1514();
        System.out.println(solution1514.maxProbability(3, new int[][]{
                                                               new int[]{0, 1},
                                                               new int[]{1, 2},
                                                               new int[]{0, 2}},
                                                       new double[]{0.5, 0.5, 0.2},
                                                       0,
                                                       2));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {


        List<State>[] sides = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            sides[i] = new ArrayList<>();
        }

        for (int i = 0; i < succProb.length; i++) {
            sides[edges[i][0]].add(new State(edges[i][1], succProb[i]));
            sides[edges[i][1]].add(new State(edges[i][0], succProb[i]));
        }

        double[] map = new double[n];
        Arrays.fill(map, 0);

        PriorityQueue<State> queue = new PriorityQueue<>((o1, o2) -> Double.compare(o2.distFromStart, o1.distFromStart));

        queue.add(new State(start, 1));

        while (!queue.isEmpty()) {
            State poll = queue.poll();
            if (poll.distFromStart < map[poll.id]) {
                continue;
            }
            map[poll.id] = poll.distFromStart;
            if (map[poll.id] == end) {
                return map[end];
            }

            for (State ints : sides[poll.id]) {
                double t = ints.distFromStart * poll.distFromStart;
                if (t > map[ints.id]) {
                    queue.add(new State(ints.id, t));
                }
            }

        }


        return map[end];
    }

    private static class State {

        private int id;

        // 从 start 节点到当前节点的距离
        private double distFromStart;

        public State(int id, double distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }

    }

}
