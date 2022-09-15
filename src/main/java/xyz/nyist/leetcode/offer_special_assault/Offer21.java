package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.ListNode;

import java.io.IOException;

/**
 * @author: silence
 * @Date: 2022/9/14 15:06
 * @Description:
 */
public class Offer21 {

    public static void main(String[] args) throws IOException {

    }

    private int n;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        return removeNthFromEnd(head);
    }

    private ListNode removeNthFromEnd(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next);

        if (--n == 0) {
            return head.next;
        }

        return head;
    }

}
