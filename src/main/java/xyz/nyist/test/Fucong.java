package xyz.nyist.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: silence
 * @Date: 2022/12/02 16:37
 * @Description:
 */
public class Fucong {
    public static void main(String[] args) {
        System.out.println("12132131213121: " + new Fucong().allPossibilities("12132131213121"));
        System.out.println("121321312131261: " + new Fucong().allPossibilities("121321312131261"));
        System.out.println("1213213121312611: " + new Fucong().allPossibilities("1213213121312611"));
        System.out.println("60032131211261: " + new Fucong().allPossibilities("60032131211261"));
        System.out.println("60032131260061: " + new Fucong().allPossibilities("60032131260061"));
        System.out.println("600321312600133: " + new Fucong().allPossibilities("600321312600133"));
        System.out.println("123456789: " + new Fucong().allPossibilities("123456789"));
        System.out.println("600000000000001: " + new Fucong().allPossibilities("600000000000001"));
        System.out.println("60033126600133: " + new Fucong().allPossibilities("60033126600133"));
    }

    public List<String> allPossibilities(String str) {
        List<Status> test = find(str, 0, 4, new HashMap<>());
        return test.stream().map(t -> t.str).collect(Collectors.toList());
    }

    private List<Status> find(String str, int index, int surplus, Map<String, List<Status>> cache) {
        String key = index + "," + surplus;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        List<Status> ans = new ArrayList<>();

        if (surplus == 0) {
            if (index != str.length() && isValidate(str.substring(index))) {
                //※全部添加完毕 剩余的字母组成的数字满足条件
                ans = Collections.singletonList(new Status(str.substring(index), 0));
            }
        } else {
            int offset = 1;
            while (index + offset < str.length()) {
                String s = str.substring(index, index + offset);
                if (!isValidate(s)) {
                    break;
                }

                List<Status> list = find(str, index + offset, surplus - 1, cache);
                for (Status entity : list) {
                    if (entity.number == surplus - 1) {
                        ans.add(new Status(s + "*" + entity.str, entity.number + 1));
                    }
                }
                offset++;
            }
        }

        cache.put(key, ans);
        return ans;
    }

    private static class Status {
        String str;
        Integer number;

        public Status(String str, Integer number) {
            this.str = str;
            this.number = number;
        }
    }

    private boolean isValidate(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        return i == str.length()
                || (str.length() - i < 4 && Integer.parseInt(str.substring(i)) <= 600);
    }

}
