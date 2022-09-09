package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2021/7/9 19:00
 * @Description:
 */
public class Solution91 {

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }
        int[] dp = new int[chars.length];
        dp[0] = 1;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (chars[i - 1] == '0' || chars[i - 1] > '2') {
                    return 0;
                } else {
                    dp[i] = i > 1 ? dp[i - 2] : 1;
                }
            } else {
                dp[i] = dp[i - 1];
                if (chars[i - 1] != '0' && Integer.parseInt("" + chars[i - 1] + chars[i]) < 27) {
                    dp[i] += (i > 1 ? dp[i - 2] : 1);
                }
            }
        }


        return dp[chars.length - 1];
    }

}
