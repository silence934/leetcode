package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/7/20 19:23
 * @Description:
 */
public class Solution7 {

    public static void main(String[] args) {
        System.out.println(new Solution7().reverse(-2147483648));
    }


    public int reverse(int x) {
        boolean k = x < 0;
        long p = x;
        if (k) {
            p = -p;
        }
        long res = Long.parseLong(new StringBuilder("" + p).reverse().toString());
        if ((!k && res > Integer.MAX_VALUE) || (k && res > (long) Integer.MAX_VALUE + 1)) {
            return 0;
        }

        return (int) (k ? -res : res);
    }

}
