package xyz.nyist.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 深度优先
 * @Date:Create：in 2020/4/23 20:45
 */
public class Test5 {
    private static boolean[] vis;
    private static List<List<Integer>> map;
    private static int depth = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        vis = new boolean[n];
        map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            List<Integer> lst = map.get(x);
            lst.add(y);
            lst = map.get(y);
            lst.add(x);
        }
        dfs(1, 0);
        System.out.println(2 * (n - 1) - depth);
    }

    private static void dfs(int i, int d) {
        depth = Math.max(depth, d);
        // System.out.print(i + " ==> ");
        vis[i - 1] = true;
        for (int t : map.get(i - 1)) {
            if (!vis[t]) {
                dfs(t + 1, d + 1);
            }
        }
    }
}
