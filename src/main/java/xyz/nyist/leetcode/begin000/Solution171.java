package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/7/30 17:49
 * @Description:
 */
public class Solution171 {

    public static void main(String[] args) {
        System.out.println('A' - 64);
    }

    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = columnTitle.length() - 1; i > -1; i--) {
            System.out.println("xx");
            res += ((columnTitle.charAt(i) - 65) * Math.pow(26, columnTitle.length() - 1 - i));
        }
        return res;
    }

}
