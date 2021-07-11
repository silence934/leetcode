package xyz.nyist.leetcode.begin000;

import java.util.Arrays;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2021/7/11 17:54
 * @Description:
 */
public class Solution139 {

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        System.out.println(solution139.wordBreak("dogs", Arrays.asList("dog", "s", "gs")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() && s.startsWith(word, i - word.length())) {
                    dp[i] = dp[i] || dp[i - word.length()];
                }
            }
        }


        return dp[s.length()];
    }

}
