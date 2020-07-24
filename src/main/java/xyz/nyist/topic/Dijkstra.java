package xyz.nyist.topic;

import xyz.nyist.entity.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description: 算法步骤：
 * <p>
 * 　　a.初始时，S只包含源点，即S＝{vs}，vs的距离为0。U包含除vs外的其他顶点，即U={其余顶点}，若u不是vs的出边邻接点，则<u,vs>权值为∞；
 * <p>
 * 　　b.从U中选取一个距离vs最小的顶点k，把k加入S中（该选定的距离就是vs到k的最短路径长度min）；
 * <p>
 * 　　c.以k为新考虑的中间点，修改U中各顶点的距离；若从源点vs到顶点u的距离（经过顶点k）比原来距离（不经过顶点k）短，则修改顶点u的距离值，即dist[u] = min( dist[u], min + w[k][u] )；
 * <p>
 * 　　d.重复步骤b和c直到所有顶点都包含在S中。
 * @Date:Create：in 2020/4/24 17:55
 */
public class Dijkstra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        List<List<Element>> map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 0; i < b; i++) {
            int x1 = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int l = sc.nextInt();
            List<Element> lst = map.get(x1);
            lst.add(new Element(y, l));
            lst = map.get(y);
            lst.add(new Element(x1, l));
        }
        System.out.println(map);


        List<Temp> s = new ArrayList<>(n), u = new ArrayList<>(n);
        s.add(new Temp(0, 0));
        List<Element> list = map.get(0);
        List<Integer> first = new ArrayList<>();
        for (Element element : list) {
            first.add(element.getPoint());
            u.add(new Temp(element.getPoint(), element.getLength()));
        }
        for (int i = 1; i < n; i++) {
            if (!first.contains(i)) {
                u.add(new Temp(i, Integer.MAX_VALUE));
            }
        }

        System.out.println(s);
        System.out.println(u);


        while (!u.isEmpty()) {
            Temp t = getMin(u);
            s.add(t);
            List<Element> elements = map.get(t.point);
            for (Temp temp : u) {
                for (Element element : elements) {
                    if (temp.point == element.getPoint() && temp.length > element.getLength() + t.length) {
                        temp.length = element.getLength() + t.length;
                    }
                }
            }
        }

        System.out.println(s);
        System.out.println(u);
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
