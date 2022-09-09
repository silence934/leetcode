package xyz.nyist.writerTest.thoughtwork;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : silence
 * @Date: 2021-01-10 16:34
 * @Description :
 */
public class Main1 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println(swapAdjacent(
                list
        ));
    }

    public static List<Integer> swapAdjacent(List<Integer> array) {
        if (array == null) {
            return null;
        }
        int k = 0;
        while (k <= array.size() - 2) {
            compare(array, k, k + 1);
            k += 2;
        }
        return array;
    }

    public static void compare(List<Integer> array, int i, int j) {
        Integer tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

}
