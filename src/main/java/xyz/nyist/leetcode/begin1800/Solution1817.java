package xyz.nyist.leetcode.begin1800;

public class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans=new int[k];
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for (int[] log : logs) {
            map.compute(log[0],(s,oldValue)->{
                if(oldValue==null){
                    oldValue=new HashSet<>(); 
                }
                int size=oldValue.size();
                oldValue.add(log[1]);
                if(size!=oldValue.size()){
                    if(size<=k&&size>0){
                        ans[size-1]--;
                    }
                    if(size<k){
                        ans[size]++;
                    }   
                }
                return oldValue;
            });
        }
        return ans;
    }
}