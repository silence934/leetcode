package xyz.nyist.leetcode.begin2000;

import java.util.Arrays;

public class Solution2171 {
    public static void main(String[] args) {
        System.out.println(new Solution2171().minimumRemoval(new int[]{60}));
    }

    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);

        //如果都降到最低的，需要的数量
        long numbers = 0;
        for (int i = 1; i < beans.length; i++) {
            numbers += (beans[i] - beans[0]);
        }

        long res = numbers;
        //都降到beans[i]时需要的数量
        for (int i = 0; i < beans.length; i++) {
            //将beans[i]清零需要的数量
            numbers += beans[i];
            if (i < beans.length - 1) {
                //都降到beans[i+1]和beans[i]的差值
                int diff = beans[i + 1] - beans[i];
                numbers -= ((long) diff * (beans.length - i - 1));
            }
            res = Math.min(res, numbers);
        }


        return res;
    }
}
