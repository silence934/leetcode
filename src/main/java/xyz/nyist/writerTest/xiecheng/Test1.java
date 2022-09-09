package xyz.nyist.writerTest.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author : silence
 * @Date: 2020-08-15 18:56
 * @Description : 携程笔试
 * 天会SOHO最近正在进行道路建设，现在有充足的长度为a和长度为b的两种规格的瓷砖。
 * <p>
 * 现在从这些瓷砖中任取k块来铺路，请按递增的顺序输出所有可能的铺成道路的长度。
 * <p>
 * <p>
 * <p>
 * 输入描述
 * 输入为3个数，每行1个数，第一个数表示a，第二个数表示b，第三个数表示k。
 * <p>
 * a和b均为正整数，0 <= k <= 100000
 * <p>
 * 输出描述
 * 输出的结果为一个数组，数组中的值从小到大排列，如：[3,4,5,6]。如果数组为空则输出为[]，如果有相同的结果去除重复的。
 * <p>
 * <p>
 * 样例输入
 * 1
 * 2
 * 3
 * 样例输出
 * [3,4,5,6]
 */
public class Test1 {
    static List<Integer> divingBoard(int a, int b, int k) {
        int min = Math.min(a, b);
        int dis = Math.abs(a - b);
        List<Integer> list = new ArrayList<>();
        if (k == 0) {
            return list;
        }
        if (dis == 0) {
            list.add(min * k);
            return list;
        }
        min = min * k;
        for (int i = 0; i <= k; i++) {
            list.add(min + i * dis);
        }
        return list;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        System.out.println(divingBoard(_a, _b, _k));
    }
}
