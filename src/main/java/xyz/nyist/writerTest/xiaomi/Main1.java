package xyz.nyist.writerTest.xiaomi;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author : silence
 * @Date: 2020-09-15 18:50
 * @Description :给定一个只包括'(',')','{','}','[',']' 的字符串,判断字符串是否有效。
 * <p>
 * 有效字符串需满足:
 * <p>
 * 1.左括号必须用相同类型的右括号闭合。
 * <p>
 * 2. 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        while (!Objects.equals(s = scanner.nextLine(), "\n")) {
            System.out.println(check(s));
        }
    }

    public static boolean check(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char value : ch) {
            if (value == ' ') {
                continue;
            }
            if (value == '(' || value == '{' || value == '[') {
                stack.add(value);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (value == ')' && c != '(') {
                    return false;
                } else if (value == '}' && c != '{') {
                    return false;
                } else if (value == ']' && c != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
