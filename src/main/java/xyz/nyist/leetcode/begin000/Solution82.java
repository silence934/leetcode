package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

//[1,2,3,3,4,4,5]
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next = head;
        head = res;
        while (head != null) {
            ListNode temp = head.next;
            boolean is = false;
            while (temp != null && temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
                is = true;
            }
            if (is) {
                head.next = temp.next;
            } else {
                head = head.next;
            }
        }

        return res.next;
    }
}
