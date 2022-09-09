package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

import java.util.Stack;

/**
 * @Author : silence
 * @Date: 2021-02-16 19:59
 * @Description :
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = getTreeMaxDepth(root);

        int count = ((int) Math.pow(2, maxDepth)) - 1;
        int depth = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root, per = null;
        while (temp != null || !stack.isEmpty()) {

            boolean b = false;

            while (temp != null) {
                b = true;
                stack.push(temp);
                depth++;
                temp = temp.right;
            }

            if (depth == maxDepth) {
                break;
            }

            if (b) {
                count--;
            }

            temp = stack.peek();
            if (temp.left != null && temp.left != per) {
                temp = temp.left;
            } else {
                if (per == null || temp.left != per) {
                    count--;
                }
                per = stack.pop();
                temp = null;
                depth--;
            }
        }

        return count;
    }


    private int getTreeMaxDepth(TreeNode root) {
        return root == null ? 0 : 1 + getTreeMaxDepth(root.left);
    }


    public static void main(String[] args) {
        Solution222 solution222 = new Solution222();
        System.out.println(solution222.countNodes(TreeUtil.createTree("1,2,3,4,5,6,7,8")));

    }

}
