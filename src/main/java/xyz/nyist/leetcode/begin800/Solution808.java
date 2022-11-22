package xyz.nyist.leetcode.begin800;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/21 16:41
 * @Description:
 */
public class Solution808 {

    public static void main(String[] args) {
        System.out.println(new Solution808().soupServings(50));
    }

    public double soupServings(int n) {
        if (n > 5000) {
            return 1.0;
        }
        double[] doubles = soupServings(n, n, new HashMap<>());
        return doubles[0] + doubles[1] * 0.5;
    }


    private double[] soupServings(int m, int n, Map<String, double[]> cache) {
        String key = m + "," + n;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        if (m <= 0 && n <= 0) {
            return new double[]{0, 1};
        } else if (m <= 0) {
            return new double[]{1, 0};
        } else if (n <= 0) {
            return new double[]{0, 0};
        }


        double[] serving1 = soupServings(m - 100, n, cache);
        double[] serving2 = soupServings(m - 75, n - 25, cache);
        double[] serving3 = soupServings(m - 50, n - 50, cache);
        double[] serving4 = soupServings(m - 25, n - 75, cache);

        double[] ans = new double[]{
                serving1[0] * 0.25 + serving2[0] * 0.25 + serving3[0] * 0.25 + serving4[0] * 0.25,
                serving1[1] * 0.25 + serving2[1] * 0.25 + serving3[1] * 0.25 + serving4[1] * 0.25
        };
        cache.put(key, ans);
        return ans;
    }

}
