//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//taking testcases
		while(t-->0){
			int n=sc.nextInt();//input n
			Solution ob=new Solution();
			System.out.println(ob.getFirstSetBit(n));//calling method
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find position of first set bit in the given number.
    public static int getFirstSetBit(int n)
    {
        if(n==0)
            return 0;
            
        //doing AND operation of n and -n. n and -n will have similar
        //bits only till the first set bit starting from the right  
        //and differnt bits after the first set bit.Then we take 
        //log2 of the result to find the position.
        
        //we add 1 to obtained value so that count starts from 1 instead of 0.
        
        return (int)(Math.log(n&-n)/Math.log(2.0)) + 1;
    }
}