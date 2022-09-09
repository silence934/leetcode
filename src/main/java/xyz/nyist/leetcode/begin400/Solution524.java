package xyz.nyist.leetcode.begin400;

import java.util.Arrays;
import java.util.List;

/**
 * @author: silence
 * @Date: 2021/9/15 10:27
 * @Description:
 */
public class Solution524 {


    public static void main(String[] args) {
        System.out.println(new Solution524().findLongestWord("abpcplea",
                                                             Arrays.asList("ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa")));
    }

    public String findLongestWord(String s, List<String> dictionary) {

        dictionary.sort((o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            } else {
                return o1.compareTo(o2);
            }
        });


        int[][] map = new int[s.length()][26];


        for (int i = s.length() - 1; i > -1; i--) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) - 97 == j) {
                    map[i][j] = i;
                } else if (i < s.length() - 1) {
                    map[i][j] = map[i + 1][j];
                } else {
                    map[i][j] = -1;
                }
            }
        }


        for (String s1 : dictionary) {
            int k = -1, i = 0;
            while (i < s1.length() && k + 1 < s.length()) {
                k = map[k + 1][s1.charAt(i) - 97];
                if (k == -1) {
                    break;
                }
                i++;
            }
            if (i == s1.length()) {
                return s1;
            }
        }


        return "";
    }

}
