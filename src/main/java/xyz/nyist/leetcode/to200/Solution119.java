package xyz.nyist.leetcode.to200;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

/**
 * @Author: silence
 * @Description: 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * <p>
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * <p>
 * 计算从根到叶子节点生成的所有数字之和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 1
 * / \
 * 2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/5 23:57
 */
public class Solution119 {
    Integer sum = 0;

    public static void main(String[] args) {
        Solution119 solution119 = new Solution119();
        System.out.println(solution119.sumNumbers(TreeOperation.createTree("[4,9,0,5,1]")));
    }

    public int sumNumbers(TreeNode root) {
        // sumNumbers(root, "");
        return sunNumbers(root, 0);
    }

    public void sumNumbers(TreeNode root, String s) {
        s += root.val;
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(s);
            return;
        }
        if (root.left != null) {
            sumNumbers(root.left, s);
        }
        if (root.right != null) {
            sumNumbers(root.right, s);
        }
    }

    public int sunNumbers(TreeNode root, int t) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return t * 10 + root.val;
        }
        return sunNumbers(root.left, t * 10 + root.val) + sunNumbers(root.right, t * 10 + root.val);
    }
}
