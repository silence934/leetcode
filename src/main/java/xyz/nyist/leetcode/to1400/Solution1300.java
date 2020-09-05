package xyz.nyist.leetcode.to1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: silence
 * @Description: 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。
 * <p>
 * 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
 * <p>
 * 请注意，答案不一定是 arr 中的数字。
 * @Date:Create：in 2020/6/14 16:38
 */
public class Solution1300 {

    public static int findBestValue(int[] arr, int target) {
        int count = 0, c = 0;
        Arrays.sort(arr);
        for (int i : arr) {
            count += i;
        }
        if (count < target) {
            return arr[arr.length - 1];
        }
        count = 0;
        int r = target / arr.length, k = 0, i;
        Map<Integer, Integer> map = new HashMap<>();
        while (c < target) {
            for (i = k; i < arr.length; i++) {
                if (arr[i] > r || i == arr.length - 1) {
                    k = i;
                    break;
                }
                count += arr[i];
            }
            map.put(r, Math.abs((c = count + (arr.length - k) * r) - target));
            if (c == target) {
                return r;
            }
            r++;
        }
        r = map.keySet().iterator().next();

        int min = Math.abs(map.get(r) - target);
        for (Integer integer : map.keySet()) {
            if (map.get(integer) < min) {
                min = map.get(integer);
                r = integer;
            }
        }
        return r;
    }

    public static int findBestValue1(int[] arr, int target) {
        int count = 0, c, t, key = 0, min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        //Map<Integer, Integer> map = new HashMap<>();
        int r = target / arr.length, k = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (r < arr[i]) {
                k = i - 1;
                break;
            }
            count += arr[i];
        }
        if (k == arr.length) {
            return arr[arr.length - 1];
        }
        else if (k < 0) {
            if (Math.abs(r * arr.length - target) > Math.abs((r + 1) * arr.length - target)) {
                return r + 1;
            }
            else {
                return r;
            }
        }
        A:
        for (int i = k; i < arr.length; i++) {
            r = arr[i];
            while (i < arr.length - 1 && r < arr[i + 1]) {
                if ((t = Math.abs(target - (c = count + (arr.length - 1 - i) * r))) < min) {
                    key = r;
                    min = t;
                }
                //map.put(r, Math.abs(target - (c = count + (arr.length - 1 - i) * r)));
                if (c > target) {
                    k = arr.length;
                    break A;
                }
                r++;
            }
            if (i == arr.length - 1) {
                // map.put(arr[i], Math.abs(count - target));
                if (Math.abs(count - target) < min) {
                    return arr[i];
                }
                break;
            }
            count += arr[i + 1];
        }

        //System.out.println(map);
        return key;
    }

    public static int findBestValue2(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[n - 1];
        int ans = 0, diff = target;
        for (int i = 1; i <= r; ++i) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findBestValue1(new int[]{20204, 21296, 25176, 27249, 60864}, 56803));
    }
}
