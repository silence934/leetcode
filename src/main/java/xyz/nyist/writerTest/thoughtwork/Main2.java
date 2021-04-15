package xyz.nyist.writerTest.thoughtwork;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : fucong
 * @Date: 2021-01-10 17:19
 * @Description :
 */
public class Main2 {
    public static void main(String[] args) {

    }

    public static List<Integer> FindCommonElements(List<Integer> array1, List<Integer> array2) {
        if (CollectionUtils.isEmpty(array1) || array2 == null) {
            return new ArrayList<>();
        }
        int max = array1.get(0);
        for (Integer i : array1) {
            if (i > max) {
                max = i;
            }
        }
        byte[] map = new byte[max + 1];
        for (Integer i : array1) {
            map[i] = 1;
        }

        List<Integer> res = new ArrayList<>();
        for (Integer i : array2) {
            if (i <= max && map[i] == 1) {
                res.add(i);
                map[i] = 0;
            }
        }
        return res;
    }
}
