package xyz.nyist.leetcode.begin1800;

public class Solution1945 {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 'a' + 1);
        }

        String str = sb.toString();
        for (int i = 0; i < k; i++) {
            int t = 0;
            for (char c : str.toCharArray()) {
                t += (c - '0');
            }
            str = String.valueOf(t);
        }


        return Integer.parseInt(str);
    }
}
