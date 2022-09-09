package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/7/26 15:43
 * @Description:
 */
public class Solution143 {

    public void reorderList(ListNode head) {
        boolean t = true;
        while (head != null) {
            if (t && head.next != null && head.next.next != null) {
                ListNode k = head.next;
                head.next = getLast(head);
                head.next.next = k;
            }
            t = !t;
            head = head.next;
        }
    }

    private ListNode getLast(ListNode head) {
        while (head.next.next != null) {
            head = head.next;
        }
        ListNode res = head.next;
        head.next = null;
        return res;
    }

}
