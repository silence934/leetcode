package xyz.nyist.leetcode.begin1200;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/11/23 21:28
 * @Description:
 */
public class Solution1345 {

    public static void main(String[] args) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        queue.add(new int[]{1, 1});
        queue.add(new int[]{1, 2});
        queue.add(new int[]{1, 3});

        System.out.println(new Solution1345().minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
    }

    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            map.put(arr[i], list);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        int[] dist = new int[arr.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int l = cur[0];
            int p = cur[1];
            if (p == arr.length - 1) {
                return l;
            }

            if (l > dist[p]) {
                continue;
            }

            if (p != arr.length - 1 && dist[p + 1] > l + 1) {
                dist[p + 1] = l + 1;
                queue.offer(new int[]{l + 1, p + 1});
            }

            if (p != 0 && dist[p - 1] > l + 1) {
                dist[p - 1] = l + 1;
                queue.offer(new int[]{l + 1, p - 1});
            }

            if (map.containsKey(arr[p])) {
                for (Integer integer : map.get(arr[p])) {
                    if (integer != p) {
                        if (dist[integer] > l + 1) {
                            dist[integer] = l + 1;
                            queue.offer(new int[]{l + 1, integer});
                        }
                    }
                }
                map.remove(arr[p]);
            }

        }

        return dist[arr.length - 1];
    }
}



