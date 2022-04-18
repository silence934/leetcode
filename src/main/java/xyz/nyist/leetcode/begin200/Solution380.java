package xyz.nyist.leetcode.begin200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @author: fucong
 * @Date: 2021/6/30 18:55
 * @Description:
 */
public class Solution380 {

    Set<Integer> set = new HashSet<>();

    Random random = new Random();


    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        return new ArrayList<>(set).get(random.nextInt(set.size()));
    }

}
