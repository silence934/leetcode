package xyz.nyist.leetcode.begin1600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/9/22 16:18
 * @Description:
 */
public class Solution1640 {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            map.put(pieces[i][0], i);
        }

        for (int i = 0; i < arr.length; i++) {
            Integer integer = map.get(arr[i]);
            if (integer == null) {
                return false;
            }
            int[] t = pieces[integer];
            for (int k : t) {
                if (arr[i] != k) {
                    return false;
                }
                i++;
            }
            i--;
        }
        return true;
    }

}
