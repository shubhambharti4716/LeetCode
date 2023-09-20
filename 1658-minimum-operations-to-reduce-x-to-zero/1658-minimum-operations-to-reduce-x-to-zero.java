class Solution {
    public int minOperations(int[] nums, int x) {
       int n=nums.length;
       int tSum=0;
       int sum=0;
       for(int i=0;i<n;i++)tSum+=nums[i];
       if(tSum<x)return -1;
       if(tSum==x)return n;
       tSum-=x;
       int s=0;
       int e=0;
       int len=0;
       while(e<n){
           sum+=nums[e];
           while(sum>tSum){
               sum=sum-nums[s];
               s++;
           }
           if(sum==tSum){
             len=Math.max(len,(e-s+1));
           }
           e++;
       }
       if(len==0)return -1;
       return n-len;
    }
}