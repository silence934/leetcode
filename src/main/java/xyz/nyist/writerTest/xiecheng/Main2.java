package xyz.nyist.writerTest.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author : silence
 * @Date: 2021-03-04 19:04
 * @Description :
 * 给定一个表达式，求其计算结果。
 * <p>
 * 表达式的结构是这样的形式：(operator operand operand …)
 * <p>
 * 1、左右括号分别标志了表达式的开始和结束。
 * <p>
 * 2、operator是操作符，表示了计算规则，取值有三种:+-*，分别是加法、减法、乘法。
 * <p>
 * 3、operand是操作数，它既可以是一个整数，也可以是另一个表达式。操作数至少是两个。
 * <p>
 * 4、括号两边有0个或者多个空格。operator、operand之间有1个或者多个空格。
 * <p>
 * 计算规则如下：
 * <p>
 * 1、 如果operand是一个表达式，要先计算其值，再用该值参与运算。
 * <p>
 * 2、 如果operator是加法或者乘法，把所有operand相加或者相乘。
 * <p>
 * 3、 如果operator是减法，第一个operand是被减数，其他均为减数。
 * <p>
 * 下面几个例子演示了求值过程和结果：
 * <p>
 * (+ 3 4) => 7
 * <p>
 * (- 9 4 5) =>0
 * <p>
 * (- (* 4 5) 4 5) => (-20 4 5) => 11
 * <p>
 * (*(+2 3) (-100 (+ 20 10))) => (* 5 (-100 30)) => (* 5 (-100 30)) => (* 5 70)=> 350
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().trim();
        if (str.length() != 0) {
            Integer res = computer(str);
            if (res != null) {
                System.out.println(res);
            }
        }
    }


    public static Integer computer(String str) {
        char[] chars = str.toCharArray();

        int type = -1;
        List<Integer> operands = new ArrayList<>();
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i] == ' ') {
                continue;
            }
            if (chars[i] == '+') {
                type = 1;
            } else if (chars[i] == '-') {
                type = 2;
            } else if (chars[i] == '*') {
                type = 3;
            } else if (chars[i] == '(') {
                int start = i, end = i + 1;
                int index = 0;
                for (; i < chars.length - 1; i++) {
                    if (chars[i] == ')') {
                        index--;
                    } else if (chars[i] == '(') {
                        index++;
                    }
                    if (index == 0) {
                        end = i + 1;
                        break;
                    }
                }
                operands.add(computer(str.substring(start, end)));
            } else {
                int start = i, end = chars.length - 1;
                for (; i < chars.length - 1; i++) {
                    if (chars[i] == ' ') {
                        end = i;
                        break;
                    }
                }
                operands.add(new Integer(str.substring(start, end)));
            }
        }

        int res = 0;
        switch (type) {
            case 1: {
                for (Integer operand : operands) {
                    res += operand;
                }
                break;
            }
            case 2: {
                res = operands.get(0) * 2;
                for (Integer operand : operands) {
                    res -= operand;
                }
                break;
            }
            case 3: {
                res = 1;
                for (Integer operand : operands) {
                    res *= operand;
                }
                break;
            }
            default:
                return null;
        }

        return res;
    }

}
