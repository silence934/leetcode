package xyz.nyist.leetcode.offer_special_assault;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/9/11 20:10
 * @Description:
 */
public class Offer10 {

    public static void main(String[] args) {
        System.out.println(new Offer10().subarraySum(new int[]{1, 1, 1}, 2));
    }

    public int subarraySum(int[] nums, int k) {

        int ans = 0;

        int[] pre = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int p : pre) {
            int target = p - k;

            ans += map.getOrDefault(target, 0);
            map.put(p, map.getOrDefault(p, 0) + 1);

        }


        return ans;
    }

}
