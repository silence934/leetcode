package xyz.nyist.leetcode.begin800;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: silence
 * @Date: 2022/9/11 22:28
 * @Description:
 */
public class Solution857 {

    public static void main(String[] args) {
        System.out.println(new Solution857().mincostToHireWorkers(new int[]{4, 4, 4, 5}, new int[]{13, 12, 13, 12}, 2));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        Integer[] h = new Integer[quality.length];
        for (int i = 0; i < h.length; i++) {
            h[i] = i;
        }

        Arrays.sort(h, (o1, o2) -> {
            double v = ((double) wage[o1]) / quality[o1] - ((double) wage[o2]) / quality[o2];
            return v == 0 ? 0 : v > 0 ? 1 : -1;
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        int qualityTotal = 0;
        double ans = Double.MAX_VALUE;
        for (int i = 0; i < quality.length; i++) {
            qualityTotal += quality[h[i]];
            queue.offer(quality[h[i]]);

            if (queue.size() == k) {
                ans = Math.min(qualityTotal * ((double) wage[h[i]]) / quality[h[i]], ans);
                Integer poll = queue.poll();
                qualityTotal -= poll;
            }
        }

        return ans;
    }

}
