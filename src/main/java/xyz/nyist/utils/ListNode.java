package xyz.nyist.utils;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/5 9:39
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
