package xyz.nyist.leetcode.begin600;

import java.util.*;

/**
 * @author: fucong
 * @Date: 2021/6/25 11:05
 * @Description:
 */
public class Solution752 {
    public static void main(String[] args) {
        Solution752 solution752 = new Solution752();
        System.out.println(solution752.openLock(new String[]{}, "0202"));
    }

    public int openLock(String[] deadends, String target) {
        List<String> dead = Arrays.asList(deadends);
        if (dead.contains(target)) {
            return -1;
        }
        if ("0000".equals(target)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Queue<String> queue1 = new LinkedList<>();

        queue.add("0000");
        queue1.add("0000");

        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int l = queue.size();

            for (int i = 0; i < l; i++) {
                String s = queue.poll();
                for (String k : get(s)) {
                    if (dead.contains(k) || queue1.contains(k)) {
                        continue;
                    }
                    if (target.equals(k)) {
                        return step;
                    }
                    queue1.add(k);
                    queue.add(k);
                }

            }

        }


        return -1;
    }


    private List<String> get(String target) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char c = target.charAt(i);
            int temp = c == '9' ? 0 : (Integer.parseInt(c + "") + 1);
            list.add(target.substring(0, i) + temp + target.substring(i + 1));
            temp = c == '0' ? 9 : (Integer.parseInt(c + "") + 1);
            list.add(target.substring(0, i) + temp + target.substring(i + 1));
        }
        return list;
    }
    
}
