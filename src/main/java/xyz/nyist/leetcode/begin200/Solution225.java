package xyz.nyist.leetcode.begin200;

import java.util.LinkedList;

public class Solution225 {
    class MyStack {

        private LinkedList<Integer> list1;
        private LinkedList<Integer> list2;

        public MyStack() {
            list1 = new LinkedList<>();
            list2 = new LinkedList<>();
        }

        public void push(int x) {
            while (!list1.isEmpty()) {
                list2.addFirst(list1.removeLast());
            }
            list1.addFirst(x);
            while (!list2.isEmpty()) {
                list1.addFirst(list2.removeLast());
            }
        }

        public int pop() {
            return list1.removeLast();
        }

        public int top() {
            return list1.getLast();
        }

        public boolean empty() {
            return list1.isEmpty();
        }
    }
}
