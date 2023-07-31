class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        char[] str1 = s1.toCharArray(), str2 = s2.toCharArray();
        final int m = str1.length, n = str2.length;

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++) {
            dp[i][0] = dp[i - 1][0] + str1[i - 1];
        }
        for(int j = 1;j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + str2[j - 1];
        }
        for(int i = 1;i <= m; i++) {
            for(int j = 1;j <= n; j++) {
                if(str1[i - 1] == str2[j - 1]) 
                    dp[i][j] = dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.min(dp[i - 1][j] + str1[i - 1], dp[i][j - 1] + str2[j - 1]);
            }
        }
        return dp[m][n];
    }
}