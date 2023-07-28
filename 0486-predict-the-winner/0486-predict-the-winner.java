class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = Arrays.copyOf(nums, n);
        
        for (int difference = 1; difference < n; difference++) {
            for (int left = 0; left < n - difference; left++) {
                int right = left + difference;
                dp[left] = Math.max(nums[left] - dp[left + 1], nums[right] - dp[left]);
            }
        }
        
        return dp[0] >= 0;
    }
}   