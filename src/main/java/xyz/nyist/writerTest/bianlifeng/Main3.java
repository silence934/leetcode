package xyz.nyist.writerTest.bianlifeng;

import java.util.*;

/**
 * @author: silence
 * @Date: 2021/4/9 18:24
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int k = sc.nextInt();


        LinkedList<Integer> temp = new LinkedList<>();
        List<Integer> list = new ArrayList<>();


        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
            if (i < k) {
                temp.add(nums[i]);
            }
        }
        Collections.sort(temp);
        list.add(temp.getLast());


        for (int i = k; i < nums.length; i++) {
            temp.remove((Object) nums[i - k]);
            temp.add(nums[i]);
            Collections.sort(temp);
            list.add(temp.getLast());
        }

        System.out.println(list);

    }
}
