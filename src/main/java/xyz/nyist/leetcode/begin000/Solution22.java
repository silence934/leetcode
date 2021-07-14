package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2021/7/6 18:48
 * @Description:
 */
public class Solution22 {


    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        List<List<String>> dp = new ArrayList<>();
        dp.add(Arrays.asList(""));
        dp.add(Arrays.asList("()"));

        for (int i = 2; i < n + 1; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String s : dp.get(j)) {
                    for (String s1 : dp.get(i - j - 1)) {
                        list.add("(" + s + ")" + s1);
                    }
                }
            }
            dp.add(list);

        }

        return dp.get(n);
    }

}
