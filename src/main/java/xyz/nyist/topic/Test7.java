package xyz.nyist.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 无向无环图 求遍历最短路径
 */
public class Test7 {

    private static List<List<Element>> map;
    private static boolean[] vis;
    private static long depth = 0L;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        vis = new boolean[n];
        map = new ArrayList<>(n);
        long total = 0L;
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int x1 = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int l = sc.nextInt();
            total += l;
            List<Element> lst = map.get(x1);
            lst.add(new Element(y, l));
            lst = map.get(y);
            lst.add(new Element(x1, l));
        }
        /*class Temp {
            private int point;
            private int deep;

            private Temp(int point, int deep) {
                this.point = point;
                this.deep = deep;
            }

            @Override
            public String toString() {
                return "Element{" +
                        "point=" + point +
                        ", deep=" + deep +
                        '}';
            }
        }
        Queue<Temp> queue = new LinkedList<>();
        queue.add(new Temp(x - 1, 0));
        vis[x - 1] = true;
        while (!queue.isEmpty()) {
            Temp temp = queue.poll();
            depth = Math.max(depth, temp.deep);
            List<Element> list = map.get(temp.point);
            for (Element element : list) {
                if (!vis[element.point]) {
                    vis[element.point] = true;
                    queue.add(new Temp(element.point, temp.deep + element.length));
                }
            }
        }*/
        dfs(x, 0);
       /* System.out.println();
        System.out.println(depth);*/
        System.out.println(2 * total - depth);
    }

    private static class Element {
        private int point;
        private int length;

        public Element(int point, int length) {
            this.point = point;
            this.length = length;
        }
    }

    private static void dfs(int i, int d) {
        //System.out.print(i + "(" + d + ")=>>");
        depth = Math.max(depth, d);
        vis[i - 1] = true;
        for (Element t : map.get(i - 1)) {
            if (!vis[t.point]) {
                dfs(t.point + 1, d + t.length);
            }
        }
    }
}
