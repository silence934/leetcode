package xyz.nyist.writerTest.tongdun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Author : fucong
 * @Date: 2020-11-29 19:14
 * @Description :
 */
public class Main1 {

    public static void main(String[] args) {
        // [11,22,33,44,55,66,88,77,3,9,999,10000,3456]
        Main1 main1 = new Main1();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(11);
        input.add(22);
        input.add(33);
        input.add(44);
        input.add(55);
        input.add(66);
        input.add(88);
        input.add(77);
        input.add(3);
        input.add(9);
        input.add(999);
        input.add(10000);
        input.add(3456);
        System.out.println(main1.top10(input));
    }

    public ArrayList<Integer> top10(ArrayList<Integer> input) {
        Integer[] res = input.stream().limit(10).toArray(Integer[]::new);
        for (int i = 10; i < input.size(); i++) {
            Arrays.sort(res);
            if (input.get(i) > res[0]) {
                res[0] = input.get(i);
            }
        }
        Arrays.sort(res);
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, res);
        return list;
    }
}
