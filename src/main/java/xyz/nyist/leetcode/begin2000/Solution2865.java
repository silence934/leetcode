package xyz.nyist.leetcode.begin2000;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution2865 {

    public static void main(String[] args) {
        System.out.println(new Solution2865().maximumSumOfHeights(Arrays.asList(1000000000, 1000000000, 1000000000)));
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {

        //preArr[i]=以i为顶峰,前部分的和(包含i)
        long[] preArr = new long[maxHeights.size()];
        //单调递增的栈
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < maxHeights.size(); i++) {
            long currentHeight = (long) maxHeights.get(i);
            while (!list.isEmpty() && maxHeights.get(list.getLast()) > currentHeight) {
                list.removeLast();
            }

            if (list.isEmpty()) {
                //说明前边没有比当前点更小的了,那前部分的和=(当前位置-0)*当前位置的高度
                preArr[i] = currentHeight * (i + 1);
            } else {
                //说明前边有比自己更小的,最靠近当前节点比当前节点小的位置
                int firstLit = list.getLast();
                //前部分的和=(当前位置-firstLit)*当前位置的高度+preArr[firstLit]
                preArr[i] = currentHeight * (i - firstLit) + preArr[firstLit];
            }
            list.addLast(i);
        }


        long ans = 0;

        long[] sufArr = new long[maxHeights.size()];
        list = new LinkedList<>();

        for (int i = maxHeights.size() - 1; i > -1; i--) {
            long currentHeight = maxHeights.get(i);
            while (!list.isEmpty() && maxHeights.get(list.getLast()) > currentHeight) {
                list.removeLast();
            }

            if (list.isEmpty()) {
                sufArr[i] = currentHeight * (maxHeights.size() - i);
            } else {
                int firstLit = list.getLast();
                sufArr[i] = currentHeight * (firstLit - i) + sufArr[firstLit];
            }
            list.addLast(i);

            ans = Math.max(ans, preArr[i] + sufArr[i] - currentHeight);

        }


        return ans;
    }
}
