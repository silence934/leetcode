package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.ListNode;
import xyz.nyist.utils.TreeNode;

/**
 * @author: silence
 * @Date: 2021/6/24 14:19
 * @Description:
 */
public class Solution109 {


    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int t = count / 2 + 1;
        int i = 1;

        ListNode pre = head;
        node = head;
        while (t != i) {
            pre = node;
            node = node.next;
            i++;
        }

        pre.next = null;

        TreeNode root = new TreeNode(node.val);
        if (head != node) {
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(node.next);

        return root;
    }

}
