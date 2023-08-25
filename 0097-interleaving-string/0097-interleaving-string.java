class Solution {
    int[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        dp = new int [s1.length() + 1][s2.length() + 1];

        if (s1.length()+s2.length()!=s3.length()) {
            return false;
        }
        return helper(s1, s2, s3, 0, 0);
    }

    public boolean helper(String s1, String s2, String s3, int i, int j) {
        if (dp[i][j] != 0) {
            return (dp[i][j]== 1) ? true: false ;
        }

        if (i == s1.length() && j == s2.length() && i+j == s3.length()) {
            return true;
        } 

        boolean result = false;
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            result = result || helper(s1, s2, s3, i + 1, j);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            result = result || helper(s1, s2, s3, i, j + 1);
        }

        dp[i][j] = result ?  1 : -1; 
        return result;
    }
}