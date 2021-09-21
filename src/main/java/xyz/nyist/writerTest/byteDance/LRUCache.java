package xyz.nyist.writerTest.byteDance;

import java.util.*;

/**
 * @author: silence
 * @Date: 2021/7/8 21:04
 * @Description: 运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字-值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？需要注意线程安全问题
 */
public class LRUCache {

    private int capacity;

    //最近使用的排序
    private Set<Integer> queue;

    //k -> list 下标
    private Map<Integer, Integer> map;

    //存真正的数据
    private List<Integer> list;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        queue = new LinkedHashSet<>();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public int get(int key) {
        if (map.get(key) == null) {
            return -1;
        }
        test(key);
        return list.get(map.get(key));
    }


    public void put(int key, int value) {
        if (map.get(key) == null) {
            if (list.size() == capacity) {
                Integer oldIndex = queue.stream().findFirst().get();
                map.remove(oldIndex);
                queue.remove(oldIndex);

                map.put(key, oldIndex);
                queue.add(key);

                list.set(oldIndex, value);
            } else {
                list.add(value);
                map.put(key, list.size() - 1);
                queue.add(key);
            }
        } else {
            Integer index = map.get(key);
            list.set(index, value);
            test(index);
        }

    }


    private void test(int key) {
        queue.remove(key);
        queue.add(key);
    }


}
