package xyz.nyist.sort;

import java.util.Arrays;

/**
 * @author: silence
 * @Date: 2022/3/11 17:10
 * @Description:
 */
public class QuickSort1 {

    public static void main(String[] args) {
        int[] array1 = ArrayUtils.randomArray(100000);
        int[] array2 = Arrays.copyOf(array1, array1.length);


        long start = System.currentTimeMillis();
        sort(array1, 0, array1.length);
        System.out.println("快速排序时间:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Arrays.sort(array2);
        System.out.println("Arrays.sort排序时间:" + (System.currentTimeMillis() - start));


        System.out.println(ArrayUtils.compare(array1, array2));
    }

    private static void sort(int[] nums, int start, int end) {

        if (start >= end - 1) {
            return;
        }

        int base = nums[start];

        int left = start;
        int right = end - 1;

        int index = start;
        while (left != right) {

            while (left != right && nums[right] >= base) {
                right--;
            }

            if (left == right) {
                break;
            }
            nums[index] = nums[right];
            index = right;

            while (left != right && nums[left] <= base) {
                left++;
            }
            if (left == right) {
                break;
            }

            nums[index] = nums[left];
            index = left;

        }

        nums[index] = base;

        sort(nums, start, index);
        sort(nums, index + 1, end);

    }


}
