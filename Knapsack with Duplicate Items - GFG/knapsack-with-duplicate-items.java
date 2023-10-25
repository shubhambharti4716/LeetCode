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
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // Creating an array to store the maximum value for each weight
        int dp[] = new int[W+1];
		int ans =0;

		for(int i=0; i<W+1; i++) // Iterating through all possible weights
			for (int j=0; j<N; j++) // Iterating through all items
				if(wt[j]<= i) // If the weight of the item is less than or equal to the current weight
					dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]); // Updating the maximum value for the current weight
		return dp[W]; // Returning the maximum value for the total weight
    }
}