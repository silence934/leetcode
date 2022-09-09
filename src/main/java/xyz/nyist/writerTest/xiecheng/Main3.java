package xyz.nyist.writerTest.xiecheng;

import java.util.Scanner;

/**
 * @Author : silence
 * @Date: 2021-03-04 19:49
 * @Description :
 */
public class Main3 {

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static int maxAmount(int[] packets, int n) {
        int len = packets.length;
        int end = len - n;
        int res = 0, second = packets[end];
        for (int i = 0; i < end; i++) {
            res += packets[i];
        }

        while (res > second) {
            end--;
            res -= packets[end];
            second += packets[end];
        }

        return res;
    }

    /******************************结束写代码******************************/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] packets = stringToIntegerArray(in.nextLine().trim());
        int n = Integer.parseInt(in.nextLine().trim());

        int res = maxAmount(packets, n);
        System.out.println(res);
    }

    public static int[] stringToIntegerArray(String in) {
        in = in.trim();
        in = in.substring(1, in.length() - 1);
        if (in.length() == 0) {
            return new int[0];
        }

        String[] arr = in.split(",");
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            out[i] = Integer.parseInt(arr[i].trim());
        }
        return out;
    }
}
//[1,2,3,4,5,6,7,8,9]
//5
