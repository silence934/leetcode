package xyz.nyist.leetcode.offer;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/7/21 19:20
 * @Description:
 */
public class Offer56 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return getIntersectionNode(headA, headB, headA, headB);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB, ListNode node1, ListNode node2) {
        if ((node1 == null && node2 == null)) {
            return null;
        }
        if (node1 == null) {
            return getIntersectionNode(headA, headB, headB, node2.next);
        } else if (node2 == null) {
            return getIntersectionNode(headA, headB, node1.next, headA);
        } else if (node1 == node2) {
            return node1;
        }
        return getIntersectionNode(headA, headB, node1.next, node2.next);
    }

}
