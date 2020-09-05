package xyz.nyist.writerTest;

import java.util.Scanner;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/7/18 20:23
 */
public class Test {
   /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] s = str.split(",");
        int[] num = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            num[i] = Integer.parseInt(s[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            int min = num[i], t = i;
            for (int j = i + 1; ; j++) {
                if (j >= s.length) {
                    break;
                }
                if (min > num[j]) {
                    i = j;
                    break;
                }
            }
            if (t == i) {
                list.add(min);
            }
        }
        System.out.println(list.toString().replaceAll("\\[", "").replaceAll("]", ""));
    }*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = sc.nextLine();
        }
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length - 1; i++) {
                char c = arr[i];
                int index = i;
                char max = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > max) {
                        max = arr[j];
                        index = j;
                    }
                }
                if (index != i) {
                    arr[i] = arr[index];
                    arr[index] = c;
                    break;
                }
            }
            System.out.println(String.valueOf(arr));

        }
    }

}

  /*
        2
        321
        326591
}*/
