package xyz.nyist.netty;

/**
 * @author: silence
 * @Date: 2022/11/17 20:44
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        new Main().print(10, 10);
    }

    /**
     * @param n 行
     * @param m 列
     *          <p>
     *          1 6 7 12 13 18
     *          2 5 8 11 14 17
     *          3 4 9 10 15 16
     */
    private void print(int n, int m) {
        int k1 = 2 * n - 1;
        int k2 = 1;
        for (int i = 0; i < n; i++) {
            int pre = i;
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    System.out.print(pre + 1 + " ");
                    pre = pre + 1;
                } else if ((j & 1) == 0) {
                    //偶数列
                    System.out.print(pre + k2 + " ");
                    pre = pre + k2;
                } else {
                    System.out.print(pre + k1 + " ");
                    pre = pre + k1;
                }

            }
            k1 -= 2;
            k2 += 2;
            System.out.println();
        }
    }

}
