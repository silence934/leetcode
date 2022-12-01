package xyz.nyist.leetcode.begin1000;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/11/30 17:53
 * @Description:
 */
public class Solution1106 {

    public static void main(String[] args) {
        System.out.println(new Solution1106().parseBoolExpr("|(&(t,f,t),!(t))"));
    }


    public boolean parseBoolExpr(String expression) {
        if (expression.startsWith("t")) {
            return true;
        } else if (expression.startsWith("f")) {
            return false;
        } else {
            List<String> split = new ArrayList<>();
            for (int i = 2; i < expression.length() - 1; i++) {
                if (expression.charAt(i + 1) == '(') {
                    int k = 1;
                    int index = i + 2;
                    while (k != 0) {
                        if (expression.charAt(index) == '(') {
                            k++;
                        } else if (expression.charAt(index) == ')') {
                            k--;
                        }
                        index++;
                    }
                    split.add(expression.substring(i, index));
                    i = index;
                } else {
                    split.add(expression.substring(i, i + 1));
                    i++;
                }
            }

            if (expression.startsWith("&")) {
                for (String s : split) {
                    if (!parseBoolExpr(s)) {
                        return false;
                    }
                }
                return true;
            } else if (expression.startsWith("|")) {
                for (String s : split) {
                    if (parseBoolExpr(s)) {
                        return true;
                    }
                }
                return false;
            } else if (expression.startsWith("!")) {
                for (String s : split) {
                    return !parseBoolExpr(s);
                }
            }
        }

        return false;
    }
}
