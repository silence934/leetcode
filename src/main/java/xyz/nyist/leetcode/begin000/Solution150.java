package xyz.nyist.leetcode.begin000;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Solution150 {


    int index;

    public int evalRPN(String[] tokens) {
        index = tokens.length - 1;
        return evalRPN1(tokens);
    }


    public int evalRPN1(String[] tokens) {
        String str = tokens[index];
        switch (str) {
            case "+": {
                index--;
                int right = evalRPN1(tokens);
                index--;
                int left = evalRPN1(tokens);
                return right + left;
            }
            case "-": {
                index--;
                int right = evalRPN1(tokens);
                index--;
                int left = evalRPN1(tokens);
                return left - right;
            }
            case "*": {
                index--;
                int right = evalRPN1(tokens);
                index--;
                int left = evalRPN1(tokens);
                return right * left;
            }
            case "/": {
                index--;
                int right = evalRPN1(tokens);
                index--;
                int left = evalRPN1(tokens);
                return left / right;
            }
            default: {
                return Integer.parseInt(str);
            }
        }
    }

}
