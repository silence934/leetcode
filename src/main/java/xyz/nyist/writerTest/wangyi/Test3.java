package xyz.nyist.writerTest.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : silence
 * @Date: 2020-09-11 20:25
 * @Description :
 */
public class Test3 {

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        System.out.println(Arrays.toString(test3.split_into_list(2, "11111")));
    }

    public int[] split_into_list(int n, String s) {
        char[] chars = s.toCharArray();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int i = 0;
        for (; i < n; i++) {
            int t = chars[i] - '0';
            list.add(t);
            sum += t;
        }

        while (i < chars.length) {
            int l = test(sum);
            String s1 = s.substring(i, i + l);
            int k = Integer.parseInt(s1);
            if (k != sum) {
                return new int[]{};
            }
            sum += k;
            list.add(k);
            i = i + l;
        }
        int[] res = new int[list.size()];
        for (int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        return res;
    }

    public int test(int k) {
        return Integer.toString(k).length();
    }

}
