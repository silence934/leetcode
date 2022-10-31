package xyz.nyist.leetcode.begin1800;

/**
 * @author: silence
 * @Date: 2022/10/27 20:29
 * @Description:
 */
public class Solution1822 {

    public int arraySign(int[] nums) {
        boolean b = true;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                b = !b;
            }
        }

        return b ? 1 : -1;
    }

}
