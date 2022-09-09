package xyz.nyist.leetcode.begin400;

/**
 * @author: silence
 * @Date: 2021/9/27 15:39
 * @Description:
 */
public class Solution430 {


    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);

        node1.next = node2;
        node2.prev = node1;

        node2.next = node3;
        node3.prev = node2;

        node3.next = node4;
        node4.prev = node3;

        node4.next = node5;
        node5.prev = node4;

        node5.next = node6;
        node6.prev = node5;


        node7.next = node8;
        node8.prev = node7;

        node8.next = node9;
        node9.prev = node8;

        node9.next = node10;
        node10.prev = node9;

        node3.child = node7;


        node11.next = node12;
        node12.prev = node11;

        node8.child = node11;


        Solution430 solution430 = new Solution430();
        Node flatten = solution430.flatten(node1);
        while (flatten != null) {
            System.out.println(flatten);
            flatten = flatten.next;
        }

    }

    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node next = head.next;
        head.next = null;
        if (head.child != null) {
            Node node = flatten(head.child);
            head.child = null;
            node.prev = head;
            head.next = node;
        }

        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        Node flatten = flatten(next);
        node.next = flatten;
        if (flatten != null) {
            flatten.prev = node;
        }

        return head;
    }


    static class Node {

        public int val;

        public Node prev;

        public Node next;

        public Node child;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "-" + (prev != null ? +prev.val : null) + "-" + (next != null ? +next.val : null);
        }

    }

}
