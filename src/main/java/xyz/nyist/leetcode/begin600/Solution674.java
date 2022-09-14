package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/9/13 17:29
 * @Description:
 */
public class Solution674 {

    public static void main(String[] args) {
        System.out.println(new Solution674().countSubstrings("aaaa"));
    }

    public int countSubstrings(String s) {

        StringBuilder sb = new StringBuilder("$#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        sb.append("!");

        int[] dp = new int[sb.length()];
        dp[0] = 1;
        int index = 0, rightIndex = 0, ans = 0;

        for (int i = 1; i < dp.length - 1; i++) {
            if (i > rightIndex) {
                int left = i, right = i;
                while (sb.charAt(left) == sb.charAt(right)) {
                    left--;
                    right++;
                    dp[i]++;
                }
            } else {
                int t = dp[2 * index - i];

                dp[i] = Math.min(rightIndex - i, t);

                int left = i - dp[i], right = i + dp[i];
                while (sb.charAt(left) == sb.charAt(right)) {
                    left--;
                    right++;
                    dp[i]++;
                }
            }

            if (i + dp[i] - 1 > rightIndex) {
                index = i;
                rightIndex = i + dp[i] - 1;
            }
            ans += dp[i] / 2;

        }


        return ans;
    }

}
