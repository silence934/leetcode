package xyz.nyist.leetcode.offer2;

import xyz.nyist.utils.ListNode;

/**
 * @author: fucong
 * @Date: 2022/3/18 14:28
 * @Description:
 */
public class Solution26 {

    public void reorderList(ListNode head) {


        ListNode v = new ListNode(0);
        v.next = head;

        ListNode l = v, r = v;
        while (r != null && r.next != null) {
            r = r.next.next;
            l = l.next;
        }

        ListNode next = l.next;
        l.next = null;

        next = reverseList(next);


        ListNode tem = head;

        while (tem != null && next != null) {
            ListNode t = next;
            next = next.next;

            t.next = tem.next;

            tem.next = t;
            tem = tem.next.next;
        }

    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return res;
    }

}
