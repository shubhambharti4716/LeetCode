class Solution {
    public int uniquePathsWithObstacles(int[][] mat) {
        // return tabulation(mat);
        return top_down(mat);
    }

    private int top_down(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        return func(0,0,dp,mat);
    }

    private int func(int n,int m,int[][] dp,int[][] mat){
        if(n >= dp.length || m >= dp[0].length || mat[n][m] == 1)return 0;
        if(n == dp.length-1 && m == dp[0].length-1)return 1;
        
        if(dp[n][m] != 0)return dp[n][m];

        return dp[n][m] = func(n,m+1,dp,mat) + func(n+1,m,dp,mat);
    }

    private int tabulation(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];

        for(int i=0;i<n;i++){
            if(mat[i][0] == 1)break;
            dp[i][0] = 1;
        }
        
        for(int i=0;i<m;i++){
            if(mat[0][i] == 1)break;
            dp[0][i] = 1;
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j] == 1)continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[n-1][m-1];
    }
}