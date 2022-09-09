package xyz.nyist.writerTest.bilibili;


/**
 * @Author : silence
 * @Date: 2020-08-13 19:44
 * @Description : 1 4 16 64  1024
 */
public class Solution3 {

    int min=Integer.MAX_VALUE;

    public int GetCoinCount (int N) {
        int n=1024-N;
        int [] arr=new int[]{1,4,16,64};
        test(arr,0,n,0);
        return min;
    }


    public void test(int[] arr,int p,int n,int k){
        if (k>min){
            return;
        }
        if (n==0){
            min=k;
        }
        if (p>3){
            return;
        }
        for (int i = n/arr[p]; i >-1 ; i--) {
                test(arr,p+1,n-arr[p]*i,k+i);
        }
    }


    public static void main(String[] args) {
        Solution3 solution3=new Solution3();
        System.out.println(solution3.GetCoinCount(200));
    }
}
