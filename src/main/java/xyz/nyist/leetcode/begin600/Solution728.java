package xyz.nyist.leetcode.begin600;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2022/3/31 20:52
 * @Description:
 */
public class Solution728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res=new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (is(i)){
                res.add(i);
            }
        }

        return res;
    }

    private boolean is(int n){
        String s=String.valueOf(n);
        if (s.contains("0")){
            return false;
        }
        for (char c : s.toCharArray()) {
            if (n % (c - '0') !=0){
                return false;
            }
        }
        return true;
    }
}
