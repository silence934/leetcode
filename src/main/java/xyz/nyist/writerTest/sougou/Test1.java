package xyz.nyist.writerTest.sougou;

/**
 * @Author : fucong
 * @Date: 2020-09-25 18:49
 * @Description : 总数  对的数量  自己的  朋友的
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(test1.solve(1, 0, "ABC", "DDD"));
    }

    public Interval solve(int n, int k, String str1, String str2) {
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                t++;
            }
        }

        Interval res = new Interval();
        res.start = Math.max((t + k) - n, 0);
        res.end = n - Math.max((n - t) - (n - k), 0);
        return res;
    }

    private static class Interval {
        int start;
        int end;

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
