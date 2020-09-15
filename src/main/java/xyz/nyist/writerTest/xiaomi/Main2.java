package xyz.nyist.writerTest.xiaomi;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2020-09-15 18:50
 * @Description :   去除重复字符  aab --> ab
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        byte[] hash = new byte[128];
        for (char c : chars) {
            if (hash[c] == 0) {
                System.out.print(c);
                hash[c] = 1;
            }
        }
    }
}
