class Solution {
    public int findDuplicate(int[] nums) {
        int[] freq = new int[nums.length+1];
        for(int i : nums){
            freq[i]++;
        }
        for(int i = 0;i<freq.length; i++){
            if(freq[i]>=2)return i;
        }
        return 0;
    }
}