class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; 

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = nums[i]; // base case- the player can pick only one number, so                                    their score is the number itself

            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }

        // The first player's score is stored in dp[n-1].
        // If the score is greater than or equal to 0, the first player wins;                       otherwise, the second player wins.
        return dp[n - 1] >= 0;
    }
}
