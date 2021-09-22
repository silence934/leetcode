package xyz.nyist.leetcode.begin400;

/**
 * @author: fucong
 * @Date: 2021/9/17 15:19
 * @Description:
 */
public class Solution509 {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
