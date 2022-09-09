package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/4/26 14:32
 * @Description:
 */
public class Solution142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
