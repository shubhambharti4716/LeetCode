//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            s = in.readLine().trim().split(" ");
            int ind=0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[ind++]);
                }
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.boundaryTraversal(a, n, m);
            for (int i : ans) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    static ArrayList<Integer> boundaryTraversal(int matrix[][], int n, int m)
    {
        ArrayList<Integer> output = new ArrayList<Integer>();
        
        //base case if number of row or column is 1 then adding all elements.
        if(n == 1)
        {
            int i = 0;
            while(i < m)
                output.add(matrix[0][i++]);
        }
        else if(m == 1)
        {
            int i = 0;
            while(i < n)
                output.add(matrix[i++][0]);
        }
        else
        {   
            //we take care of fact that we don't add any number multiple times.
            
            //traversing first row and adding elements in the list.
            for(int j=0;j<m;j++)
                output.add(matrix[0][j]);
            
            //traversing last column and adding elements in the list.
            for(int j=1;j<n;j++)
                output.add(matrix[j][m-1]);
            
            //traversing last row and adding elements in the list.
            for(int j=m-2;j>=0;j--)
                output.add(matrix[n-1][j]);
            
            //traversing first column and adding elements in the list.
            for(int j=n-2;j>=1;j--)
                output.add(matrix[j][0]);
        }   
        //returning the list.
        return output; 
    }
}
