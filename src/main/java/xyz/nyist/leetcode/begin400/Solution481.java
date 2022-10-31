package xyz.nyist.leetcode.begin400;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/10/31 10:23
 * @Description:
 */
public class Solution481 {

    public int magicalString(int n) {
        int ans = 1;
        if (n < 3) {
            return ans;
        }

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(2);

        int i = 2;
        int k = 1;
        while (i != n) {
            for (int j = 0; j < list.get(i); j++) {
                list.add(k);
                if (list.size() == n) {
                    if (k == 1) {
                        if (list.get(i) == 2 && j == list.get(i) - 1) {
                            ans += 2;
                        } else {
                            ans += 1;
                        }
                    }
                    return ans;
                }
            }

            if (k == 2) {
                k = 1;
            } else {
                ans += list.get(i);
                k = 2;
            }
            i++;
        }

        return ans;
    }

}
