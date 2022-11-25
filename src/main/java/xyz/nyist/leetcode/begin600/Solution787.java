package xyz.nyist.leetcode.begin600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/24 22:06
 * @Description:
 */
public class Solution787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int ans = findCheapestPrice(flights, src, dst, k, new HashMap<>());
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    public int findCheapestPrice(int[][] flights, int src, int dst, int k, Map<String, Integer> cache) {
        String key = src + "," + k;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (src == dst) {
            return 0;
        }
        if (k == -1) {
            return Integer.MAX_VALUE;
        }
        int ans = Integer.MAX_VALUE;

        for (int[] flight : flights) {
            if (flight[0] == src) {
                int price = findCheapestPrice(flights, flight[1], dst, k - 1, cache);
                if (price != Integer.MAX_VALUE) {
                    ans = Math.min(ans, flight[2] + price);
                }
            }
        }

        cache.put(key, ans);
        return ans;
    }
}
