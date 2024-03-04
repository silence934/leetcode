package xyz.nyist.leetcode.begin200;

import java.util.LinkedList;

public class Solution232 {
    class MyQueue {

        private LinkedList<Integer> list1;
        private LinkedList<Integer> list2;

        public MyQueue() {
            list1 = new LinkedList<>();
            list2 = new LinkedList<>();
        }

        public void push(int x) {
            while (!list1.isEmpty()) {
                list2.addFirst(list1.removeFirst());
            }
            list1.addFirst(x);
            while (!list2.isEmpty()) {
                list1.addFirst(list2.removeFirst());
            }
        }

        public int pop() {
            return list1.removeFirst();
        }

        public int peek() {
            return list1.getFirst();
        }

        public boolean empty() {
            return list1.isEmpty();
        }
    }
}
