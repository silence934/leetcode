package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/13 09:50
 * @Description:
 */
public class Offer20 {

    public static void main(String[] args) {
        System.out.println(new Offer20().countSubstrings("aaa"));
    }

    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];


        int asn = s.length();

        for (int i = dp.length - 1; i > -1; i--) {
            for (int j = i; j < dp.length; j++) {
                if (i == j) {
                    dp[i][i] = true;
                    continue;
                }
                boolean b = s.charAt(i) == s.charAt(j);
                if (i + 1 == j) {
                    dp[i][j] = b;
                } else {
                    dp[i][j] = b && dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    asn++;
                }
            }
        }


        return asn;
    }

}
