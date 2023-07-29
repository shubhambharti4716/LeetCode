class Solution {
    public double soupServings(int n) {
        
        if (n >= 4800) {
            return 1.0;
        }
        int N = (n + 24) / 25;
        double[][] dp = new double[N + 1][N + 1];
        return helper(dp, N, N);
    }
    private double helper(double[][] dp, int A, int B) {
        if (A <= 0 && B <= 0) {
            return 0.5;
        }
        if (A <= 0) {
            return 1.0;
        }
        if (B <= 0) {
            return 0.0;
        }
        if (dp[A][B] > 0) {
            return dp[A][B];
        }
        dp[A][B] = 0.25 * (helper(dp, A - 4, B) + helper(dp, A - 3, B - 1) +                    helper(dp, A - 2, B - 2) + helper(dp, A - 1, B - 3));
        return dp[A][B];
    }
}