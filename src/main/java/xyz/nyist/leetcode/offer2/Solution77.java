package xyz.nyist.leetcode.offer2;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/3/18 11:22
 * @Description: https://leetcode-cn.com/problems/7WHec2/
 */
public class Solution77 {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode l = head;
        ListNode r = head;
        ListNode pre = null;
        while (r != null && r.next != null) {
            pre = l;
            l = l.next;
            r = r.next.next;
        }

        pre.next = null;
        ListNode node1 = sortList(head);
        ListNode node2 = sortList(l);


        ListNode res = new ListNode(0);


        ListNode t = res;

        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                t.next = node1;
                node1 = node1.next;
            } else {
                t.next = node2;
                node2 = node2.next;
            }
            t = t.next;
        }
        if (node1 != null) {
            t.next = node1;
        } else if (node2 != null) {
            t.next = node2;
        }

        return res.next;
    }

}
