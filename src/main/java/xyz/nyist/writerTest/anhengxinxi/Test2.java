package xyz.nyist.writerTest.anhengxinxi;

import java.util.Scanner;

/**
 * @Author : silence
 * @Date: 2020-08-23 10:33
 * @Description :
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int t = 0;
        for (int i = start; i < end; i++) {
            if (isH(i) && isS(i)) {
                t++;
            }
        }
        System.out.println(t);
    }

    private static boolean isH(int i) {
        String str = String.valueOf(i);
        char[] chars = str.toCharArray();
        int s = 0, e = chars.length - 1;
        while (s < e) {
            if (chars[s++] != chars[e--]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isS(int i) {
        if (i == 1) {
            return true;
        }
        for (int j = 2; j < i / 2; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
