package xyz.nyist.writerTest.bilibili;

public class Solution1 {
    public boolean Game24Points (int[] arr) {
        int [][]k1=new int[4][2];
        k1[0][0]=arr[0];
        k1[1][0]=arr[1];
        k1[2][0]=arr[2];
        k1[3][0]=arr[3];

        return test(k1, 24)|| test(arr[0]*arr[1],arr[2]*arr[3])||
        test(arr[0]*arr[1],arr[2]/(double)arr[3])||
        test(arr[0]/(double)arr[1],arr[2]*arr[3])||
        test(arr[0]/(double)arr[1],arr[2]/(double)arr[3])||


        test(arr[0]*arr[2],arr[1]*arr[3])||
        test(arr[0]*arr[2],arr[1]/(double)arr[3])||
        test(arr[0]/(double)arr[2],arr[1]*arr[3])||
        test(arr[0]/(double)arr[2],arr[1]/(double)arr[3])||

        test(arr[0]*arr[3],arr[1]*arr[2])||
        test(arr[0]*arr[3],arr[1]/(double)arr[2])||
        test(arr[0]/(double)arr[3],arr[1]*arr[2])||
        test(arr[0]/(double)arr[3],arr[1]/(double)arr[2]);

    }

    public boolean test(int [][]k,int y){
        if (y==0&&k[0][1]==1&&k[1][1]==1&&k[2][1]==1&&k[3][1]==1){
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (k[i][1]==0){
                k[i][1]=1;
                if (test(k,y-k[i][0])){
                    return true;
                }
                if (test(k,y+k[i][0])){
                    return true;
                }
                if (y%k[i][0]==0&&test(k,y/k[i][0])){
                    return true;
                }
                if (test(k,y*k[i][0])){
                    return true;
                }
                k[i][1]=0;
            }
        }
        return false;
    }

    public boolean test(double x,double y){

        return x+y==24||x-y==24||y-x==24;
    }



    public static void main(String[] args) {
        Solution1 solution1=new Solution1();
        System.out.println(solution1.Game24Points(new int[]{7,2,1,10}));
    }
}
