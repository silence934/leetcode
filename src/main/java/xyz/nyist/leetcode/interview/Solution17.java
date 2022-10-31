package xyz.nyist.leetcode.interview;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/10/28 21:53
 * @Description:
 */
public class Solution17 {

    public int getKthMagicNumber(int k) {

        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int[] bast = new int[]{3, 5, 7};

        Long ans = 0L;
        for (int i = 0; i < k; i++) {
            Long min = queue.poll();
            ans = min;
            for (int t : bast) {
                Long p = min * t;
                if (!set.contains(p)) {
                    set.add(p);
                    queue.add(p);
                }
            }
        }


        return ans.intValue();
    }

}
