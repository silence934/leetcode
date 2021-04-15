package xyz.nyist.writerTest.doxiaoman;

import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2021/4/11 16:32
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        sc.nextLine();
        char[] chars = sc.nextLine().toCharArray();

        int start = 0, tage = -1;

        int max = 0;
        for (int i = 0; i < n; i++) {

            int t = k;
            char c = chars[i];
            while (++i < n) {
                if (chars[i] != c && t == 0) {
                    break;
                } else if (chars[++i] != c) {
                    if (t == k) {
                        tage = i;
                    }
                    t--;
                }
            }
            max = Math.max(max, i - start);
            if (tage != -1) {
                i = tage - 1;
            }
            start = i;

        }

        System.out.println(max);

    }
}
