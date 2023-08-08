class Solution {
    public int search(int[] nums, int target) {
     int l = 0;
        int r = nums.length-1;
        int m;
        while(l<=r){
            m = (l+r)/2;
            if(nums[m] == target) return m;
            if(nums[m]>=nums[0]){
                if(target>=nums[0] && target<=nums[m]) r = m-1;
                else l = m+1;
            }else{
                if(target>=nums[m] && target<=nums[nums.length-1]) l = m+1;
                else r = m-1;
            }

        }
        return -1;
    }
}