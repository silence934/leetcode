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
    public static void main(String[] args) {
        Solution99 solution99 = new Solution99();
        solution99.recoverTree(TreeOperation.createTree("1,3,null,null,2"));
    }

    public void recoverTree(TreeNode root) {
        TreeOperation.show(root);
        chick(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public void chick(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val < high && root.val > low) {
            chick(root.left, low, root.val);
            chick(root.right, root.val, high);
        }
        else {
            System.out.println(root);
        }
    }

}
