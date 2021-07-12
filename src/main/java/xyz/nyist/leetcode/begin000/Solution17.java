package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2021/7/12 19:30
 * @Description:
 */
public class Solution17 {


    public static void main(String[] args) {
        System.out.println(new Solution17().letterCombinations("23"));
    }

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        for (char c : get(digits.charAt(0))) {
            list.add("" + c);
        }

        this.letter(digits, 1, list);
        return this.list;
    }


    private void letter(String digits, int p, List<String> list) {
        if (p >= digits.length()) {
            this.list.addAll(list);
            return;
        }
        List<String> list1 = new ArrayList<>();
        for (String s : list) {
            for (char c : get(digits.charAt(p))) {
                list1.add(s + c);
            }
        }
        this.letter(digits, p + 1, list1);
    }


    private char[] get(char c) {
        switch (c) {
            case '2':
                return new char[]{'a', 'b', 'c'};
            case '3':
                return new char[]{'d', 'e', 'f'};
            case '4':
                return new char[]{'g', 'h', 'i'};
            case '5':
                return new char[]{'j', 'k', 'l'};
            case '6':
                return new char[]{'m', 'n', 'o'};
            case '7':
                return new char[]{'p', 'q', 'r', 's'};
            case '8':
                return new char[]{'t', 'u', 'v'};
            default:
                return new char[]{'w', 'x', 'y', 'z'};
        }
    }


}
