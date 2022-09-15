package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer23 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1 = headA, node2 = headB;


        boolean t = false;
        while (node1 != node2) {
            if (node1 == headB) {
                if (t) {
                    return null;
                }
                t = true;
            }
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == null) {
                node1 = headB;
            }
            if (node2 == null) {
                node2 = headA;
            }
        }


        return node1;
    }

}
