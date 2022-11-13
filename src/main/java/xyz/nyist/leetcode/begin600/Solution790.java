package xyz.nyist.leetcode.begin600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/12 18:54
 * @Description:
 */
public class Solution790 {

    static final int MOD = 1000000007;

    public int numTilings(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 5);
        return numTilings(n, cache);
    }


    public int numTilings(int n, Map<Integer, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int ans = (2 * numTilings(n - 1, cache) % MOD + numTilings(n - 3, cache)) % MOD;
        cache.put(n, ans);
        return ans;
    }

}
