package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/9/23 13:48
 * @Description:
 */
public class Solution707 {


    //["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
    //[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]

    public static void main(String[] args) {
        Solution707 solution707 = new Solution707();
        solution707.addAtHead(2);
        solution707.deleteAtIndex(1);
        solution707.addAtHead(2);

        System.out.println(solution707.head);
        solution707.addAtHead(7);
        solution707.addAtHead(3);
        solution707.addAtHead(2);
        solution707.addAtHead(5);

        solution707.addAtTail(5);

        System.out.println(solution707.head);
        System.out.println(solution707.get(5));


    }

    Node head;

    Node tail;

    int size;

    public Solution707() {
        this.size = 0;
    }

    public int get(int index) {
        System.out.println(head.toString());
        Node node = find(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        size++;
        if (head == null) {
            head = new Node(val);
            tail = head;
            return;
        }
        head.pre = new Node(val);
        head.pre.next = head;
        head = head.pre;
    }

    public void addAtTail(int val) {
        size++;
        if (head == null) {
            head = new Node(val);
            tail = head;
            return;
        }
        tail.next = new Node(val);
        tail.next.pre = tail;
        tail = tail.next;
    }

    public void addAtIndex(int index, int val) {
        if (index <= 0) {
            addAtHead(val);
            return;
        } else if (index == size) {
            addAtTail(val);
            return;
        }
        Node node = find(index);
        if (node == null) {
            return;
        }

        size++;
        Node pre = node.pre;

        node.pre = new Node(val);
        node.pre.next = node;

        node.pre.pre = pre;
        if (pre != null) {
            pre.next = node.pre;
        }
    }

    public void deleteAtIndex(int index) {
        Node node = find(index);

        if (node == null) {
            return;
        }
        size--;
        Node pre = node.pre;
        Node next = node.next;
        if (pre == null && next == null) {
            head = null;
            tail = null;
        } else if (pre == null) {
            next.pre = null;
            head = next;
        } else if (next == null) {
            pre.next = null;
            tail = pre;
        } else {
            pre.next = next;
            next.pre = pre;
        }
    }


    private Node find(int index) {
        if (index >= size || index < 0) {
            return null;
        }

        Node res;
        if (index > size / 2) {
            index = size - index - 1;
            res = tail;
            while (index > 0) {
                index--;
                res = res.pre;
            }
        } else {
            res = head;
            while (index > 0) {
                index--;
                res = res.next;
            }
        }

        return res;
    }


    private class Node {

        int val;

        Node pre;

        Node next;


        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

    }

}
