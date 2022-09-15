package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer26 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;


        new Offer26().reorderList(head);
    }

    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        ListNode slow = head.next, fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next2 = slow.next;
        slow.next = null;
        slow = reverseList(next2);

        System.out.println(head);
        System.out.println(slow);

        while (head != null && slow != null) {
            ListNode next = head.next;
            head.next = slow;
            ListNode next1 = slow.next;
            slow.next = next;
            slow = next1;
            head = next;

        }

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
