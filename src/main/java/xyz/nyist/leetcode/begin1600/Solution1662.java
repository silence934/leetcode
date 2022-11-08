package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/1 14:53
 * @Description:
 */
public class Solution1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int m = 0, n = 0;
        int p1 = 0, p2 = 0;

        while (m < word1.length && n < word2.length) {
            String s1 = word1[m];
            String s2 = word2[n];
            while (p1 < s1.length() && p2 < s2.length()) {
                if (s1.charAt(p1) != s2.charAt(p2)) {
                    return false;
                }
                p1++;
                p2++;
            }
            System.out.println(p1 + " " + p2);
            if (p1 == s1.length()) {
                p1 = 0;
                m++;
            }

            if (p2 == s2.length()) {
                p2 = 0;
                n++;
            }

        }

        System.out.println(m + " " + n);
        return m == word1.length && n == word2.length;
    }

}
