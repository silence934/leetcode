package xyz.nyist.leetcode.to1600;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author: silence
 * @Description: 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入：[1, 2, 3, 3, 2, 1]
 * 输出：[1, 2, 3]
 * 示例2:
 * <p>
 * 输入：[1, 1, 1, 1, 2]
 * 输出：[1, 2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-node-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/6/26 16:14
 */
public class Solution1591 {

    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new LinkedHashSet<>();
        while (head != null) {
            set.add(head.val);
            head = head.next;
        }
        System.out.println(set);
        ListNode listNode = null, H = null;
        boolean b = true;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (b) {
                H = listNode = new ListNode(iterator.next());
                b = false;
            }
            else {
                ListNode node = new ListNode(iterator.next());
                listNode.next = node;
                listNode = node;
            }

        }
        return H;
    }

    public static void main(String[] args) {
        Solution1591 solution1591 = new Solution1591();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(solution1591.removeDuplicateNodes(listNode1));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
