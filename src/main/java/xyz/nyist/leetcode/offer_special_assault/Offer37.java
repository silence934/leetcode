package xyz.nyist.leetcode.offer_special_assault;

import java.util.LinkedList;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer37 {

    public int[] asteroidCollision(int[] asteroids) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int asteroid : asteroids) {

            boolean b = false;
            while (asteroid < 0 && !list.isEmpty() && list.getLast() > 0) {
                if (list.getLast() == -asteroid) {
                    list.removeLast();
                    b = true;
                    break;
                } else if (list.getLast() > -asteroid) {
                    b = true;
                    break;
                } else {
                    list.removeLast();
                }
            }

            if (!b) {
                list.addLast(asteroid);
            }
        }

        int[] ans = new int[list.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.removeFirst();
        }

        return ans;
    }

}
