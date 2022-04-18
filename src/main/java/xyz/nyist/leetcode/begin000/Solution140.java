package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/4/18 17:01
 * @Description:
 */
public class Solution140 {

    public static void main(String[] args) {
        Solution140 solution140 = new Solution140();
        System.out.println(solution140.wordBreak("catsanddog"
                , Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }


    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String>[] dp = new List[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new ArrayList<>();
        }

        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                if (i >= word.length() - 1 && s.startsWith(word, i - word.length() + 1)) {
                    List<String> list = new ArrayList<>();
                    if (i == word.length() - 1) {
                        list.add(word);
                    } else {
                        for (String str : dp[i - word.length()]) {
                            list.add(str + " " + word);
                        }
                    }
                    dp[i].addAll(list);
                }
            }
        }

        return dp[s.length() - 1];
    }

}
