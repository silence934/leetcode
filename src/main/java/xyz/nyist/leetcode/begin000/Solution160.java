package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/4/26 18:23
 * @Description:
 */
public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        boolean t = false;

        while (a != b) {
            if (a == headB) {
                if (t) {
                    return null;
                }
                t = true;
            }
            a = a.next;
            b = b.next;
            if (a == null) {
                a = headB;
            }
            if (b == null) {
                b = headA;
            }
        }

        return a;
    }

}
