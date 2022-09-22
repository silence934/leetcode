package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/14 15:08
 * @Description:
 */
public class Offer38 {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] ans = new int[temperatures.length];
        ans[ans.length - 1] = 0;


        for (int i = ans.length - 2; i > -1; i--) {
            int cur = temperatures[i];
            int next = i + 1;

            while (next < ans.length && temperatures[next] <= cur) {
                if (ans[next] == 0) {
                    next = ans.length;
                    break;
                }
                next = ans[next] + next;
            }

            if (next == ans.length) {
                ans[i] = 0;
            } else {
                ans[i] = next - i;
            }

        }


        return ans;
    }

}
