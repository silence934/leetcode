package xyz.nyist.writerTest.gelinshentong;

import xyz.nyist.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : fucong
 * @Date: 2020-11-08 13:42
 * @Description :
 */
public class Main1 {
    public static void main(String[] args) {

    }

    private static int getArea(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int w = 1, h = 0;
        Queue<TreeNode> ll = new LinkedList<>();
        ll.add(root);
        while (true) {
            int len = ll.size();
            if (len == 0) {
                break;
            }
            h++;
            while (len > 0) {
                TreeNode b = ll.poll();
                len--;
                if (b.left != null) {
                    ll.add(b.left);
                }
                if (b.right != null) {
                    ll.add(b.right);
                }
            }
            w = Math.max(w, ll.size());
        }
        return w * h;
    }
}
