package xyz.nyist.topic;

import xyz.nyist.entity.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 给一个 n*m 矩阵，每一个矩阵有一个值，初始时候位于左上角，每一次可以选择上下左右四个方向中的一个，
 * 并且可以移动的距离不大于 k ，且保证到达的格子的值要比当前位置的格子的值要大，否则不能移动到这个格子。
 * 当无法移动时，游戏结束。求在所有可能走的方案中，到达的位置的格子值相加总和最大是多少？
 * @Date:Create：in 2020/4/25 21:53
 */
public class Test9 {

    private static int m, n;
    private static int[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        List<List<Element>> p = new ArrayList<>(n * m);
        for (int i = 0; i < n * m; i++) {
            int x = i / n, y = i % n;
            p.add(get(x, y));
        }
    }

    private static List<Element> get(int x, int y) {
        List<Element> list = new ArrayList<>();
        int r = map[x][y];
        if (x - 1 > -1 && map[x - 1][y] > r) {
            list.add(new Element((x - 1) * n + y, map[x - 1][y]));
        }
        if (x + 1 < m && map[x + 1][y] > r) {
            list.add(new Element((x + 1) * n + y, map[x + 1][y]));
        }
        if (y - 1 > -1 && map[x][y - 1] > r) {
            list.add(new Element(x * n + y - 1, map[x][y - 1]));
        }
        if (y + 1 < n && map[x][y + 1] > r) {
            list.add(new Element(x * n + y + 1, map[x][y + 1]));
        }
        return list;
    }
}
