package xyz.nyist.writerTest.huawei;

import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2021/9/21 20:08
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        String str = String.valueOf(m);
        int n = str.length();

        int res = 0;

        //上一次最大损失多少钱
        int pre = 0;
        for (int i = n - 1; i > -1; i--) {
            //第几位
            int index = n - i - 1;
            int value = Integer.parseInt("" + str.charAt(i));
            //要损失的大钱
            int big = (int) Math.pow(10, index);
            //要损失的小钱
            int s = value > 4 ? (value - 1) * pre : value * pre;
            res += (s + (value > 4 ? big : 0));
            //最多损失
            pre = 9 * pre + big;

        }

        System.out.println(m - res);
    }

}
