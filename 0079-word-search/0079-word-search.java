class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        int visited[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(word.charAt(0)==board[i][j]){
                    if(find_val(board,visited,i,j,0,word)) return true;
                }
            }
        }
        return false;
    }

    public static boolean find_val(char[][] arr, int[][] visited, int i, int j, int ind, String s) {
        if (ind == s.length()) return true;
        if (i==-1||i==arr.length||j==-1||j==arr[0].length || visited[i][j] == 1 || s.charAt(ind) != arr[i][j])
            return false;
        visited[i][j] = 1;
        boolean k = find_val(arr,visited,i+1,j,ind+1,s) ||
                     find_val(arr,visited,i-1,j,ind+1,s) ||
                     find_val(arr,visited,i,j+1,ind+1,s) ||
                     find_val(arr,visited,i,j-1,ind+1,s);
        visited[i][j] = 0;
        return k;
    }
}