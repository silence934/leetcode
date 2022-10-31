package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/10/29 19:16
 * @Description:
 */
public class Solution777 {

    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) {
            return false;
        }

        int n = start.length();

        int p = 0, q = 0;

        while (p < n && q < n) {
            while (p < n && start.charAt(p) == 'X') {
                p++;
            }

            while (q < n && end.charAt(q) == 'X') {
                q++;
            }

            if (p == n || q == n) {
                break;
            }

            System.out.println(p);
            System.out.println(q);
            char c1 = start.charAt(p);
            char c2 = end.charAt(q);

            if (c1 != c2) {
                return false;
            }


            if (c1 == 'L' && p < q) {
                return false;
            }

            if (c1 == 'R' && p > q) {
                return false;
            }

            p++;
            q++;
        }


        while (p < n) {
            if (start.charAt(p++) != 'X') {
                return false;
            }
        }

        while (q < n) {
            if (end.charAt(q++) != 'X') {
                return false;
            }
        }


        return true;
    }

}
