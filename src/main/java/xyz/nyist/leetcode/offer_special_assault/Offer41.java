package xyz.nyist.leetcode.offer_special_assault;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer41 {

    int size;

    LinkedList<Integer> list;

    int sum;

    public Offer41(int size) {
        this.size = size;
        list = new LinkedList<>();
        sum = 0;
    }

    public double next(int val) {
        sum += val;
        if (list.size() < size) {
            list.addLast(val);
            return sum / (double) list.size();
        }
        sum -= list.removeFirst();
        list.addLast(val);
        return sum / (double) list.size();
    }

}
