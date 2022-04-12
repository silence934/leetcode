package xyz.nyist.leetcode.begin1600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: fucong
 * @Date: 2022/3/30 10:07
 * @Description:
 */
public class Solution1606 {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[][] map = new int[k][3];


        for (int i = 0; i < k; i++) {
            map[i][2] = i;
        }

        for (int i = 0; i < arrival.length; i++) {
            int index = i % k;
            if (map[index][0] <= arrival[i]) {
                map[index][0] = arrival[i] + load[i];
                map[index][1]++;
            } else {
                int t = index + 1;
                while (true) {
                    if (t == k) {
                        t = 0;
                    } else if (t == index) {
                        break;
                    } else {
                        if (map[t][0] <= arrival[i]) {
                            map[t][0] = arrival[i] + load[i];
                            map[t][1]++;
                            break;
                        }
                        t++;
                    }
                }
            }
        }

        Arrays.sort(map, Comparator.comparingInt(o -> o[1]));

        List<Integer> res = new ArrayList<>();

        for (int i = k - 1; i >= 0; i--) {
            if (i == k - 1) {
                res.add(map[i][2]);
            } else if (map[i][1] == map[k - 1][1]) {
                res.add(map[i][2]);
            } else {
                break;
            }
        }

        return res;
    }

}
