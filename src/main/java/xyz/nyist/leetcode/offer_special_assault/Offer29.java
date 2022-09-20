package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer29 {

    class Node {

        public int val;

        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }

    }


    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }

        Node res = head;

        while (head.next != res) {

            if (head.val > head.next.val) {
                if (head.val < insertVal || head.next.val > insertVal) {
                    break;
                }
            }

            if (head.val <= insertVal && insertVal <= head.next.val) {
                break;
            }

            head = head.next;
        }
        head.next = new Node(insertVal, head.next);

        return res;
    }

}
