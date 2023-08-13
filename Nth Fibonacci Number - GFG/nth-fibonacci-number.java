//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
 
    static int mod = 1000000007;
    int nthFibonacci(int n) {
        //prestoring
        int dp[]=new int[n+5];
        //initializing dp[0] as 0
        dp[0]=0;
        //initializing dp[1] as 1
        dp[1]=1;
        for(int i=2;i<=n;i++){
            //as same as fibonacci formula f(i)=f(i-1)+f(i-2)
            dp[i]=(dp[i-1]+ dp[i-2])%mod;
        }
        //returning nth value
        return dp[n];
    }
};