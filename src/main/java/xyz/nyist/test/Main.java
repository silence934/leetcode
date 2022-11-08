package xyz.nyist.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/10/31 20:27
 * @Description:
 */
public class Main {

    // n=n-1 + n-2
    //

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put(0, 0);
        map.put(1, 1);
        System.out.println(find(10));
    }


    private static int find(int i) {
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int res = find(i - 1) + find(i - 2);
        map.put(i, res);

        return res;
    }


}
