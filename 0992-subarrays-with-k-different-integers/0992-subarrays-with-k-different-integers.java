class Solution {
    public int calcsubarray(int[] nums, int k) {
        HashMap<Integer,Integer> hs=new HashMap<>();
        int i=0;
        int j=0;
        int ans=0;
        int n=nums.length;
        while(j<n){
            hs.put(nums[j],hs.getOrDefault(nums[j],0)+1);
            if (hs.size() > k) {
                while (hs.size() > k) {
                    hs.put(nums[i], hs.get(nums[i]) - 1);
                    if (hs.get(nums[i]) == 0)
                        hs.remove(nums[i]);
                    i++;
                }
            }
            ans += j - i + 1;
            j++;
        }
        return ans;
    }


    public int subarraysWithKDistinct(int[] nums, int k){
        return calcsubarray(nums,k)-calcsubarray(nums,k-1);
    }
}