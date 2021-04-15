package xyz.nyist.writerTest.quna;

import java.util.*;

/**
 * @author: silence
 * @Date: 2021/4/12 18:17
 * @Description:
 */
public class Main1 {

    static int topK(int[] array, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        Integer value = values.get(values.size() - k);
        for (Integer key : map.keySet()) {
            if (map.get(key).equals(value)) {
                return key;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _array_size = 0;
        _array_size = Integer.parseInt(in.nextLine().trim());
        int[] _array = new int[_array_size];
        int _array_item;
        for (int _array_i = 0; _array_i < _array_size; _array_i++) {
            _array_item = Integer.parseInt(in.nextLine().trim());
            _array[_array_i] = _array_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = topK(_array, _k);
        System.out.println(String.valueOf(res));

    }
}
