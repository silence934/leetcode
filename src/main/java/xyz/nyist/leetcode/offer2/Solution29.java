package xyz.nyist.leetcode.offer2;

import xyz.nyist.utils.ListNode;

/**
 * @author: fucong
 * @Date: 2022/3/18 15:21
 * @Description:
 */
public class Solution29 {

    public ListNode insert(ListNode head, int insertVal) {

        if (head == null) {
            ListNode node = new ListNode(insertVal);
            node.next = node;
            return node;
        }

        ListNode res = head;


        while (head.next != res) {

            if (head.val > head.next.val) {
                if (head.val < insertVal || head.next.val > insertVal) {
                    break;
                }
            }

            if (head.val <= insertVal && insertVal <= head.next.val) {
                break;
            }

            head = head.next;
        }


        ListNode next = head.next;
        head.next = new ListNode(insertVal);
        head.next.next = next;

        return res;

    }

}
