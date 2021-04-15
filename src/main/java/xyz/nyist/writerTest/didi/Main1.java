package xyz.nyist.writerTest.didi;

import java.util.*;

/**
 * @author: silence
 * @Date: 2021/4/10 19:57
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<Integer, LinkedList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();

            if (map.get(k) == null) {
                LinkedList<Integer> list = new LinkedList<>();
                list.add(v);
                map.put(k, list);
            } else {
                map.get(k).add(v);
            }

        }

       /* for (LinkedList<Integer> list : map.values()) {
            Collections.sort(list);
        }*/

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        int res = 0;

        for (Integer key : list) {

            res = Math.max(res, key);

            LinkedList<Integer> values = map.get(key);

            for (Integer value : values) {
                res += value;
            }

        }

        System.out.println(res);

    }
}
