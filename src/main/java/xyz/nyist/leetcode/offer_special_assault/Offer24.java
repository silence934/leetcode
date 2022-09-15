package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer24 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        head.next = null;

        ListNode res = reverseList(next);

        next.next = head;
        return res;
    }

}
