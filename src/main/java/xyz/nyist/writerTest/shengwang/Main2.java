package xyz.nyist.writerTest.shengwang;

import java.util.Scanner;

/**
 * @Author : fucong
 * @Date: 2021-03-27 15:27
 * @Description :
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toCharArray();

        int[] map = new int[128];
        for (char c : chars) {
            map[c]++;
        }

        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                map[i] = -1;
            }
        }

        for (char c : chars) {
            if (map[c] == -1) {
                System.out.println(c);
                return;
            }
        }


    }
}
