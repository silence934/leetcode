package xyz.nyist.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Computer {
    public static final String MUL = "*";
    public static final String DIV = "/";
    public static final String ADD = "+";
    public static final String SUB = "-";
    public static final String POW = "^";
    public static final String LEFT_BRACKET = "(";
    public static final String RIGHT_BRACKET = ")";
    public static final List<String> OPERATOR = Arrays.asList("*", "/", "+", "-", "^");
    public static final List<String> OPERATOR_HAS_BRACKET = Arrays.asList("(", ")", "*", "/", "+", "-", "^");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入(表达式中不要加空格):");
        String str = input.nextLine();
        compute(str);
    }


    public static void compute(String expression) {
        String[] arr = strToExpressionArr(expression);
        /*System.out.println("数组类型: ");
        System.out.println(Arrays.toString(arr));*/
        if (isLegalExpression(arr)) {
            System.out.println("表达式合法,结果:");
            System.out.printf("%.2f%n", compute(arr));
        }
        else {
            System.out.println("非法表达式");
        }
    }

    //把表达式转换为数组
    private static String[] strToExpressionArr(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) < '0' || str.charAt(i) > '9') && str.charAt(i) != '.') {
                sb.append("#").append(str.charAt(i)).append("#");
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        List<String> list = Arrays.asList(sb.toString().split("#"));
        return list.stream().filter(i -> !"".equals(i)).toArray(String[]::new);
    }

    //计算算术表达式
    private static Double compute(String[] expression) {
        Stack<Double> numStack = new Stack<>();
        Stack<String> opStack = new Stack<>();

        for (String ele : expression) {
            //如果是数字，进入数字栈
            if (isNumber(ele)) {
                numStack.push(new Double(ele));
            }
            //遇到加减号，把栈顶的符号都处理完，直到遇到（左括号和栈空情况，最后把提取到的符号压入栈
            else if (ADD.equals(ele) || SUB.equals(ele)) {
                while (!opStack.isEmpty() && !isLeftBracket(opStack.peek())) {
                    Double b = numStack.pop();
                    Double a = numStack.pop();
                    numStack.push(getAnswer(a, opStack.pop(), b));
                }


                opStack.push(ele);
            }
            //遇到乘除号，把前面的乘除号处理完，最后把提取到的符号压入栈
            else if (MUL.equals(ele) || DIV.equals(ele)) {
                while (!opStack.isEmpty() && !isLeftBracket(opStack.peek()) && !ADD.equals(opStack.peek()) && !SUB.equals(opStack.peek())) {
                    Double b = numStack.pop();
                    Double a = numStack.pop();
                    numStack.push(getAnswer(a, opStack.pop(), b));
                }


                opStack.push(ele);
            }
            else if (POW.equals(ele)) {
                while (!opStack.isEmpty() && POW.equals("" + opStack.peek())) {
                    Double b = numStack.pop();
                    Double a = numStack.pop();
                    numStack.push(getAnswer(a, opStack.pop(), b));
                }


                opStack.push(ele);
            }
            //遇到左括号，只进栈
            else if (isLeftBracket(ele)) {
                opStack.push(ele);
            }
            //遇到右括号，只处理栈顶全部符号
            else if (isRightBracket(ele)) {
                while (!opStack.isEmpty() && !isLeftBracket(opStack.peek())) {
                    Double b = numStack.pop();
                    Double a = numStack.pop();
                    numStack.push(getAnswer(a, opStack.pop(), b));
                }

                if (!opStack.isEmpty() && isLeftBracket(opStack.peek())) {
                    opStack.pop();
                }
            }
        }

        //最后没有以右括号结尾的表达式还得另外把剩下的符号处理完
        while (!opStack.isEmpty()) {
            Double b = numStack.pop();
            Double a = numStack.pop();
            numStack.push(getAnswer(a, opStack.pop(), b));
        }
        return numStack.peek();
    }

    //运算
    private static Double getAnswer(Double a, String operator, Double b) {
        switch (operator) {
            case ADD:
                return a + b;
            case SUB:
                return a - b;
            case MUL:
                return a * b;
            case DIV:
                return a / b;
            case POW:
                return Math.pow(a, b);
            default:
                return 0.0;
        }
    }

    //否合法
    static boolean isLegalExpression(String[] arr) {
        //开头和结尾不能是运算符
        String start = arr[0];
        String end = arr[arr.length - 1];
        if (OPERATOR.contains(start) || OPERATOR.contains(end)) {
            return false;
        }
        //括号和非法字符校验
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (isNumber(arr[i])) {
                if (i > 0 && !OPERATOR_HAS_BRACKET.contains(arr[i - 1])) {
                    //左边是否有符号
                    return false;
                }
                if (i < arr.length - 1 && !OPERATOR_HAS_BRACKET.contains(arr[i + 1])) {
                    //右边有没有符号
                    return false;
                }
            }
            else if (OPERATOR.contains(arr[i])) {
                if (i > 0 && (!isNumber(arr[i - 1]) && !isBracket(arr[i - 1]))) {
                    return false;
                }
                if (i < arr.length - 1 && (!isNumber(arr[i + 1]) && !isBracket(arr[i + 1]))) {
                    return false;
                }
            }
            else if (isLeftBracket(arr[i])) {
                stk.push(arr[i]);
            }
            else if (isRightBracket(arr[i])) {
                if (stk.isEmpty()) {
                    return false;
                }
                stk.pop();
            }
        }

        return stk.isEmpty();
    }

    //判断是否是数字
    private static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

    public static boolean isLeftBracket(Object o) {
        if (o instanceof String) {
            return LEFT_BRACKET.equals(((String) o).trim());
        }
        else if (o instanceof Character) {
            return LEFT_BRACKET.equals("" + o);
        }
        return false;
    }

    public static boolean isRightBracket(Object o) {
        if (o instanceof String) {
            return RIGHT_BRACKET.equals(o);
        }
        else if (o instanceof Character) {
            return RIGHT_BRACKET.equals("" + o);
        }
        return false;
    }

    public static boolean isBracket(Object o) {
        return isLeftBracket(o) || isRightBracket(o);
    }
}
