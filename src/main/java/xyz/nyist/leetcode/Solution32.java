package xyz.nyist.leetcode;

import java.util.Stack;

/**
 * @Author: silence
 * @Description: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/4 15:13
 */
public class Solution32 {

    public int longestValidParentheses1(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        char[] sa = s.toCharArray();
        for (int i = 0; i < sa.length; i++) {
            if (sa[i] == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }
                else {
                    max = Integer.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public int longestValidParentheses(String s) {
        if (s.length() < 2) {
            return 0;
        }
        char[] sa = s.toCharArray();
        int max = 0, t;
        int[] arr = new int[sa.length];
        if (sa[0] == '(' && sa[1] == ')') {
            max = arr[1] = 2;
        }
        for (int i = 2; i < sa.length; i++) {
            if (sa[i] == '(') {
                arr[i] = 0;
            }
            else {
                if (sa[i - 1] == '(') {
                    arr[i] = arr[i - 2] + 2;
                }
                else if ((t = i - 1 - arr[i - 1]) > -1 && sa[t] == '(') {
                    arr[i] = arr[i - 1] + 2 + (t > 1 ? arr[t - 1] : 0);
                }
                max = Math.max(max, arr[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        System.out.println(solution32.longestValidParentheses("()(())"));
    }
}
