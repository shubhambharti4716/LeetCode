class Solution {
    public int strangePrinter(String s) {
        return tab(s);
    }
    private int tab(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int k = 0; k < n; k++) {
            for(int i = 0, j = k; j < n; i++, j++) {
                if(k == 0) dp[i][j] = 1;
                else {
                    int res = Integer.MAX_VALUE;
                    for(int m = i; m < j; m++) {
                        res = Math.min(res, dp[i][m] + dp[m + 1][j]);
                    }
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? res - 1 : res;
                }
            }
        }
        return dp[0][n - 1];
    }
}