//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

    int mod=1000000007; // Store the value of 10^9 + 7 for later use
    int dp[][]; // Create a 2D array for memoization
    
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp=new int[n+1][sum+1]; // Initialize the memoization array with size (n+1) x (sum+1)
	    for(int i=0;i<n+1;i++){
	        Arrays.fill(dp[i],-1); // Fill the memoization array with -1 for later check
	    }
	    return fun(arr,0,sum); // Call the recursive helper function
	}
	
	public int fun(int arr[],int i,int sum)
	{
	    if(sum==0){ // If the desired sum is 0
	        int j=i;
	        int p=1; // Initialize a variable p with 1
	        while(j<arr.length && arr[j]==0){ // Count the number of 0's in the array starting from index i
	            p++; // Increment the variable p
	            j++; // Move to the next index
	        }
	        return dp[i][sum]=p; // Store the value of p in the memoization array and return p
	    }
	    if(i==arr.length){ // If all array elements are processed
	        return dp[i][sum]=0; // Return 0
	    }
	    if(dp[i][sum]!=-1)return dp[i][sum]; // If the value is already computed, return it from the memoization array
	    if(arr[i]<=sum) // If the current element is less than or equal to the desired sum
	    return dp[i][sum]=(fun(arr,i+1,sum)+fun(arr,i+1,sum-arr[i]))%mod; // Recursively compute the sum with and without the current element and store it in the memoization array
	    else
	    return dp[i][sum]=fun(arr,i+1,sum); // If the current element is greater than the desired sum, recursively compute the sum without the current element and store it in the memoization array
	}
}