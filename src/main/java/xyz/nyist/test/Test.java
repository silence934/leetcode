package xyz.nyist.test;

import java.util.ArrayList;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/5/24 17:40
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(6);
        list.add(3);
        list.add(4);


        list.remove(1);

        System.out.println(list);

    }
}
