package xyz.nyist.leetcode.begin1600;

/**
 * @author: silence
 * @Date: 2022/11/24 16:16
 * @Description:
 */
public class Solution1850 {
    public int getMinSwaps(String num, int k) {
        char[] chars = num.toCharArray();

        for (int i = 0; i < k; i++) {

            for (int j = chars.length - 2; j >= 0; j--) {
                if (chars[j] < chars[j + 1]) {
                    char min = chars[j + 1];
                    int p = j + 1;
                    for (int l = j + 2; l < chars.length; l++) {
                        if (chars[l] > chars[j] && min >= chars[l]) {
                            p = l;
                            min = chars[l];
                        }
                    }
                    chars[p] = chars[j];
                    chars[j] = min;

                    int l = j + 1, r = chars.length - 1;
                    while (l < r) {
                        char t = chars[l];
                        chars[l] = chars[r];
                        chars[r] = t;
                        l++;
                        r--;
                    }

                    break;
                }
            }

        }

        char[] chars1 = num.toCharArray();

        int ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars1[i]) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == chars1[i]) {
                        ans += (j - i);
                        for (int l = j; l > i; l--) {
                            char t = chars[l];
                            chars[l] = chars[l - 1];
                            chars[l - 1] = t;
                        }
                        break;
                    }
                }
                //System.out.println(chars);
            }
        }

        return ans;
    }
}
