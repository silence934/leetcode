package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/11/24 21:18
 * @Description:
 */
public class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });


        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        int max = 1;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    public int maxEnvelopes1(int[][] envelopes) {

        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);


        for (int i = 1; i < envelopes.length; i++) {
            int w = envelopes[i][1];
            if (w > list.get(list.size() - 1)) {
                list.add(w);
            } else {
                int l = 0, r = list.size() - 1;

                while (l < r) {
                    int mid = ((r - l) >> 1) + l;
                    if (list.get(mid) < w) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }

                list.set(l, w);
            }
        }

        return list.size();
    }
}
