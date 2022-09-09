package xyz.nyist.leetcode.begin800;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/4/26 18:17
 * @Description: 链表中点
 */
public class Solution876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}
