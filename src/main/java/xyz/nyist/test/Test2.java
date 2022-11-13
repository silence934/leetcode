package xyz.nyist.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: silence
 * @Date: 2022/11/10 19:07
 * @Description: catapult
 * cat
 */
public class Test2 {
    public static void main(String[] args) {
        System.out.println(new Test2().find("catcapultt", "cat", 0, 0, new HashMap<>()));
    }


    private int find(String s1, String s2, int index1, int index2, Map<String, Integer> cache) {
        if (s2.length() == index2 || s1.length() == index1) {
            return 0;
        }

        String key = index1 + "," + index2;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }


        char c = s2.charAt(index2);

        if (s2.length() == index2 + 1) {
            int i = 0;
            int start = index1;
            while ((start = s1.indexOf(c, start)) != -1) {
                i++;
                start++;
            }
            cache.put(key, i);
            return i;
        }


        int asn = 0;

        for (int i = index1; i < s1.length(); i++) {
            if (s1.charAt(i) == c) {
                asn += find(s1, s2, i + 1, index2 + 1, cache);
            }
        }
        cache.put(key, asn);
        return asn;
    }

}
