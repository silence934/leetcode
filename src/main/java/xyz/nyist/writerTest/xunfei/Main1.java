package xyz.nyist.writerTest.xunfei;

import java.util.*;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/9/12 19:01
 */
public class Main1 {

    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<>((int) ((m + n) / 0.75));
        List<Integer> list = new ArrayList<>(m + n);

        for (int i = 0; i < n * m; i++) {
            int t = scanner.nextInt();
            if (map.size() < m + n) {
                list.add(t);
                map.put(t, i);
            }
            else {
                Collections.sort(list);
                if (list.get(0) < t) {
                    map.remove(list.get(0));
                    map.put(t, i);
                    list.set(0, t);
                }
            }
        }

        long max = -1;
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (!is(map.get(list.get(i)), map.get(list.get(j)))) {
                    long x = list.get(i);
                    max = Math.max(max, x * list.get(j));
                }
            }
        }
        System.out.println(max);
    }

    private static boolean is(int x, int y) {
        int t = x / m * m;
        return Math.abs(x - y) % m == 0 || (t <= y && y <= t + m);


    }

    /*
3 3
1 2 3 4 5 6 7 8 9
    * */
}
