package xyz.nyist.asd;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/8/1 16:06
 */
public class Test12 {
    public static void main(String[] args) {
        Test12 test12 = new Test12();

        System.out.println(test12.reletive_7(new int[]{1, 2, 1}));
    }

    public int reletive_7(int[] digit) {
        int r = 0, b = 1;
        int[] hash = new int[10];
        for (int i : digit) {
            hash[i]++;
            b *= hash[i];
        }

        int n = digit.length;
        long start = (getL(n - 1)) / 7;
        long end = (getL(n) - 1) / 7;
        for (long i = start; i <= end; i++) {
            int[] hasht = hash.clone();
            char[] chars = String.valueOf(7 * i).toCharArray();
            for (char aChar : chars) {
                hasht[aChar - '0']--;
            }
            int j;
            for (j = 0; j < 10; j++) {
                if (hasht[j] != 0) {
                    break;
                }
            }
            if (j == 10) {
                r += b;
            }
        }
        return r;
    }

    long getL(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

}
