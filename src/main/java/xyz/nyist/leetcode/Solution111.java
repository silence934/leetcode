package xyz.nyist.leetcode;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

/**
 * @Author: silence
 * @Description: 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/2 21:54
 */
public class Solution111 {

    int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Solution111 solution111 = new Solution111();
        System.out.println(solution111.minDepth(TreeOperation.createTree("3,9,20,null,null,15,7")));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        test(root, 1);
        return min;
    }

    public void test(TreeNode root, int d) {
        if (d > min) {
            return;
        }
        if (root.left == null && root.right == null) {
            min = Math.min(min, d);
            return;
        }
        if (root.left != null) {
            test(root.left, d + 1);
        }
        if (root.right != null) {
            test(root.right, d + 1);
        }
    }
}
