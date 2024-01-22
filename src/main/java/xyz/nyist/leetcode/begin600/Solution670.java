package xyz.nyist.leetcode.begin600;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/9/13 17:53
 * @Description:
 */
public class Solution670 {
    //9913
    public static void main(String[] args) {
        System.out.println(new Solution670().maximumSwap(1993));
    }

    public int maximumSwap1(int num) {

        char[] chars = String.valueOf(num).toCharArray();

        int n = chars.length - 1;
        int[][] map = new int[chars.length][2];
        map[n][0] = chars[n];
        map[n][1] = n;
        for (int i = n - 1; i > -1; i--) {
            if (map[i + 1][0] > chars[i]) {
                map[i][0] = map[i + 1][0];
                map[i][1] = map[i + 1][1];
            } else {
                map[i][0] = chars[i];
                map[i][1] = i;
            }
        }

        for (int i = 0; i < n; i++) {
            int max = map[i + 1][0];
            if (max > chars[i]) {
                char t = chars[i];
                chars[i] = chars[map[i + 1][1]];
                chars[map[i + 1][1]] = t;
                return Integer.parseInt(new String(chars));
            }
        }

        return num;
    }

    public int maximumSwap(int num) {

        char[] chars = String.valueOf(num).toCharArray();
        //记录每个数字的下标  arr[i][0]=原数字，arr[i][1]=原下标
        int[][] arr = new int[chars.length][2];
        for (int i = 0; i < chars.length; i++) {
            arr[i][0] = chars[i] - '0';
            arr[i][1] = i;
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        //原数字在排序好后的arr中的下标
        int[] indexArr = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            indexArr[arr[i][1]] = i;
        }

        for (int i = 0; i < chars.length; i++) {
            int t = chars[i] - '0';
            arr[indexArr[i]][0] = -1;

            int rightIndex = arr.length - 1;
            while (rightIndex > -1 && arr[rightIndex][0] == -1) {
                rightIndex--;
            }

            if (rightIndex > -1 && arr[rightIndex][0] > t) {
                chars[arr[rightIndex][1]] = String.valueOf(t).charAt(0);
                chars[i] = String.valueOf(arr[rightIndex][0]).charAt(0);
                return Integer.parseInt(new String(chars));
            }
        }

        return num;
    }
}
