package xyz.nyist.test;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/2 14:45
 */
public class BM {

    private static void test(String s, String p) {
        char[] sa = s.toCharArray();
        char[] pa = p.toCharArray();
        int k;
        int start = 0;
        while ((k = start + pa.length - 1) < s.length()) {
            int m = pa.length - 1;
            while (sa[k] == pa[m]) {
                m--;
                k--;
                if (m < 0) {
                    System.out.println(true);
                    return;
                }
            }
            int step = 0;
            if (m != pa.length - 1) {
                char good = pa[pa.length - 1];
                step = pa.length - 1 - getIndex(good, pa);
            }
            char bad = sa[k];
            step = Math.max(step, m - getIndex(bad, pa));
            start += step;
        }
        System.out.println(false);
    }

    private static int getIndex(char c, char[] p) {
        for (int i = 0; i < p.length; i++) {
            if (p[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        test("HEREISASIMPLEEXAMPLE",
                "EXAMPLE");
    }
}
