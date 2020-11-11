package xyz.nyist.writerTest.xunfei;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/9/12 20:01
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        n = n % s.length();
        System.out.println(s.substring(n) + s.substring(0, n));

    }
}
