package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/9 16:16
 * @Description: <a href="https://leetcode.cn/problems/WGki4K/?plan=lcof&plan_progress=zqxc5y6">...</a>
 */
public class Offer4 {

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
            if (k % 3 == 1) {
                res |= (1 << i);
            }
        }


        return res;
    }

}
