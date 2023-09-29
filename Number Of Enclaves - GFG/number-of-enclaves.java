//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    // Depth First Search function to update grid values to 0 if connected to edge or 0
    void dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
            grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(i + 1, j, grid); // checking down
        dfs(i, j + 1, grid); // checking right
        dfs(i, j - 1, grid); // checking left
        dfs(i - 1, j, grid); // checking up
    }

    // Function to count the number of enclaves on the grid
    int numberOfEnclaves(int[][] grid) {

        int n = grid.length; // number of rows in grid
        int m = grid[0].length; // number of columns in grid

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is on the edge and contains a 1, call dfs to update adjacent connected cells to 0
                if ((i == 0 || j == 0 || i == n - 1 ||
                    j == m - 1) && grid[i][j] == 1) {
                    dfs(i, j, grid);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count += grid[i][j]; // count the remaining 1s on the grid
            }
        }

        return count; // return the count of enclaves
    }
}