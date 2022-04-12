package xyz.nyist.leetcode.begin800;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: fucong
 * @Date: 2022/4/10 18:25
 * @Description:
 */
public class Solution804 {

    public int uniqueMorseRepresentations(String[] words) {
        Map<Character, String> map = new HashMap<>();
        map.put('a', ".-");
        map.put('b', "-...");
        map.put('c', "-.-.");
        map.put('d', "-..");
        map.put('e', ".");
        map.put('f', "..-.");
        map.put('g', "--.");
        map.put('h', "....");
        map.put('i', "..");
        map.put('j', ".---");
        map.put('k', "-.-");
        map.put('l', ".-..");
        map.put('m', "--");
        map.put('n', "-.");
        map.put('o', "---");
        map.put('p', ".--.");
        map.put('q', "--.-");
        map.put('r', ".-.");
        map.put('s', "...");
        map.put('t', "-");
        map.put('u', "..-");
        map.put('v', "...-");
        map.put('w', ".--");
        map.put('x', "-..-");
        map.put('y', "-.--");
        map.put('z', "--..");


        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (Character c : word.toCharArray()) {
                sb.append(map.get(c));
            }
            set.add(sb.toString());
        }


        return set.size();
    }

}
