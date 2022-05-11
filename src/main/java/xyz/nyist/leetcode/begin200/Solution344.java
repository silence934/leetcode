package xyz.nyist.leetcode.begin200;

/**
 * @author: fucong
 * @Date: 2022/5/11 15:42
 * @Description:
 */
public class Solution344 {

    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char c = s[left];
            s[left] = s[right];
            s[right] = c;
            left++;
            right--;
        }

    }

}
