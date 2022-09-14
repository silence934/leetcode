package xyz.nyist.leetcode.begin600;

/**
 * @author: silence
 * @Date: 2022/9/13 17:53
 * @Description:
 */
public class Solution670 {

    public static void main(String[] args) {
        System.out.println(new Solution670().maximumSwap(10));
    }

    public int maximumSwap(int num) {

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

}
