package xyz.nyist.leetcode;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

import java.util.Stack;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/5/4 11:12
 */
public class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int n = matrix[0].length;
        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == target) {
                    return true;
                } else if (ints[j] > target) {
                    break;
                }
            }
        }
        return false;
    }

    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        ListNode temp = head;
        while (temp != null) {
            i++;
            stack.push(temp.val);
            temp = temp.next;
        }
        int[] res = new int[i];
        i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int t = preorder[0];
        TreeNode root = new TreeNode(t);
        System.arraycopy(preorder, 1, preorder, 0, preorder.length - 1);
        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == t) {
                k = i;
                break;
            }
        }
        int[] left = new int[k], right = new int[inorder.length - 1 - k];
        System.arraycopy(inorder, 0, left, 0, k);
        System.arraycopy(inorder, k + 1, right, 0, inorder.length - k - 1);
        TreeNode treeNode1 = buildTree(preorder, left);
        TreeNode treeNode2 = buildTree(preorder, right);
        root.left = (treeNode1);
        root.right = (treeNode2);
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*ListNode listNode1 = new Solution.ListNode(1);
        ListNode listNode2 = new Solution.ListNode(2);
        ListNode listNode3 = new Solution.ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(Arrays.toString(solution.reversePrint(listNode1)));*/

        int[] pre = new int[]{0, 1, 3, 7, 8, 4, 9, 2, 5, 6};
        int[] in = new int[]{7, 3, 8, 1, 9, 4, 0, 5, 2, 6};
        TreeNode treeNode = solution.buildTree(pre, in);
        //System.out.println(treeNode);
        TreeUtil.show(treeNode);

    }
}
