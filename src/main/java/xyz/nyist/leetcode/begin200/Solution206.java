package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/6/29 22:28
 * @Description:
 */
public class Solution206 {


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


}
