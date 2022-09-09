package xyz.nyist.writerTest.xiaobing;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: silence
 * @Date: 2022/5/27 14:43
 * @Description:
 */
public class Test {


    private final int[] numbers;


    public Test(int[] numbers) {
        this.numbers = numbers;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i]);
        }
        Test test = new Test(numbers);
        test.sort();
        System.out.println("sort后:" + Arrays.toString(numbers));
        System.out.println(test.search(5));
    }


    private void sort() {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int t = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = t;
                }
            }
        }
        //this.sort(0, numbers.length - 1);
    }

    private void sort(int start, int end) {
        if (start + 1 == end) {
            if (numbers[start] > numbers[end]) {
                int t = numbers[end];
                numbers[end] = numbers[start];
                numbers[start] = t;
            }
        } else if (start == end) {
        } else {
            int mid = (start + end) / 2;
            sort(start, mid);
            sort(mid + 1, end);
            marge(start, mid, end);
        }
    }


    private void marge(int start, int mid, int end) {

    }

    private int search(int target) {
        return search(target, 0, numbers.length);
    }

    private int search(int target, int start, int end) {
        int mid = (start + end) / 2;
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] < target) {
            return search(target, mid + 1, end);
        } else {
            return search(target, start, mid - 1);
        }
    }


    //输入 排序 二分查找

}
