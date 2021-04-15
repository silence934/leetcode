package xyz.nyist.writerTest.bianlifeng;

import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2021/4/9 18:11
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        byte[] map = new byte[32];
        String[] split = sc.nextLine().split(",");
        for (String str : split) {
            String[] split1 = str.split("-");
            for (int i = Integer.parseInt(split1[0]); i <= Integer.parseInt(split1[1]); i++) {
                map[i] = 1;
            }
        }
        Integer start = null, end = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            if (map[i] == 1) {
                if (start == null) {
                    start = i;
                } else {
                    end = i;
                }
            } else {
                if (end != null) {
                    sb.append(start).append("-").append(end).append(",");
                    start = null;
                    end = null;
                }
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));


    }
}
