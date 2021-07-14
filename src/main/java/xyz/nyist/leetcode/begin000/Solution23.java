package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: fucong
 * @Date: 2021/7/14 12:28
 * @Description:
 */
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null;
        ListNode p = null;

        while (true) {

            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    k = i;
                }
            }

            if (k == -1) {
                break;
            }

            if (p == null) {
                p = new ListNode(lists[k].val);
                head = p;
            } else {
                p.next = new ListNode(lists[k].val);
                p = p.next;
            }

            lists[k] = lists[k].next;

        }

        return head;
    }

}
