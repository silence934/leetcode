package xyz.nyist.test;

/**
 * @Author: silence
 * @Description:
 * @Date:Create：in 2020/5/24 17:40
 */
public class Test {

    /**
     * 思路:
     * 1.先把所有奇数找出来构建一个新的无序奇数数组
     * 2.用和快速排序的思想,确定基数(每次选取low位置的)的位置(按从小到大),确定后该位置的下标是几，这个数就是第几小
     * 3.然后根据这个第几小的几和k比较，如果比k小就往这个基数的后边查找，否则往前查找
     * 4.重复2和3直到基数位置下标和k-1相等 返回该基数
     * 空间复杂度：因为构建了一个额外的基数数组所以为O(n)
     * 时间复杂度: 因为和快速排序类似,所以也是O(nlogn)
     */
    public int findKth(int[] arr, int k) {
        //提取出数组中所有奇数
        int count = 0, t = 0;
        for (int i : arr) {
            if ((i & 1) == 1) {
                count++;
            }
        }
        if (count < k) {
            return 0;
        }
        int[] odds = new int[count];
        for (int i : arr) {
            if ((i & 1) == 1) {
                odds[t++] = i;
            }
        }

        int low = 0, high = odds.length - 1, m = 0, n = odds.length - 1;

        boolean isFirst = true;
        while (low != k - 1) {
            if (low > k - 1) {
                low = m;
                //这里要注意第一次不能减1，下边那个也是
                high = isFirst ? high : high - 1;
                n = high;
            }
            else {
                high = n;
                low = isFirst ? low : low + 1;
                m = low;

            }
            isFirst = false;
            while (low < high) {
                int key = odds[low];
                while (key < odds[high] && low < high) {
                    high--;
                }
                odds[low] = odds[high];
                while (key > odds[low] && low < high) {
                    low++;
                }
                odds[high] = odds[low];
                odds[high] = key;
            }
        }
        return odds[low];
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.findKth(new int[]{92, 5, 88, 13, 80, 7, 1}, 2));

    }
}
