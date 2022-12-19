package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/17 20:16
 * @Description:
 */
public class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        long t = goal;

        for (int num : nums) {
            t -= num;
        }

        t = Math.abs(t);

        return (int) (t / limit + (t % limit > 0 ? 1 : 0));
    }
}
