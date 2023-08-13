class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 3];
        dp[0] = dp[1] = dp[2] = true;
        dp[4] = nums[0] == nums[1];

        for (int i = 2, k = 5; i < n; i++, k++) {
            dp[k] = (dp[k - 2] && nums[i] == nums[i - 1]) ||
                (
                    dp[k - 3] &&
                    (
                        (nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) ||
                        (nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1)
                    )
                );
        }

        return dp[n + 2];
    }
}