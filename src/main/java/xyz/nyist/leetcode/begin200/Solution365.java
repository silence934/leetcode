package xyz.nyist.leetcode.begin200;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Solution365 {

    public static void main(String[] args) {
        System.out.println(new Solution365().canMeasureWater(104681, 104683, 54));
    }

    public boolean canMeasureWater1(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Set<String> set = new HashSet<>();
        LinkedList<int[]> list = new LinkedList<>();
        list.addLast(new int[]{0, 0});

        while (!list.isEmpty()) {
            int[] last = list.removeLast();
            int x = last[0], y = last[1];
            if (set.contains(x + "-" + y)) {
                continue;
            }
            if (x == targetCapacity || y == targetCapacity || x + y == targetCapacity) {
                return true;
            }

            set.add(x + "-" + y);

            list.addLast(new int[]{Math.max(0, jug2Capacity - y - x), Math.min(jug2Capacity, x + y)});
            list.addLast(new int[]{Math.min(jug1Capacity, x + y), Math.max(0, jug1Capacity - x - y)});
            list.addLast(new int[]{jug1Capacity, y});
            list.addLast(new int[]{0, y});
            list.addLast(new int[]{x, jug2Capacity});
            list.addLast(new int[]{x, 0});
        }

        return false;
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity == 0) {
            return true;
        }
        return canMeasureWater(0, 0, jug1Capacity, jug2Capacity, targetCapacity, new HashSet<>());
    }

    public boolean canMeasureWater(int cur1, int cur2, int jug1Capacity, int jug2Capacity, int targetCapacity, Set<String> set) {
        if (cur1 == targetCapacity || cur2 == targetCapacity || cur1 + cur2 == targetCapacity) {
            return true;
        }
        if (set.contains(cur1 + "-" + cur2)) {
            return false;
        }
        set.add(cur1 + "-" + cur2);


        return canMeasureWater(cur1, jug2Capacity, jug1Capacity, jug2Capacity, targetCapacity, set) ||
                canMeasureWater(jug1Capacity, cur2, jug1Capacity, jug2Capacity, targetCapacity, set) ||
                canMeasureWater(0, cur2, jug1Capacity, jug2Capacity, targetCapacity, set) ||
                canMeasureWater(cur1, 0, jug1Capacity, jug2Capacity, targetCapacity, set) ||
                canMeasureWater(Math.max(cur1 - (jug2Capacity - cur2), 0), Math.min(cur1 + cur2, jug2Capacity), jug1Capacity, jug2Capacity, targetCapacity, set) ||
                canMeasureWater(Math.min(cur1 + cur2, jug1Capacity), Math.max(cur2 - (jug1Capacity - cur1), 0), jug1Capacity, jug2Capacity, targetCapacity, set);
    }

}
