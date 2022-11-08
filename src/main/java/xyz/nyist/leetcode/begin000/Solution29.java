package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/9/23 18:17
 * @Description:
 */
public class Solution29 {


    public static void main(String[] args) {
        int a = 1026117192;
        int b = -874002063;
        System.out.println(new Solution29().divide(a, b));
    }

    public int divide(int dividend, int divisor) {
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return -dividend;
        } else if (divisor == 1) {
            return dividend;
        }


        boolean isPos = true;
        if (dividend > 0) {
            dividend = -dividend;
        } else {
            isPos = false;
        }

        if (divisor > 0) {
            divisor = -divisor;
        } else {
            isPos = !isPos;
        }


        int l = 0, r = -(dividend >> 1) + 1;

        int mid = 1;
        while (l <= r) {
            mid = l + ((r - l) >> 1);

            int m = multi(divisor, mid);
            if (m > dividend) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return isPos ? mid : -mid;
    }

    private int multi(int a, int b) {
        int ans = 0;

        int k = a;

        while (b != 0) {
            if (k >= 0) {
                return 1;
            }
            if ((b & 1) == 1) {
                ans += k;
                if (ans >= 0) {
                    return 1;
                }
            }
            b = (b >> 1);
            k += k;

        }


        return ans;
    }


}
