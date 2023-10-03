//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
    	String res = ""; // to store the result
    
    	long temp;
    	while (n > 0)
    	{
    	    n--;
    		temp = n % 26;
    		res += (char)('A' + temp);
    		n /= 26;
    	}
    
    
    	// res contains the answer but in reverse.
    	// hence, reversing it
    	int len = res.length ();
    	String ans = "";
    	for (int  i = len - 1; i >= 0; i--)
    	    ans += res.charAt (i);
    	return ans;
    }
}