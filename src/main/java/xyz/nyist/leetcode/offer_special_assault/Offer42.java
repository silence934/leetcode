package xyz.nyist.leetcode.offer_special_assault;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer42 {


    LinkedList<Integer> list;

    public Offer42() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        list.addLast(t);
        t -= 3000;

        while (list.getFirst() < t) {
            list.removeFirst();
        }

        return list.size();
    }


}
