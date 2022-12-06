package xyz.nyist.leetcode.begin1600;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/12/6 21:37
 * @Description: [[1, 4], [1, 2], [2, 1], [2, 1], [3, 2], [3, 4]]
 */
public class Solution1687 {

    public static void main(String[] args) {
        System.out.println(new Solution1687().boxDelivering(new int[][]{
                        new int[]{1, 4},
                        new int[]{1, 2},
                        new int[]{2, 1},
                        new int[]{2, 1},
                        new int[]{3, 2},
                        new int[]{3, 4},
                },
                3, 6, 7));
    }

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        return boxDelivering(boxes, 0, portsCount, maxBoxes, maxWeight, new HashMap<>());
    }

    public int boxDelivering(int[][] boxes, int index, int portsCount, int maxBoxes, int maxWeight, Map<Integer, Integer> cache) {
        if (index == boxes.length) {
            return 0;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        int min = Integer.MAX_VALUE;
        int weight = 0;
        for (int i = index; i < boxes.length; i++) {
            weight += boxes[i][1];
            if (weight > maxWeight || i - index + 1 > maxBoxes) {
                break;
            }
            int curr = 2;
            for (int j = index + 1; j <= i; j++) {
                if (boxes[j][0] != boxes[j - 1][0]) {
                    curr++;
                }
            }
            min = Math.min(min, curr + boxDelivering(boxes, i + 1, portsCount, maxBoxes, maxWeight, cache));
        }
        cache.put(index, min);
        return min;
    }


}
