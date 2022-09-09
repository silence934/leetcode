package xyz.nyist.writerTest.meituan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author : silence
 * @Date: 2021-03-13 16:16
 * @Description :
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 小美过冬之前将很多数藏进一个仅包含小写英文字母的字符串。在冬天她想将所有数找回来，请帮帮她。
 * <p>
 * 给定一个字符串s，仅包含小写英文字母和数字，找出其中所有数。一个数是指其中一段无法延伸的连续数字串。如a1254b中仅包含1254这一个数，125则不是，因为125还可以向右延伸成1254。如果该字符串包含前导零，则抹掉前导零。
 * <p>
 * 例如a0125b1c0d00中包含四个数0125，1，0，00，按照规则抹掉前导零后，最终这个字符串包含的四个数为125，1，0，0。即，0125->125，00->0，其中1和0无前导零，无需变更。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入一行，一个仅包含小写英文字母和数字的字符串s。
 * <p>
 * 1≤s的长度≤1010
 * <p>
 * 输出描述
 * 输出若干行，表示找到的所有数。按从小到大的顺序输出。
 * <p>
 * <p>
 * 样例输入
 * He15l154lo87wor7l87d
 * 样例输出
 * 7
 * 15
 * 87
 * 87
 * 154
 */
public class Test7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                int start = i;
                for (; i < chars.length; i++) {
                    if (!(chars[i] >= '0' && chars[i] <= '9')) {
                        break;
                    }
                }
                String number = str.substring(start, i);
                list.add(Integer.valueOf(number));
            }
        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
