//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total count of testcases
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    //taking total number of elements
		    int n=sc.nextInt();
		    
		    //calling printFibb() method
		    long[] res = new Solution().printFibb(n);
		    
		    //printing the elements of the array
		    for (int i = 0; i < res.length; i++)
		        System.out.print (res[i]+" ");
		    System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return list containing first n fibonacci numbers.
	public static long[] printFibb(int n) 
	{
	    //creating a list to store the numbers. 
	    long[] res = new long[n];
	    int ind = 0;
	    
	    //storing base values for a and b.
        long a=1,b=1;
        
        //pushing 1 once in the list if n>=1 and again if n>=2.
        if(n>=1)
            res[ind++] = 1;
        if(n>=2)
            res[ind++] = 1;
            
         
        for(int i = 2 ; i < n ; ++ i )
        {
            //pushing sum of a and b in the list.
            res[ind++] = a + b;
            long c=a+b;
            
            //updating a as b and b as c (sum of a and b).
            a=b;
            b=c;
        }
        
        //returning the list.
        return res;
    }
}