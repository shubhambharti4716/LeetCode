class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length, INF = m + n;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    continue;
                }
                int top = INF, left = INF;
                if(i - 1 >= 0){
                    top = mat[i - 1][j];
                }
                if(j - 1 >= 0){
                    left = mat[i][j - 1];
                }
                mat[i][j] = Math.min(top, left) + 1;
            }
        }
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(mat[i][j] == 0){
                    continue;
                }
                int bottom = INF, right = INF;
                if(i + 1 < m){
                    bottom = mat[i + 1][j];
                }
                if(j + 1 < n){
                    right = mat[i][j + 1];
                }
                mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }
}