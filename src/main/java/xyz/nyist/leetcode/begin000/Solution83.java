package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;
        while (head != null) {
            ListNode next = head.next;
            while (next != null && next.val == head.val) {
                next = next.next;
            }
            head.next = next;
            head = head.next;
        }
        return res;
    }
}
