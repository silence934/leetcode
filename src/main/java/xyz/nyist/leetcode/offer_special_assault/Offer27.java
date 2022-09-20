package xyz.nyist.leetcode.offer_special_assault;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer27 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(new Offer27().isPalindrome(head));
    }

    ListNode node;

    public boolean isPalindrome(ListNode head) {
        node = head;

        return isPalindrome1(head);
    }


    private boolean isPalindrome1(ListNode head) {

        if (head != null) {
            if (!isPalindrome1(head.next)) {
                return false;
            }
            if (head.val != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }


}
