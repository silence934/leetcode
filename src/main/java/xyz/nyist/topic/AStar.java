package xyz.nyist.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 1. 把起点加入 open list 。
 * <p>
 * 　　2. 重复如下过程：
 * <p>
 * 　　　　a. 遍历open list ，查找F值最小的节点，把它作为当前要处理的节点，然后移到close list中
 * <p>
 * 　　　　b. 对当前方格的 8 个相邻方格一一进行检查，如果它是不可抵达的或者它在close list中，忽略它。否则，做如下操作：
 * <p>
 * 　　　　□  如果它不在open list中，把它加入open list，并且把当前方格设置为它的父亲
 * <p>
 * 　　　　□  如果它已经在open list中，检查这条路径 ( 即经由当前方格到达它那里 ) 是否更近。如果更近，把它的父亲设置为当前方格，并重新计算它的G和F值。如果你的open list是按F值排序的话，改变后你可能需要重新排序。
 * <p>
 * 　　　　c. 遇到下面情况停止搜索：
 * <p>
 * 　　　　□  把终点加入到了 open list 中，此时路径已经找到了，或者
 * <p>
 * 　　　　□  查找终点失败，并且open list 是空的，此时没有路径。
 * @Date:Create：in 2020/4/25 8:52
 */
public class AStar {
    private static Element[][] map;
    private static int endX, endY, m, n;
    private static List<Element> open;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new Element[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = new Element(i, j);
            }
        }
        int x, y;
        while ((x = scanner.nextInt()) != -1) {
            y = scanner.nextInt();
            map[x][y].status = 1;
        }
        int startX = scanner.nextInt(), startY = scanner.nextInt();
        endX = scanner.nextInt();
        endY = scanner.nextInt();
        open = new ArrayList<>();
        Element start = map[startX][startY];
        start.status = 3;
        while (start.x > -1 && !(start.x == endX && start.y == endY)) {
            findAround(start);
            start = findNext();
            start.status = 3;
            System.out.print("(" + start.x + "," + start.y + "(" + start.g + "))==>");
        }
        Element element = map[endX][endY];
        System.out.println();
        while (element.parent != null) {
            System.out.print("(" + element.x + "," + element.y + ")<==");
            element = element.parent;
        }

    }

    private static void findAround(Element element) {
        int x = element.x, y = element.y;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int g = element.g + ((i == 0 || j == 0) ? 10 : 14);
                int h = (Math.abs(endY - y - i) + Math.abs(endX - x - j)) * 10;
                addOpen(new Element(x + j, y + i, g, h, g + h, element));
            }
        }

    }

    private static void addOpen(Element element) {
        element.status = 2;
        if (element.x < 0 || element.x >= n || element.y < 0 || element.y >= m) {
            return;
        }
        if (map[element.x][element.y].status == 0) {
            map[element.x][element.y] = element;
            open.add(element);

        }
        else if (map[element.x][element.y].status == 2) {
            if (map[element.x][element.y].f > element.f) {
                map[element.x][element.y].f = element.f;
            }
        }
    }

    private static Element findNext() {
        Element next = new Element(-1, -1);
        int j = -1;
        next.f = Integer.MAX_VALUE;
        for (int i = 0; i < open.size(); i++) {
            Element t = open.get(i);
            if (t.x == endX && t.y == endY) {
                open.remove(i);
                return t;
            }
            if (next.f > t.f) {
                next = open.get(i);
                j = i;
            }
        }
        if (j > -1) {
            open.remove(j);
        }
        return next;
    }

    private static class Element {
        //status   0正常  1不可通过 2：open  3：close
        int x, y, g, h, f, status = 0;
        Element parent;

        public Element() {
        }

        public Element(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Element(int x, int y, int g, int h, int f, Element parent) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
            this.f = f;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "x=" + x +
                    ", y=" + y +
                    ", g=" + g +
                    ", h=" + h +
                    ", f=" + f +
                    ", status=" + status +
                    '}';
        }
    }
}
