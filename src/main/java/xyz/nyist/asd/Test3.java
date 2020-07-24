package xyz.nyist.asd;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/11 19:01
 */
public class Test3 {
    public static void main(String[] args) {
        int[] hash = new int[1001];
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        strs = in.nextLine().split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
            hash[arr[i]]++;
        }
        int max = 0, index = -1;
        for (int i = 0; i < 1001; i++) {
            if (max < hash[i] && hash[i] > k) {
                index = i;
                max = hash[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 1001; i++) {
            if (max == hash[i]) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            System.out.println(-1);
        }
        else if (list.size() == 1) {
            System.out.println(index);
        }
        else {
            for (int i = 0; i < strs.length; i++) {
                if (list.contains(arr[i])) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }


    }
}
