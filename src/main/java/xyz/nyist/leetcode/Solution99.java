package xyz.nyist.leetcode;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

/**
 * @author fucong
 * @date 2020-07-22 14:25
 * @description 二叉搜索树中的两个节点被错误地交换。
 * <p>
 * 请在不改变其结构的情况下，恢复这棵树。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * 输出: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * 示例 2:
 * <p>
 * 输入: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * 输出: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * 进阶:
 * <p>
 * 使用 O(n) 空间复杂度的解法很容易实现。
 * 你能想出一个只使用常数空间的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution99 {
    TreeNode pre = null, x = null, y = null;

    public static void main(String[] args) {
        Solution99 solution99 = new Solution99();
        TreeNode root = TreeOperation.createTree("[10,5,15,0,8,13,20,2,-5,6,9,12,14,18,25]");
        TreeOperation.show(root);
        solution99.recoverTree1(root);
        TreeOperation.show(root);
    }

    public void recoverTree(TreeNode root) {
        findTwoSwapped(root);
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

    public boolean findTwoSwapped(TreeNode root) {
        if (root == null) {
            return false;
        }
        if (findTwoSwapped(root.left)) {
            return true;
        }
        if (pre != null && pre.val > root.val) {
            y = root;
            if (x == null) {
                x = pre;
            }
            else {
                return true;
            }
        }
        pre = root;
        return findTwoSwapped(root.right);
    }

    public void recoverTree1(TreeNode root) {
        TreeNode predecessor = null, x = null, y = null;
        /*
        1， 根据当前节点，找到其前序节点，如果前序节点的右孩子是空，那么把前序节点的右孩子指向当前节点，
        然后进入当前节点的左孩子。
        2， 如果当前节点的左孩子为空，打印当前节点，然后进入右孩子。
        3， 如果当前节点的前序节点其右孩子指向了它本身，那么把前序节点的右孩子设置为空，打印当前节点，然后进入右孩子。
        * */
        while (root != null) {
            TreeNode pre = root.left;
            //查找前序节点
            if (pre != null) {
                while (pre.right != null && pre.right.val != root.val) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                }
                else {
                    if (predecessor != null && root.val < predecessor.val) {
                        y = root;
                        if (x == null) {
                            x = predecessor;
                        }
                        else {
                            pre.right = null;
                            // break;
                        }
                    }
                    predecessor = root;
                    pre.right = null;
                    root = root.right;
                }

            }
            else {
                if (predecessor != null && root.val < predecessor.val) {
                    y = root;
                    if (x == null) {
                        x = predecessor;
                    }
                    else {
                        //  break;
                    }
                }
                predecessor = root;
                root = root.right;
            }
        }
        int t = x.val;
        x.val = y.val;
        y.val = t;
    }

}
