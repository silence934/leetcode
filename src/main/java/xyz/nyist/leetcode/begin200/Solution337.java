package xyz.nyist.leetcode.begin200;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : fucong
 * @Date: 2020-09-06 15:30
 * @Description :
 */
public class Solution337 {

    Map<TreeNode, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        Solution337 solution337 = new Solution337();
        System.out.println(solution337.rob(TreeUtil.createTree("[3,4,5,1,3,null,1]")));
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.get(root) != null) {
            return memo.get(root);
        }
        int noRob = rob(root.left) + rob(root.right);
        int rob = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        int res = Math.max(noRob, rob);
        memo.put(root, res);
        return res;
    }


    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rob = root.val +
                (root.left == null ? 0 : (rob1(root.left.left) + rob1(root.left.right)))
                + (root.right == null ? 0 : (rob1(root.right.left) + rob1(root.right.right)));


        int noRob = rob1(root.left) + rob1(root.right);

        return Math.max(rob, noRob);
    }
}
