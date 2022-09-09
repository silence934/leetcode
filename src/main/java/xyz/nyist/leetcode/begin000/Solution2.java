package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;

/**
 * @author: silence
 * @Date: 2021/7/12 17:54
 * @Description:
 */
public class Solution2 {


    public static void main(String[] args) {
        int a = '1' - '0';
        System.out.println(a);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while (l1 != null) {
            sb1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            sb2.append(l2.val);
            l2 = l2.next;
        }


        StringBuilder sb3 = new StringBuilder();

        int i = 0, j = 0;


        int k = 0;

        while (i < sb1.length() || j < sb2.length()) {
            int number1 = i < sb1.length() ? sb1.charAt(i++) - '0' : 0;
            int number2 = j < sb2.length() ? sb2.charAt(j++) - '0' : 0;

            int t = number1 + number2 + k;
            k = t / 10;

            sb3.append(Integer.valueOf(t % 10));

        }
        if (k != 0) {
            sb3.append(k);
        }


        ListNode head = new ListNode(sb3.charAt(0) - '0');
        ListNode res = head;
        for (int y = 1; y < sb3.length(); y++) {
            head.next = new ListNode(sb3.charAt(y) - '0');
            head = head.next;
        }

        return res;
    }


}
