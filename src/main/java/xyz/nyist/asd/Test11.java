package xyz.nyist.asd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/8/1 15:33
 */
public class Test11 {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            map.put(y - x, x);
        }

        Integer[] integers = map.keySet().toArray(new Integer[]{});
        Arrays.sort(integers);
        for (int i = total / map.get(integers[0]); i > -1; i--) {
            test(map, total - map.get(integers[0]) * i, integers, 1, (map.get(integers[0]) + integers[0]) * i);
        }
        System.out.println(max);
    }

    public static void test(Map<Integer, Integer> map, int total, Integer[] integers, int index, int t) {
        if (index == integers.length) {
            max = Math.max(max, t);
            return;
        }
        if (total < map.get(integers[index])) {
            test(map, total, integers, index + 1, t);
            return;
        }
        for (int i = total / map.get(integers[index]); i > -1; i--) {
            test(map, total - map.get(integers[index]) * i, integers, index + 1, t + (map.get(integers[index]) + integers[index]) * i);
        }
    }
}
