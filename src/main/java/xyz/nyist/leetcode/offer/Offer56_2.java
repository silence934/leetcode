package xyz.nyist.leetcode.offer;

/**
 * @author: silence
 * @Date: 2022/9/8 14:42
 * @Description: <a href="https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/">link</a>
 */
public class Offer56_2 {

    public int singleNumber(int[] nums) {


        int res = 0;

        for (int i = 0; i < 32; i++) {

            int k = 0;

            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) {
                    k++;
                }
                nums[j] >>= 1;
            }
            res += (k % 3 * Math.pow(2, i));

        }


        return res;
    }

}
