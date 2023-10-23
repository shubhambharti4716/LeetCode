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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
public int maxSumIS(int arr[], int n) {
	    int i, j, max = 0;  
	    int msis[] = new int[n];  
	  
	    /* Initialize msis values  
	    for all indexes */
	    // initializing the msis array with the same values as the input array
	    for ( i = 0; i < n; i++ )  
	        msis[i] = arr[i];  
	  
	    /* Compute maximum sum values  
	    in bottom up manner */
	    // calculating the maximum sum increasing subsequence using dynamic programming
	    for ( i = 1; i < n; i++ )  
	        for ( j = 0; j < i; j++ )  
	            if (arr[i] > arr[j] &&  
	                msis[i] < msis[j] + arr[i])  
	                msis[i] = msis[j] + arr[i];  
	  
	    /* Pick maximum of  
	    all msis values */
	    // finding the maximum value in the msis array
	    for ( i = 0; i < n; i++ )  
	        if ( max < msis[i] )  
	            max = msis[i];  
	  
	    return max;  
	}  
}