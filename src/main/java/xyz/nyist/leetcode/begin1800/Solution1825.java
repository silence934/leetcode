package xyz.nyist.leetcode.begin1800;

import java.util.*;

/**
 * @author: silence
 * @Date: 2022/9/14 16:16
 * @Description:
 */
public class Solution1825 {

    int m, k;
    TreeMap<Integer, Integer> preK;
    TreeMap<Integer, Integer> sufK;
    TreeMap<Integer, Integer> mid;
    LinkedList<Integer> list;
    private int sum;
    private int index;

    public Solution1825(int m, int k) {
        this.m = m;
        this.k = k;
        this.sum = 0;
        this.preK = new TreeMap<>((a, b) -> b - a);
        this.sufK = new TreeMap<>();
        this.mid = new TreeMap<>();
        this.list = new LinkedList<>();
        this.index = 0;
    }


    public void addElement(int num) {
        index++;
        this.list.addLast(num);
        if (index == m) {
            ArrayList<Integer> array = new ArrayList<>(this.list);
            Collections.sort(array);
            for (int i = 0; i < k; i++) {
                plus(preK, array.get(i));
            }
            for (int i = k; i < array.size() - k; i++) {
                plus(mid, array.get(i));
                sum += array.get(i);
            }
            for (int i = array.size() - k; i < array.size(); i++) {
                plus(sufK, array.get(i));
            }
        } else if (index > m) {
            plus(mid, num);
            sum += num;
            Integer remove = list.removeFirst();
            if (preK.containsKey(remove)) {
                less(preK, remove);
                Map.Entry<Integer, Integer> min = mid.firstEntry();
                sum -= min.getKey();
                less(mid, min.getKey());
                plus(preK, min.getKey());

                while (true) {
                    Map.Entry<Integer, Integer> midLast = mid.lastEntry();
                    Map.Entry<Integer, Integer> sufFirst = sufK.firstEntry();
                    if (midLast.getKey() > sufFirst.getKey()) {
                        less(mid, midLast.getKey());
                        sum -= midLast.getKey();
                        plus(sufK, midLast.getKey());
                        less(sufK, sufFirst.getKey());
                        plus(mid, sufFirst.getKey());
                        sum += sufFirst.getKey();
                    } else {
                        break;
                    }
                }

            } else if (mid.containsKey(remove)) {
                less(mid, remove);
                sum -= remove;


                while (true) {
                    Map.Entry<Integer, Integer> midLast = mid.lastEntry();
                    Map.Entry<Integer, Integer> sufFirst = sufK.firstEntry();
                    if (midLast.getKey() > sufFirst.getKey()) {
                        less(mid, midLast.getKey());
                        sum -= midLast.getKey();
                        plus(sufK, midLast.getKey());
                        less(sufK, sufFirst.getKey());
                        plus(mid, sufFirst.getKey());
                        sum += sufFirst.getKey();
                    } else {
                        break;
                    }
                }


                while (true) {
                    Map.Entry<Integer, Integer> preLast = preK.lastEntry();
                    Map.Entry<Integer, Integer> midFirst = mid.firstEntry();
                    if (midFirst.getKey() < preLast.getKey()) {
                        less(mid, midFirst.getKey());
                        sum -= midFirst.getKey();
                        plus(preK, midFirst.getKey());
                        less(preK, preLast.getKey());
                        plus(mid, preLast.getKey());
                        sum += preLast.getKey();
                    } else {
                        break;
                    }
                }


            } else if (sufK.containsKey(remove)) {
                less(sufK, remove);
                Map.Entry<Integer, Integer> max = mid.lastEntry();
                sum -= max.getKey();
                less(mid, max.getKey());
                plus(sufK, max.getKey());

                while (true) {
                    Map.Entry<Integer, Integer> preLast = preK.lastEntry();
                    Map.Entry<Integer, Integer> midFirst = mid.firstEntry();
                    if (midFirst.getKey() < preLast.getKey()) {
                        less(mid, midFirst.getKey());
                        sum -= midFirst.getKey();
                        plus(preK, midFirst.getKey());
                        less(preK, preLast.getKey());
                        plus(mid, preLast.getKey());
                        sum += preLast.getKey();
                    } else {
                        break;
                    }
                }
            }

        }

        System.out.println(index);
        System.out.println(preK);
        System.out.println(mid);
        System.out.println(sufK);
        System.out.println();

    }


    private void less(Map<Integer, Integer> map, Integer key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }

    }

    private void plus(Map<Integer, Integer> map, Integer key) {
        map.compute(key, (k, oldValue) -> oldValue == null ? 1 : oldValue + 1);
    }


    public int calculateMKAverage() {
        if (m > index) {
            return -1;
        }
        return sum / (m - k - k);
    }

}
