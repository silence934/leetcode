package xyz.nyist.test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author: silence
 * @Date: 2022/5/13 17:11
 * @Description: https://leetcode.cn/problems/one-away-lcci/submissions/
 */
public class Test {

    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        boolean tag = true;

        if (first.length() == second.length()) {
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    if (tag) {
                        tag = false;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }

        int m = 0, n = 0;

        while (m < first.length() && n < second.length()) {
            if (first.charAt(m) == second.charAt(n)) {
                m++;
                n++;
            } else {
                if (tag) {
                    if (first.length() > second.length()) {
                        m++;
                    } else {
                        n++;
                    }
                    tag = false;
                } else {
                    return false;
                }
            }
        }


        return true;
    }


    public static void main(String[] args) {
        String[] sample = {"5", "2", "C", "D", "+"};
        System.out.println(new Test().solution(sample));
    }


    public int solution(String[] a) {
        LinkedList<Integer> list = new LinkedList<>();

        for (String str : a) {
            switch (str) {
                case "+": {
                    Integer last = list.removeLast();
                    Integer second = list.getLast();
                    list.addLast(last);
                    list.addLast(last + second);
                    break;
                }
                case "D": {
                    Integer last = list.getLast();
                    list.addLast(last * 2);
                    break;
                }
                case "C": {
                    list.removeLast();
                    break;
                }
                default: {
                    list.addLast(Integer.parseInt(str));
                }
            }
        }

        int ans = 0;
        for (Integer i : list) {
            ans += i;
        }

        return ans;
    }

    public int solution2(int[] a) {
        int[][] dp = new int[a.length][a.length];

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
            for (int j = i; j < a.length; j++) {
                set.add(a[j]);
                dp[i][j] = set.size();
                max = Math.max(max, set.size());
            }
            set = new HashSet<>();
        }

        int min = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (dp[i][j] == max) {
                    min = Math.min(min, j - i + 1);
                }
            }
        }

        return min;
    }

    public int solution1(String[] n, String[] r) {
        int groupNumber = 0;

        int passedNumber = 0;

        String pre = null;
        boolean isFail = false;
        for (int i = 0; i < n.length; i++) {
            String currPre = getPre(n[i]);
            if (i == 0) {
                pre = currPre;
            }

            if (!currPre.equals(pre)) {
                groupNumber++;
                if (!isFail) {
                    passedNumber++;
                }
                isFail = false;
                pre = currPre;
            }

            if (!"passed".equals(r[i])) {
                isFail = true;
            }

        }
        groupNumber++;

        if (!isFail) {
            passedNumber++;
        }


        return passedNumber * 100 / groupNumber;
    }


    private String getPre(String s) {
        int i = 0;
        while (i < s.length() && !Character.isDigit(s.charAt(i))) {
            i++;
        }
        return s.substring(0, i);
    }


    public int[] missingTwo(int[] nums) {
        boolean b1 = false, b2 = false;


        for (int num : nums) {
            num = Math.abs(num);
            if (num == 1) {
                b1 = true;
            } else if (num == nums.length + 2) {
                b2 = true;
            } else {
                nums[num - 2] = -nums[num - 2];
            }
        }


        if (!b1 && !b2) {
            return new int[]{1, nums.length + 2};
        } else if (!b1) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return new int[]{1, i + 2};
                }
            }
        } else if (!b2) {

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    return new int[]{i + 2, nums.length + 2};
                }
            }

        } else {
            int t = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    if (t > 0) {
                        return new int[]{t, i + 2};
                    }
                    t = i + 2;
                }
            }
        }

        return null;
    }

}
