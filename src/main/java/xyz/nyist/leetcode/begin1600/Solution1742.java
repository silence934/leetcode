package xyz.nyist.leetcode.begin1600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/23 21:10
 * @Description:
 */
public class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = lowLimit; i < highLimit + 1; i++) {
            int k = computer(i);
            int v = map.getOrDefault(k, 0);
            ans = Math.max(ans, v);
            map.put(k, v);
        }

        return ans;
    }

    private int computer(int i) {
        int ans = 0;
        for (char c : String.valueOf(i).toCharArray()) {
            ans += (c - '0');
        }
        return ans;
    }

}
