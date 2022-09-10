package xyz.nyist.leetcode.offer_special_assault;

/**
 * @author: silence
 * @Date: 2022/9/8 17:41
 * @Description:
 */
public class Offer3 {

    public int[] countBits(int n) {
        int[] asn = new int[n + 1];

        int t = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                t = i;
            }
            asn[i] = asn[i - t] + 1;
        }

        return asn;


    }

}
