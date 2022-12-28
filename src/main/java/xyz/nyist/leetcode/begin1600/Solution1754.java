package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/12/28 17:45
 * @Description:
 */
public class Solution1754 {
    public static void main(String[] args) {
        System.out.println(new Solution1754().largestMerge("cabaa", "bcaaa"));
    }

    public String largestMerge(String word1, String word2) {
        return largestMerge(word1, word2, 0, 0);
    }

    public String largestMerge(String word1, String word2, int index1, int index2) {

        if (index1 < word1.length() && index2 < word2.length()) {
            if (word1.charAt(index1) > word2.charAt(index2)) {
                return word1.charAt(index1) + largestMerge(word1, word2, index1 + 1, index2);
            } else if (word1.charAt(index1) < word2.charAt(index2)) {
                return word2.charAt(index2) + largestMerge(word1, word2, index1, index2 + 1);
            } else {
                if (word1.substring(index1).compareTo(word2.substring(index2)) > 0) {
                    return word1.charAt(index1) + largestMerge(word1, word2, index1 + 1, index2);
                } else {
                    return word1.charAt(index1) + largestMerge(word1, word2, index1, index2 + 1);
                }
            }
        }

        if (index1 < word1.length()) {
            return word1.substring(index1);
        }


        return word2.substring(index2);
    }
}
