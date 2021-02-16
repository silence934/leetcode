package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.Stack;

/**
 * @Author: silence
 * @Description: 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * <p>
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date:Create：in 2020/8/6 23:54
 */
public class Solution173 {

    TreeNode root;
    Stack<TreeNode> stack;

    public Solution173(TreeNode root) {
        this.root = root;
        stack = new Stack<>();
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        int r;
        if (stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
        }
        TreeNode treeNode = stack.pop();
        r = treeNode.val;
        if (treeNode.right != null) {
            root = treeNode.right;
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
        }
        return r;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution173 solution173 = new Solution173(TreeOperation.createTree("1"));
        System.out.println(solution173.hasNext());
    }
}
