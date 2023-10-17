//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        // create a 2D array 'vis' to store the intermediate results
        int vis[][] = new int[N][N];
        
        // initialize 'vis' array with the values of the 'graph' array
        // and set diagonal elements to 1
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++){
                vis[i][j] = graph[i][j];
                if(i==j)
                vis[i][j] = 1;
            }
        }
        
        // modify 'vis' array to find the transitive closure
        // using Floyd-Warshall algorithm
        for(int k =0;k<N;k++){
            for(int i = 0; i<N;i++){
                for(int j =0;j<N;j++){
                    if(vis[i][j]!=0 || (vis[i][k] >0 &&  vis[k][j]>0))
                    vis[i][j] = 1;
                }
            }
        }
        
        // store the transitive closure matrix in an ArrayList of ArrayLists 'al'
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>> ();
        for(int i =0;i<N;i++){
            al.add(new ArrayList<Integer>());
            for(int j =0;j<N;j++){
                al.get(i).add(vis[i][j]);
            }
        }
        
        // return the ArrayList containing the transitive closure matrix
        return al;
    }
}