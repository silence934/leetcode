package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/6/29 22:34
 * @Description:
 */
public class Solution92 {

    ListNode temp = null;

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    private ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            temp = head.next;
            return head;
        }
        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = temp;
        return last;
    }

}
