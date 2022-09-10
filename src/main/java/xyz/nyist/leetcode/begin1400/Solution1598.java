package xyz.nyist.leetcode.begin1400;

/**
 * @author: silence
 * @Date: 2022/9/9 17:17
 * @Description:
 */
public class Solution1598 {

    public int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                if (res != 0) {
                    res--;
                }
            } else if ("./".equals(log)) {

            } else {
                res++;
            }
        }
        return res;
    }

}
