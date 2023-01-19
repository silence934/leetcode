package xyz.nyist.leetcode.begin1800;

public class Solution2299 {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        String s = "!@#$%^&*()-+";

        boolean b1 = false, b2 = false, b3 = false, b4 = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (i > 0 && c == password.charAt(i - 1)) {
                return false;
            }
            if (Character.isLowerCase(c)) {
                b1 = true;
            } else if (Character.isUpperCase(c)) {
                b2 = true;
            } else if (Character.isDigit(c)) {
                b3 = true;
            } else if (s.contains("" + c)) {
                b4 = true;
            }
        }

        return b1 && b2 && b3 && b4;
    }
}
