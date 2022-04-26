package xyz.nyist.sort;

import java.util.Arrays;

/**
 * @author: fucong
 * @Date: 2022/4/26 21:11
 * @Description:
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] array1 = ArrayUtils.randomArray(100000);
        int[] array2 = Arrays.copyOf(array1, array1.length);
        

        long start = System.currentTimeMillis();
        heapSort(array1);
        System.out.println("堆排序时间:" + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        Arrays.sort(array2);
        System.out.println("Arrays.sort排序时间:" + (System.currentTimeMillis() - start));


        System.out.println(ArrayUtils.compare(array1, array2));
    }


    public static void heapSort(int[] array) {

        for (int i = array.length / 2 - 1; i > -1; i--) {
            adjustHeap(array, i, array.length);
        }


        for (int i = array.length - 1; i > -1; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }


    }


    private static void adjustHeap(int[] heap, int root, int length) {
        if (root * 2 + 1 >= length) {
            return;
        }
        int left = heap[root * 2 + 1];
        int right = root * 2 + 2 >= length ? left : heap[root * 2 + 2];

        if (left >= right) {
            if (left > heap[root]) {
                swap(heap, root * 2 + 1, root);
                adjustHeap(heap, root * 2 + 1, length);
            }
        } else {
            if (right > heap[root]) {
                swap(heap, root * 2 + 2, root);
                adjustHeap(heap, root * 2 + 2, length);
            }
        }

    }


    private static void swap(int[] heap, int a, int b) {
        int t = heap[a];
        heap[a] = heap[b];
        heap[b] = t;
    }


}
