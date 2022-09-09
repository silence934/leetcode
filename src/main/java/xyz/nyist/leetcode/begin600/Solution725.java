package xyz.nyist.leetcode.begin600;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/9/22 19:42
 * @Description:
 */
public class Solution725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode h = head;
        int l = 0;
        while (h != null) {
            l++;
            h = h.next;
        }
        //每段多长
        int m = l / k;
        //前n段长为m+1
        int n = l - m * k;

        ListNode[] res = new ListNode[k];

        for (int i = 0; i < k; i++) {
            res[i] = head;
            int tl = m - (n < 1 ? 1 : 0);
            n--;
            while (head != null && tl > 0) {
                head = head.next;
                tl--;
            }
            if (head != null) {
                ListNode next = head.next;
                head.next = null;
                head = next;
            }
        }


        return res;
    }

}
