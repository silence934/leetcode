package xyz.nyist.writerTest.byteDance;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/14 18:49
 */
public class Main1 {
    //89 100 63 75 53;95 64 43 72        1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] s1 = str.split(";");
        String[] cla1 = s1[0].split(" ");
        String[] cla2 = s1[1].split(" ");
        String min1 = cla1[0];
        String min2 = cla2[0];
        for (int i = 1; i < cla1.length; i++) {
            if (Integer.parseInt(cla1[i]) < Integer.parseInt(min1)) {
                min1 = cla1[i];
            }
        }
        for (int i = 1; i < cla2.length; i++) {
            if (Integer.parseInt(cla2[i]) < Integer.parseInt(min2)) {
                min2 = cla2[i];
            }
        }
        System.out.println(Math.abs(Integer.parseInt(min1) - Integer.parseInt(min2)));
    }
}
