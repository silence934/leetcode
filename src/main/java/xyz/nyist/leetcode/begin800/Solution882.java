package xyz.nyist.leetcode.begin800;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: silence
 * @Date: 2022/11/26 13:44
 * @Description:
 */
public class Solution882 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        int[][] map = new int[n][n];

        for (int[] edge : edges) {
            map[edge[0]][edge[1]] = edge[2] + 1;
            map[edge[1]][edge[0]] = edge[2] + 1;
        }


        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int id = poll[0];
            int l = poll[1];
            if (l > dist[id]) {
                continue;
            }
            dist[id] = l;

            for (int i = 0; i < n; i++) {
                if (map[id][i] > 0) {
                    int leng = l + map[id][i];
                    if (leng < dist[i]) {
                        dist[i] = leng;
                        queue.offer(new int[]{i, leng});
                    }
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                ans++;
                int left = maxMoves - dist[i];
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > 0) {
                        if (i < j) {
                            ans += Math.min(left, map[i][j] - 1);
                        } else {
                            int t = maxMoves > dist[j] ? Math.min(maxMoves - dist[j], map[j][i] - 1) : 0;
                            ans += Math.min(left, map[i][j] - 1 - t);
                        }
                    }
                }

            }
        }

        
        return ans;
    }
}
