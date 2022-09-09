package xyz.nyist.leetcode.begin000;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: silence
 * @Date: 2021/7/10 12:37
 * @Description:
 */
public class Solution131 {

    public List<List<String>> partition(String s) {
        return test(s, 0, s.length() - 1);
    }


    private List<List<String>> test(String s, int start, int end) {
        List<List<String>> lists = new ArrayList<>();

        if (start == end) {

            LinkedList<String> linkedList = new LinkedList<>();
            linkedList.addFirst("" + s.charAt(start));

            lists.add(linkedList);
            return lists;
        } else if (start > end) {
            LinkedList<String> linkedList = new LinkedList<>();
            lists.add(linkedList);
            return lists;
        }


        for (int i = start; i <= end; i++) {
            if (isH(s, start, i)) {
                String h = s.substring(start, i + 1);
                for (List<String> list : test(s, i + 1, end)) {
                    ((LinkedList<String>) list).addFirst(h);
                    lists.add(list);
                }
            }
        }


        return lists;
    }


    private boolean isH(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

}
