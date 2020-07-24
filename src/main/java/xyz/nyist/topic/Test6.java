package xyz.nyist.topic;

import java.util.*;

/**
 * @Author: silence
 * @Description: 广度优先
 * @Date:Create：in 2020/4/23 20:45
 */
public class Test6 {
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

        class Element {
            private int point;
            private int deep;

            private Element(int point, int deep) {
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

        Queue<Element> queue = new LinkedList<>();
        queue.add(new Element(0, 0));
        vis[0] = true;

        while (!queue.isEmpty()) {
            Element element = queue.poll();
            depth = Math.max(depth, element.deep);
            List<Integer> lists = map.get(element.point);
            if (lists.isEmpty()) {
                continue;
            }
            for (int i : lists) {
                if (!vis[i]) {
                    vis[i] = true;
                    queue.add(new Element(i, element.deep + 1));
                    // System.out.println(queue);
                }
            }
        }
        System.out.println(2 * (n - 1) - depth);
    }

}
