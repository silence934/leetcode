package xyz.nyist.topic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Test4 {
    private static int n;
    private static int[][] map;
    private static int[] a;
    private static int p = 0;
    private static int c = -1;
    private static int d = 0;
    private static List<Integer> asd = new ArrayList<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            map = new int[n][n];
            a = new int[n];
            for (int i = 1; i < n; i++) {
                int x = scanner.nextInt() - 1;
                int y = scanner.nextInt() - 1;
                map[x][y] = 1;
                map[y][x] = 1;
            }
            //print();
            depthFirstSearch(1);
            //System.out.println();
            System.out.println(2 * (n - 1) - Collections.max(asd) + 1);
        } catch (Exception e) {
            System.out.println("错误");
        }
    }

    private static void depthFirstSearch(int t) {
        try {
            if (!hasVal(t)) {
                c = p;
                a[p++] = t;
                d++;
            }
            // System.out.print(t + " ==> ");
            for (int i = 0; i < n; i++) {
                if (map[t - 1][i] == 1 && !hasVal(i + 1)) {
                    depthFirstSearch(i + 1);
                }
            }
            if (c == 0) {
                return;
            }
            asd.add(d--);
            depthFirstSearch(a[--c]);
        } catch (Exception e) {
            System.out.println("错误");
        }
    }

    private static boolean hasVal(int v) {
        try {
            for (int i = 0; i < n; i++) {
                if (a[i] == v) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("错误");
        }
        return false;
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
