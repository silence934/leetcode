package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/9 19:33
 * @Description:
 */
public class Solution1780 {
    public boolean checkPowersOfThree(int n) {

        while (n > 3) {
            if (n % 3 == 2) {
                return false;
            }
            n = n / 3;
        }

        return n != 2;
    }
}
