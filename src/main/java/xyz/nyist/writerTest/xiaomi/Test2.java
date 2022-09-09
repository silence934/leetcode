package xyz.nyist.writerTest.xiaomi;

import xyz.nyist.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author : silence
 * @Date: 2020-09-27 09:47
 * @Description :
 */
public class Test2 {

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        System.out.println(test2.sumNumbers(null));
    }

    public int sumNumbers(TreeNode root) {
        List<String> list = test(root);
        int res = 0;
        for (String s : list) {
            res += Integer.parseInt(s);
        }
        return res;
    }

    public List<String> test(TreeNode root) {
        if (root == null) {
            return Collections.singletonList("0");
        }
        List<String> res = new ArrayList<>();
        if (root.left != null) {
            List<String> l = test(root.left);
            for (String s : l) {
                res.add("" + root.val + s);
            }
        }
        if (root.right != null) {
            List<String> r = test(root.right);
            for (String s : r) {
                res.add("" + root.val + s);
            }
        }

        if (root.left == null && root.right == null) {
            res.add("" + root.val);
        }
        return res;
    }

}
