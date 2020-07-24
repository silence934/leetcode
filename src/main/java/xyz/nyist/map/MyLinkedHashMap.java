package xyz.nyist.map;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/4/7 17:18
 */
public class MyLinkedHashMap<K, V> extends MyHashMap<K, V> implements MyMap<K, V> {

    static class Entry<K, V> extends Node<K, V> {
        Entry<K, V> before, after;

        Entry(int hash, K key, V value, Node<K, V> next) {
            super(hash, key, value, next);
        }
    }
}
