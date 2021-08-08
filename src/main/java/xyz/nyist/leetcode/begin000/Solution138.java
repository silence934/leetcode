package xyz.nyist.leetcode.begin000;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: fucong
 * @Date: 2021/7/22 11:23
 * @Description:
 */
public class Solution138 {

    public static void main(String[] args) {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);
        node0.next = node1;
        node0.random = null;
        node1.next = node2;
        node1.random = node0;
        node2.next = node3;
        node2.random = node4;
        node3.next = node4;
        node3.random = node2;
        node4.random = node0;
        Node node = new Solution138().copyRandomList(node0);
        System.out.println(node);
        System.out.println();
    }

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (map.get(head) != null) {
            return map.get(head);
        }

        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }


    private static class Node {

        int val;

        Node next;

        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "(" + val + "," + (random != null ? random.val : null) + ")=>" + next;
        }

    }

}
