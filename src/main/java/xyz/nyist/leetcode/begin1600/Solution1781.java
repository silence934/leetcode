package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/12/12 17:54
 * @Description:
 */
public class Solution1781 {

    public int beautySum(String s) {

        int ans = 0;

        int[] count = new int[26];
        for (int i = 0; i < s.length() - 2; i++) {
            Arrays.fill(count, 0);

            count[s.charAt(i) - 'a']++;
            count[s.charAt(i + 1) - 'a']++;

            for (int j = i + 2; j < s.length(); j++) {
                count[s.charAt(j) - 'a']++;

                int max = 0, min = Integer.MAX_VALUE;
                for (int i1 : count) {
                    if (i1 != 0) {
                        max = Math.max(max, i1);
                        min = Math.min(min, i1);
                    }
                }
                System.out.println(max - min);

                ans += (max - min);

            }
        }


        return ans;
    }

}
