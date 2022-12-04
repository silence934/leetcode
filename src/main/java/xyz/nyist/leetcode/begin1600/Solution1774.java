package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/12/4 11:56
 * @Description:
 */
public class Solution1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        Arrays.sort(toppingCosts);

        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int baseCost : baseCosts) {
            int price = closestCost(toppingCosts, toppingCosts.length - 1, target - baseCost, 0) + baseCost;
            int t = Math.abs(target - price);
            if (t < min || (t == min && price < ans)) {
                min = t;
                ans = price;
            }
        }

        return ans;
    }

    public int closestCost(int[] toppingCosts, int index, int target, int sum) {
        if (index == -1) {
            return sum;
        }

        int ans1 = closestCost(toppingCosts, index - 1, target, sum);
        int ans2 = closestCost(toppingCosts, index - 1, target, sum + toppingCosts[index]);
        int ans3 = closestCost(toppingCosts, index - 1, target, sum + 2 * toppingCosts[index]);

        int ans = ans1;
        int absMin = Math.abs(ans1 - target);

        int absMin2 = Math.abs(ans2 - target);
        if (absMin > absMin2 || (absMin == absMin2 && ans2 < ans)) {
            absMin = absMin2;
            ans = ans2;
        }

        int absMin3 = Math.abs(ans3 - target);
        if (absMin > absMin3 || (absMin == absMin3 && ans3 < ans)) {
            ans = ans3;
        }

        return ans;
    }

}
