package xyz.nyist.leetcode.begin000;

/**
 * @author: fucong
 * @Date: 2022/3/15 15:59
 * @Description:
 */
public class Solution13 {

    public int romanToInt(String s) {

        s = s.replaceAll("CD", "400 ");
        s = s.replaceAll("CM", "900 ");
        s = s.replaceAll("XL", "40 ");
        s = s.replaceAll("XC", "90 ");
        s = s.replaceAll("IX", "9 ");
        s = s.replaceAll("IV", "4 ");

        s = s.replaceAll("I", "1 ");
        s = s.replaceAll("V", "5 ");
        s = s.replaceAll("X", "10 ");
        s = s.replaceAll("L", "50 ");
        s = s.replaceAll("C", "100 ");
        s = s.replaceAll("D", "500 ");
        s = s.replaceAll("M", "1000 ");

        System.out.println(s);
        String[] s1 = s.split(" ");

        int res = 0;

        for (String s2 : s1) {
            res += Integer.parseInt(s2);
        }

        return res;
    }

}
