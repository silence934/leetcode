package xyz.nyist.utils;

public class ArrUtil {
    public static int[][] String2Arrays(String str) {

        String[] strings = str.substring(2, str.length() - 2).split("],\\[");
        int[][] ans = new int[strings.length][strings[0].split(",").length];

        for (int i = 0; i < strings.length; i++) {
            String[] strings1 = strings[i].split(",");
            ans[i] = new int[strings1.length];
            for (int j = 0; j < strings1.length; j++) {
                ans[i][j] = Integer.parseInt(strings1[j]);
            }
        }

        return ans;
    }
}
