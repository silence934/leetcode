package xyz.nyist.leetcode.begin2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2788 {
    public static void main(String[] args) {
        System.out.println(new Solution2788().splitWordsBySeparator(Arrays.asList("$easy$", "$problem$"), '$'));
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            //.,|$#@
            String[] arr;
            if (separator == '.' || separator == '|' || separator == '$') {
                arr = word.split("\\" + separator);
            } else {
                arr = word.split("" + separator);
            }
            for (String a : arr) {
                if (!a.isEmpty()) {
                    ans.add(a);
                }
            }
        }
        return ans;
    }
}
