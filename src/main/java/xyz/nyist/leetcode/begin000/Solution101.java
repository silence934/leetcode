package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.*;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date:Create：in 2020/7/19 13:02
 */
public class Solution101 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new TreeNode(Integer.MIN_VALUE));
        while (true) {
            TreeNode t;
            List<Integer> list = new ArrayList<>();
            while ((t = queue.poll()) == null || t.val != Integer.MIN_VALUE) {
                if (t != null) {
                    list.add(t.val);
                    queue.add(t.left);
                    queue.add(t.right);
                } else {
                    list.add(null);
                }
            }
            Integer[] k = list.toArray(new Integer[0]);
            int low = 0, hei = k.length - 1;
            while (low < hei) {
                if (!Objects.equals(k[low++], k[hei--])) {
                    return false;
                }
            }
            if (queue.isEmpty()) {
                break;
            }
            queue.add(new TreeNode(Integer.MIN_VALUE));
        }
        return true;
    }

    public static void main(String[] args) {
        Solution101 solution102 = new Solution101();
        TreeNode treeNode = TreeOperation.createTree("[2,3,3,4,5,null,4]");
        TreeOperation.show(treeNode);
        System.out.println(solution102.isSymmetric1(treeNode));
    }


    public boolean isSymmetric1(TreeNode root) {
        return chick(root, root);
    }

    public boolean chick(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }
        if (leftRoot == null || rightRoot == null) {
            return false;
        } else {
            return leftRoot.val == rightRoot.val && chick(leftRoot.left, rightRoot.right) && chick(leftRoot.right, rightRoot.left);
        }
    }
}
