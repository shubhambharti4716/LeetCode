class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        int prev = nums[n-1];
        long ans = 0;
        for(int i = nums.length-1; i>=0; --i){
            if(nums[i]>prev){
                int k = (nums[i] + prev - 1) / prev;
                ans+=(k-1);
                prev = (int) nums[i]/k;
            }
            else{
                prev = nums[i];
            }
        }
        return ans;
    }
}