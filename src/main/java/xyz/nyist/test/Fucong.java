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
        System.out.println('0' - 1);
        System.out.println("12132131213121: " + new Fucong().allPossibilities("12132131213121"));
        System.out.println("121321312131261: " + new Fucong().allPossibilities("121321312131261"));
        System.out.println("60032131211261: " + new Fucong().allPossibilities("60032131211261"));
        System.out.println("60032131260061: " + new Fucong().allPossibilities("60032131260061"));
        System.out.println("6003213126006133: " + new Fucong().allPossibilities("6003213126006133"));
        System.out.println("6003213126006133: " + new Fucong().allPossibilities("123456789"));
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
        if (surplus == 0) {
            if (index != str.length() &&
                    str.length() - index < 3 ||
                    (str.length() - index < 4
                            && (str.charAt(index) < '6') || str.substring(index).equals("600"))) {
                //※全部添加完毕 剩余的字母 满足 长度小于3 或者 (长度小于4  首字母小于6 或者剩余字符串等于600)
                return Collections.singletonList(new Status(str.substring(index), 0));
            }
            return new ArrayList<>();
        }
        if (str.length() - index > 3 * (surplus + 1)) {
            return new ArrayList<>();
        }

        List<Status> ans = new ArrayList<>();
        int t = str.charAt(index) > '5' ? 3 : 4;
        for (int i = 1; i < t; i++) {
            if (index + i >= str.length()) {
                break;
            }
            String s = str.substring(index, index + i);
            List<Status> list = find(str, index + i, surplus - 1, cache);
            for (Status entity : list) {
                if (entity.number == surplus - 1) {
                    ans.add(new Status(s + "*" + entity.str, entity.number + 1));
                }
            }
        }

        if (str.startsWith("600", index)) {
            List<Status> list = find(str, index + 3, surplus - 1, cache);
            for (Status entity : list) {
                if (entity.number == surplus - 1) {
                    ans.add(new Status("600" + "*" + entity.str, entity.number + 1));
                }
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


}
