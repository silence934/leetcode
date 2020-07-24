package xyz.nyist.topic;

import xyz.nyist.entity.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 小强有一天想去郊区玩，但是路上会经过一片山路，山路可以看作是一个N*M的网络，每个网格代表一个区域，山路崎岖不平，每一个区域都有一个会消耗的体力值。小强在走山路的时候，只能从一个区域走到相邻的4个区域中的任意一个。每到一个区域，会消耗对应的体力值。小强初始位置在第1行上方，需要去到第N行下方。
 * 小强想找一种走法，使得经过山路的总体力值消耗最小，请你帮小强找到这么一条路，并输出最小的总体力值消耗。
 * <p>
 * 输入：数字N，M，分别代表行数和列数；N行M列个数字，表示ij区域的体力值。
 * 输出：最小总体力值消耗。
 * @Date:Create：in 2020/4/25 19:32
 */
public class Test8 {
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

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            List<Temp> s = new ArrayList<>(), u = new ArrayList<>();
            s.add(new Temp(k, map[0][k]));
            List<Integer> first = new ArrayList<>();
            for (Element element : p.get(k)) {
                first.add(element.getPoint());
                u.add(new Temp(element.getPoint(), map[0][k] + element.getLength()));
            }
            for (int i = 1; i < n * m; i++) {
                if (!first.contains(i)) {
                    u.add(new Temp(i, Integer.MAX_VALUE));
                }
            }

            while (!u.isEmpty()) {
                Temp t = getMin(u);
                s.add(t);
                List<Element> elements = p.get(t.point);
                for (Temp temp : u) {
                    for (Element element : elements) {
                        if (temp.point == element.getPoint() && temp.length > element.getLength() + t.length) {
                            temp.length = element.getLength() + t.length;
                        }
                    }
                }
            }

            List<Integer> len = new ArrayList<>(n);
            for (Temp temp : s) {
                if (temp.point >= (m - 1) * n) {
                    len.add(temp.length);
                }
            }
            System.out.println(k + ":" + Collections.min(len));
            min = Math.min(min, Collections.min(len));
        }

        System.out.println(min);
    }

    private static List<Element> get(int x, int y) {
        List<Element> list = new ArrayList<>();
        if (x - 1 > -1) {
            list.add(new Element((x - 1) * n + y, map[x - 1][y]));
        }
        if (x + 1 < m) {
            list.add(new Element((x + 1) * n + y, map[x + 1][y]));
        }
        if (y - 1 > -1) {
            list.add(new Element(x * n + y - 1, map[x][y - 1]));
        }
        if (y + 1 < n) {
            list.add(new Element(x * n + y + 1, map[x][y + 1]));
        }
        return list;
    }

    private static Temp getMin(List<Temp> list) {
        int i = 0;
        int min = list.get(0).length;
        for (int j = 1; j < list.size(); j++) {
            if (list.get(j).length < min) {
                i = j;
            }
        }
        return list.remove(i);
    }

    static class Temp {
        int point;
        int length;

        public Temp(int point, int length) {
            this.point = point;
            this.length = length;
        }

        @Override
        public String toString() {
            return "Temp{" +
                    "point=" + point +
                    ", length=" + length +
                    '}';
        }
    }
}
