package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/4/18 10:37
 * @Description:
 */
public class Solution386 {


    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        int t = 1;
        while (ans.size() <= n) {
            ans.add(t);
            if (t * 10 <= n) {
                t = t * 10;
            } else {
                while (t + 1 > n || t % 10 == 9) {
                    t = t / 10;
                }
                t = t + 1;
            }
        }

        return ans;
    }


}
