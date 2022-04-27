package xyz.nyist.leetcode.begin600;

import java.util.*;

/**
 * @author: fucong
 * @Date: 2022/4/27 14:59
 * @Description: Dijkstra
 */
public class Solution743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] edges = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] time : times) {
            edges[time[0]].add(new int[]{time[1], time[2]});
        }

        int[] distTo = new int[n + 1];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[0] = -1;
        distTo[k] = 0;

        PriorityQueue<State> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distFromStart));
        queue.add(new State(k, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (distTo[state.id] < state.distFromStart) {
                continue;
            }

            distTo[state.id] = state.distFromStart;

            for (int[] edge : edges[state.id]) {
                int to = state.distFromStart + edge[1];
                if (to < distTo[edge[0]]) {
                    queue.add(new State(edge[0], to));
                }
            }

        }


        int ans = Integer.MIN_VALUE;
        for (int to : distTo) {
            ans = Math.max(ans, to);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static class State {

        private int id;

        // 从 start 节点到当前节点的距离
        private int distFromStart;

        public State(int id, int distFromStart) {
            this.id = id;
            this.distFromStart = distFromStart;
        }

    }

}
