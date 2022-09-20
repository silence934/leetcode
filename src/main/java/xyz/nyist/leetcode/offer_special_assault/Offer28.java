package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer28 {

    public Node flatten(Node head) {
        Node res = head;

        Node next;
        while (head != null) {
            next = head.next;
            if (head.child != null) {
                Node child = head.child;
                head.child = null;
                Node flatten = flatten(child);
                head.next = flatten;
                flatten.prev = head;
                while (head.next != null) {
                    head = head.next;
                }
                if (next != null) {
                    head.next = next;
                    next.prev = head;
                }

            }
            head = head.next;
        }

        return res;
    }


    class Node {

        public int val;

        public Node prev;

        public Node next;

        public Node child;

    }

}
