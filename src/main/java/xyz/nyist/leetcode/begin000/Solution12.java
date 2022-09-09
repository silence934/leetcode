package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/3/15 14:21
 * 字符          数值
 * I             1
 * IV            4
 * V             5
 * IX            9
 * X             10
 * XL            40
 * L             50
 * XC            90
 * C             100
 * CD            400
 * D             500
 * CM            900
 * M             1000
 */
public class Solution12 {

    public String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        int i = num / 1000;
        num = num - i * 1000;
        sb.append(get(i, "M"));

        i = num / 900;
        num = num - i * 900;
        sb.append(get(i, "CM"));

        i = num / 500;
        num = num - i * 500;
        sb.append(get(i, "D"));

        i = num / 400;
        num = num - i * 400;
        sb.append(get(i, "CD"));

        i = num / 100;
        num = num - i * 100;
        sb.append(get(i, "C"));

        i = num / 90;
        num = num - i * 90;
        sb.append(get(i, "XC"));

        i = num / 50;
        num = num - i * 50;
        sb.append(get(i, "L"));

        i = num / 40;
        num = num - i * 40;
        sb.append(get(i, "XL"));

        i = num / 10;
        num = num - i * 10;
        sb.append(get(i, "X"));

        i = num / 9;
        num = num - i * 9;
        sb.append(get(i, "IX"));

        i = num / 5;
        num = num - i * 5;
        sb.append(get(i, "V"));

        i = num / 4;
        num = num - i * 4;
        sb.append(get(i, "IV"));

        i = num;
        sb.append(get(i, "I"));

        return sb.toString();
    }

    private String get(int i, String s) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(s);
        }
        return sb.toString();
    }


}
