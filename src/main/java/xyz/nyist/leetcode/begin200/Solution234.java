package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/6/30 14:10
 * @Description:
 */
public class Solution234 {

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return test(head);
    }


    private boolean test(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = test(head.next);
        res = res && head.val == left.val;
        left = left.next;
        return res;
    }


    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }

        ListNode right = reversal(slow);
        while (right != null) {
            if (right.val != head.val) {
                return false;
            }
            right = right.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reversal(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}
