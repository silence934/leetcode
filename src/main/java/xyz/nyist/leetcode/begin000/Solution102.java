package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

import java.util.*;

/**
 * @author silence
 */
public class Solution102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(new TreeNode(Integer.MIN_VALUE));
        while (true) {
            TreeNode t;
            List<Integer> list = new ArrayList<>();
            while ((Objects.requireNonNull(t = queue.poll())).val != Integer.MIN_VALUE) {
                list.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            res.add(list);
            if (queue.isEmpty()) {
                break;
            }
            queue.add(new TreeNode(Integer.MIN_VALUE));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution102 solution102 = new Solution102();
        System.out.println(solution102.levelOrder(TreeUtil.createTree("[0,2,4,1,null,3,-1,5,1,null,6,null,8]")));
    }
}
