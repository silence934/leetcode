package xyz.nyist.leetcode.to200;

import xyz.nyist.utils.ListNode;

/**
 * @Author: silence
 * @Description: 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/7/5 9:38
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int l = 0;
        while (head != null) {
            l++;
            head = head.next;
        }
        // head = reversal(p, 0, l - 1);
        for (int i = 1; i < l; i++) {
            if ((i + 1) % k == 0) {
                p = reversal(p, i - k + 1, i);
            }
        }
        return p;
    }

    public ListNode reversal(ListNode head, int start, int end) {
        int k = 0;
        ListNode pre = null, next, p = head, m = null, n = null;
        while (head != null) {
            if (k == start - 1) {
                m = head;
            }
            else if (k == start) {
                n = head;
            }
            if (k > start && k <= end) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
                if (k == end) {
                    if (m == null) {
                        p = pre;
                    }
                    else {
                        m.next = pre;
                    }
                    n.next = next;
                }
            }
            else {
                pre = head;
                head = head.next;
            }
            k++;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        head.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(head);
        Solution25 solution25 = new Solution25();
        System.out.println(solution25.reverseKGroup(head, 2));
    }
}
