package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: fucong
 * @Date: 2022/3/15 15:32
 * @Description:
 */
public class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }


        if (list1.val > list2.val) {
            ListNode t = list1;
            list1 = list2;
            list2 = t;
        }

        ListNode res = list1;

        ListNode pre = null;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val && (list1.next == null || list2.val <= list1.next.val)) {
                ListNode t = list2;
                list2 = list2.next;

                t.next = list1.next;
                list1.next = t;

                list1 = list1.next;
            } else {
                pre = list1;
                list1 = list1.next;
            }
        }

        if (list2 != null) {
            pre.next = list2;
        }

        return res;
    }


}
