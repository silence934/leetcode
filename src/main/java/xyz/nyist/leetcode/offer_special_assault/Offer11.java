package xyz.nyist.leetcode.offer_special_assault;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/9/11 20:10
 * @Description:
 */
public class Offer11 {

    public static void main(String[] args) {
        System.out.println(new Offer11().findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
    }

    public int findMaxLength(int[] nums) {

        int ans = 0;

        //pre i  -> [0,i)缺pre[i]个0
        int[] pre = new int[nums.length + 1];

        for (int i = 1; i < pre.length; i++) {
            int num = nums[i - 1];
            if (num == 1) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = pre[i - 1] - 1;
            }
        }

        //key-> 缺的个数  value->最开始的下标
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < pre.length; i++) {
            int target = pre[i];

            Integer index = map.get(target);
            if (index != null) {
                ans = Math.max(ans, i - index);
            }

            map.putIfAbsent(pre[i], i);
        }


        return ans;
    }

}
