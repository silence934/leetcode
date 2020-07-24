package xyz.nyist.map;

import java.util.LinkedHashMap;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/2 21:06
 */
public class MapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    private int a;

    public static void main(String[] args) {

       /* HashMap<Integer, DateTest> map = new HashMap<>(16);
        map.put(1, new DateTest(1, "张三"));
        map.put(2, new DateTest(2, "李四"));
        System.out.println(map);
        DateTest dateTest = map.get(1);
        dateTest.setName("你爸爸");
        System.out.println(map);
        *//*---------------------------------------*//*
        MyMap<Integer, String> myHashMap = new MyHashMap<>(1);
        myHashMap.put(1, "儿子");
        System.out.println(myHashMap.get(1));
        // myHashMap.remove(1);
        myHashMap.put(2, "孙子");
        System.out.println(myHashMap.get(2));
        System.out.println(myHashMap);*/


        LinkedHashMap<Integer, String> myHashMap = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            myHashMap.put(i * 16 + 1, "儿子");
        }
        System.out.println(myHashMap);

    }


}
