package xyz.nyist.leetcode.begin400;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/9/15 14:28
 * @Description:
 */
public class Solution445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        ListNode head = new ListNode(0);
        ListNode temp = head;
        boolean b = false;
        while (l1 != null || l2 != null) {
            int i = b ? 1 : 0;
            if (l1 != null) {
                i += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                i += l2.val;
                l2 = l2.next;
            }
            if (i > 9) {
                b = true;
                i -= 10;
            } else {
                b = false;
            }
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        if (b) {
            temp.next = new ListNode(1);
        }

        temp = head.next;
        head.next = null;
        return reverseList(temp);
    }

    private ListNode reverseList(ListNode head) {
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
