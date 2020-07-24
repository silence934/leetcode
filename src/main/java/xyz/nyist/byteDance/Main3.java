package xyz.nyist.byteDance;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/17 20:26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long x = in.nextInt();
        long f = in.nextInt();
        long d = in.nextInt();
        long p = in.nextInt();
        if (d / x < f) {
            System.out.println(d / x);
            return;
        }
        d += f * p;
        x += p;
        System.out.println(d / x);

    }
}
