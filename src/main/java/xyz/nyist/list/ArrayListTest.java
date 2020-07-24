package xyz.nyist.list;

import java.util.*;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/6/7 20:50
 */
public class ArrayListTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        System.out.println(list1);
    }
}
