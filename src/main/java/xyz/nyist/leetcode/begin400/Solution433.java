package xyz.nyist.leetcode.begin400;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/5/7 15:46
 * @Description:
 */
public class Solution433 {


    private Map<String, List<String>> map;

    private Set<String> set;

    public int minMutation(String start, String end, String[] bank) {

        map = new HashMap<>();
        //判断一下  bank中是否包含 end  如果不包含直接return -1
        boolean b = true;

        //对 bank 处理
        //map:  key可以转换的value
        //双重循环找到 每个bank可以转换的字符串
        for (int i = 0; i < bank.length; i++) {
            if (b && bank[i].equals(end)) {
                b = false;
            }
            for (int j = 0; j < bank.length; j++) {
                if (i != j) {
                    if (canChange(bank[i], bank[j])) {
                        List<String> list = map.getOrDefault(bank[i], new ArrayList<>());
                        list.add(bank[j]);
                        map.put(bank[i], list);
                    }
                }
            }
        }

        //bank中是否包含 end  如果不包含直接return -1
        if (b) {
            return -1;
        }

        //set记录已经遍历过的字符串
        set = new HashSet<>();
        set.add(end);

        //从end开始寻找
        return minMutation(start, end, 1);
    }


    private int minMutation(String start, String end, int length) {
        //如果end可以直接转换成start  返回
        if (canChange(start, end)) {
            return length;
        }
        //如果end在bank中没有可以转换的字符串  直接返回-1  代表这条路走不通
        if (map.get(end) == null) {
            return -1;
        }

        //用来记录转换次数最小的
        int ans = Integer.MAX_VALUE;
        for (String s : map.get(end)) {
            //先判断这个字符串是否使用过  防止走回头路
            if (!set.contains(s)) {
                //要使用这个字符串s  先放入set
                set.add(s);
                //从这个字符串s接着往下找
                int mutation = minMutation(start, s, length + 1);
                //如果这个字符串s可以转换成start   把结果和ans对比
                if (mutation != -1) {
                    ans = Math.min(ans, mutation);
                }
                //换下一个字符串
                set.remove(s);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    //判断字符串  s1和s2可以转换不   逻辑就是判断是否只有一个字符不同
    private boolean canChange(String s1, String s2) {
        boolean ans = false;

        for (int i = 0; i < 8; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (ans) {
                    return false;
                }
                ans = true;
            }
        }

        return ans;
    }


}
