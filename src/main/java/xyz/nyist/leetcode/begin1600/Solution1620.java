package xyz.nyist.leetcode.begin1600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/2 16:20
 * @Description:
 */
public class Solution1620 {
//[[18,12,31],[45,39,36],[14,26,25]]
//34

    public static void main(String[] args) {
//[[45,12,4],[13,21,27],[31,17,40],[25,29,45],[37,29,25],[16,37,48],[4,3,31]]
//42

        int[][] towers = new int[][]{
                new int[]{45, 12, 4},
                new int[]{13, 21, 27},
                new int[]{31, 17, 40},
                new int[]{25, 29, 45},
                new int[]{37, 29, 25},
                new int[]{16, 37, 48},
                new int[]{4, 3, 31},
        };

        System.out.println(Arrays.toString(new Solution1620().bestCoordinate(towers, 42)));
    }

    public int[] bestCoordinate(int[][] towers, int radius) {
        Map<String, Integer> map = new HashMap<>();
        for (int[] tower : towers) {
            traverse(tower[0], tower[1], tower[2], radius, map);
        }

        String ans = "0,0";
        int max = 0;


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);

            if (max < entry.getValue()) {
                ans = entry.getKey();
                max = entry.getValue();
            } else if (max == entry.getValue() && compare(entry.getKey(), ans)) {
                ans = entry.getKey();
            }
        }
        String[] split = ans.split(",");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }


    private void traverse(int x, int y, int q, int radius, Map<String, Integer> map) {
        map.put(x + "," + y, map.getOrDefault(x + "," + y, 0) + q);
        for (int i = 0; i <= radius; i++) {
            for (int j = 0; j <= radius; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                double d = length(x, y, x + i, y + j);
                if (d > radius) {
                    break;
                }
                int k = (int) (q / (1 + d));
                String s = x + i + "," + (y + j);
                map.put(s, map.getOrDefault(s, 0) + k);
                if (i != 0 && j != 0 && x - i > -1 && y - j > -1) {
                    s = x - i + "," + (y - j);
                    map.put(s, map.getOrDefault(s, 0) + k);
                }
                if (x != 0 && x - i > -1) {
                    s = x - i + "," + (y + j);
                    map.put(s, map.getOrDefault(s, 0) + k);
                }
                if (j != 0 && y - j > -1) {
                    s = x + i + "," + (y - j);
                    map.put(s, map.getOrDefault(s, 0) + k);
                }
            }
        }
    }


    private double length(int x, int y, int x1, int y1) {
        return Math.sqrt(Math.abs(x - x1) + Math.abs(y - y1));
    }


    private boolean compare(String s1, String s2) {
        String[] split1 = s1.split(",");
        String[] split2 = s2.split(",");

        int x1 = Integer.parseInt(split1[0]);
        int x2 = Integer.parseInt(split2[0]);
        if (x1 != x2) {
            return x1 < x2;
        }

        int y1 = Integer.parseInt(split1[1]);
        int y2 = Integer.parseInt(split2[1]);
        return y1 < y2;
    }

}
