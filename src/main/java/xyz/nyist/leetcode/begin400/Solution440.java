package xyz.nyist.leetcode.begin400;

/**
 * @author: fucong
 * @Date: 2022/4/18 15:07
 * @Description:
 */
public class Solution440 {

    public static void main(String[] args) {
        Solution440 solution440 = new Solution440();
        System.out.println(solution440.findKthNumber(10000, 10000));
    }

    public int findKthNumber(int n, int k) {
        int ans = 1;

        while (k > 1) {
            int cnt = getCnt(ans, n);
            if (cnt >= k) {
                ans = ans * 10;
                k--;
            } else {
                ans++;
                k = k - cnt;
            }

        }
        return ans;
    }

    private int getCnt(int pre, int n) {
        String sx = String.valueOf(pre);
        String sn = String.valueOf(n);

        int k = sn.length() - sx.length();
        int ans = 0;

        //前缀多i位的情况(最终比n少一位)
        for (int i = 0; i < k; i++) {
            ans += Math.pow(10, i);
        }

        //和n相同位数的情况
        int anInt = Integer.parseInt(sn.substring(0, sx.length()));
        //anInt是 n 和 pre相同位数的前缀
        //小于和等于的区别在于： 小于的时候剩余的 补位 可以是任何值，等于的时候 补位 不能大于n
        if (pre < anInt) {
            ans += Math.pow(10, k);
        } else if (pre == anInt) {
            //+1是因为 pre * Math.pow(10, k) 和 n 都算  需要+1
            ans += (n - pre * Math.pow(10, k) + 1);
        }

        return ans;
    }

}
