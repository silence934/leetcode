package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/7/12 19:57
 * @Description:
 */
public class Solution19 {

    private int n;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        return removeNthFromEnd(head);
    }

    public ListNode removeNthFromEnd(ListNode head) {
        if (head == null) {
            return null;
        }
        head.next = removeNthFromEnd(head.next, n);
        if (--n == 0) {
            return head.next;
        } else {
            return head;
        }
    }

}
