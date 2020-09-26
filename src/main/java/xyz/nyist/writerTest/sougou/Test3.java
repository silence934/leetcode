package xyz.nyist.writerTest.sougou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author : fucong
 * @Date: 2020-09-25 19:49
 * @Description :
 */
public class Test3 {
    public static void main(String[] args) {

        //10,14,[[0,1],[0,2],[0,3],[1,4],[3,4],[2,6],[4,5],[5,6],[6,7],[7,8],[6,9],[9,10],[8,-1],[10,-1]]
        Test3 test3 = new Test3();
        Interval[] conn = new Interval[14];
        conn[0] = new Interval(0, 1);
        conn[1] = new Interval(0, 2);
        conn[2] = new Interval(0, 3);
        conn[3] = new Interval(1, 4);
        conn[4] = new Interval(3, 4);
        conn[5] = new Interval(2, 6);
        conn[6] = new Interval(4, 5);
        conn[7] = new Interval(5, 6);
        conn[8] = new Interval(6, 7);
        conn[9] = new Interval(7, 8);
        conn[10] = new Interval(6, 9);
        conn[11] = new Interval(9, 10);
        conn[12] = new Interval(8, -1);
        conn[13] = new Interval(10, -1);
        System.out.println(test3.trim(10, 14, conn));
    }

    public Interval trim(int n, int m, Interval[] conn) {
        int[] hash = new int[n + 1];
        int[] endHash = new int[n + 1];
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> starts = new ArrayList<>();
        for (Interval interval : conn) {
            if (interval.start == 0) {
                starts.add(interval.end);
            }
            else if (interval.end == -1) {
                endHash[interval.start] = 1;
            }
            else {
                if (map.get(interval.start) == null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(interval.end);
                    map.put(interval.start, list);
                }
                else {
                    map.get(interval.start).add(interval.end);
                }
            }
        }

        Interval interval = new Interval(0, 0);
        for (Integer start : starts) {
            Interval t = test(map, start, hash, endHash);
            if (t.start == -1) {
                hash[start] = 0;
            }
            else {
                interval.start += t.start;
                interval.end += t.end;
            }
        }

        return interval;
    }

    private Interval test(Map<Integer, List<Integer>> map, Integer k, int[] hash, int[] endHash) {
        if (k == null) {
            return new Interval(-1, 0);
        }

        if (endHash[k] == 1) {
            return new Interval(1, k);
        }

        List<Integer> list = map.get(k);
        if (list == null) {
            return new Interval(-1, 0);
        }


        if (hash[k] != 0) {
            return new Interval(-2, 0);
        }

        hash[k] = 1;


        Interval interval = new Interval(1, k);
        boolean b = false;
        for (Integer integer : list) {
            Interval t = test(map, integer, hash, endHash);
            if (t.start == -1) {
                hash[k] = 0;
            }
            else if (t.start == -2) {
                b = true;
                continue;
            }
            else {
                b = true;
                interval.start += t.start;
                interval.end += t.end;
            }
        }
        if (b) {
            return interval;
        }
        else {
            return new Interval(-1, 0);
        }

    }

    private static class Interval {
        int start;
        int end;

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
