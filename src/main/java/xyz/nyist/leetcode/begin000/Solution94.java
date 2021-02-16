package xyz.nyist.leetcode.begin000;

import xyz.nyist.utils.TreeNode;
import xyz.nyist.utils.TreeOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/15 11:25
 */
public class Solution94 {
    List<Integer> list = null;

    public Solution94() {
        this.list = new ArrayList<>();
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode tmp = root;
        Stack<TreeNode> s = new Stack<>();
        while (tmp != null || !s.empty()) {
            //1.将根节点入栈
            //2.将所有左孩子入栈
            while (tmp != null) {
                s.push(tmp);
                tmp = tmp.left;
            }
            //3.访问栈顶元素
            tmp = s.pop();
            list.add(tmp.val);
            //4.如果栈顶元素存在右孩子，则将右孩子赋值给tmp，也就是将右孩子入栈
            if (tmp.right != null) {
                tmp = tmp.right;
            }
            //否则，将tmp置为null，表示下次要访问的是栈顶元素
            else {
                tmp = null;
            }
        }

        return list;
    }

    public void test(TreeNode root) {
        if (root == null) {
            return;
        }
        test(root.left);
        list.add(root.val);
        test(root.right);
    }


    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();
        System.out.println(solution94.inorderTraversal(TreeOperation.createTree("[1,2,3,4,5,6,7]")));
    }
}
