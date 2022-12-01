package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/12/1 19:44
 * @Description:
 */
public class Solution43 {

    public String multiply(String num1, String num2) {

        int[] ans = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            int x = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                ans[i + j + 1] += x * (num2.charAt(j) - '0');
            }
        }

        for (int i = ans.length - 1; i > 0; i--) {
            ans[i - 1] += ans[i] / 10;
            ans[i] = ans[i] % 10;
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < ans.length && ans[i] == 0) {
            i++;
        }
        if (i == ans.length) {
            return "0";
        }
        for (; i < ans.length; i++) {
            sb.append(ans[i]);
        }

        return sb.toString();
    }
}
