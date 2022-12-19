package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/12/17 20:29
 * @Description:
 */
public class Solution38 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }
        String pre = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pre.length(); ) {
            char c = pre.charAt(i);
            int t = i + 1;
            while (t < pre.length() && c == pre.charAt(t)) {
                t++;
            }
            sb.append(t - i).append(c);
            i = t;
        }

        return sb.toString();
    }
}
