package xyz.nyist.leetcode.offer;

/**
 * @author: silence
 * @Date: 2022/9/8 14:32
 * @Description: <a href="https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/">链接</a>
 */
public class Offer56_1 {

    public int[] singleNumbers(int[] nums) {
        int res = 0;

        for (int num : nums) {
            res ^= num;
        }

        int k = 1;
        while ((res & k) == 0) {
            k <<= 1;
        }

        int a = 0, b = 0;


        for (int num : nums) {
            if ((num & k) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }


        return new int[]{a, b};
    }

}
