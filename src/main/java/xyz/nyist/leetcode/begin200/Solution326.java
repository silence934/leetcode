package xyz.nyist.leetcode.begin200;

/**
 * @author: silence
 * @Date: 2021/9/23 19:39
 * @Description:
 */
public class Solution326 {

    public boolean isPowerOfThree(int n) {
        return n > 0 && ((int) Math.pow(3, 19)) % n == 0;
    }

}
