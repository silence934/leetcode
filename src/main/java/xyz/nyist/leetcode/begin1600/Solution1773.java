package xyz.nyist.leetcode.begin1600;

import java.util.List;

/**
 * @author: silence
 * @Date: 2022/10/29 19:33
 * @Description:
 */
public class Solution1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0;

        int matchIndex;
        if (ruleKey.equals("type")) {
            matchIndex = 0;
        } else if (ruleKey.equals("color")) {
            matchIndex = 1;
        } else {
            matchIndex = 2;
        }


        for (List<String> item : items) {
            if (item.get(matchIndex).equals(ruleValue)) {
                ans++;
            }
        }


        return ans;
    }

}
