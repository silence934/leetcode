package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: fucong
 * @Date: 2022/3/15 16:10
 * @Description:
 */
public class Solution24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode t = head.next;

        ListNode n = head.next.next;

        t.next = head;
        head.next = swapPairs(n);
        return t;
    }

}
