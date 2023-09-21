//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        //storing sum up to current element including and 
        //excluding it in respective variables.
        int incl_curr = arr[0];    
        int excl_curr = 0;  
        
        //storing sum up to previous element including and 
        //excluding it in respective variables.
        int incl_prev = incl_curr;
        int excl_prev = excl_curr;
        
	    for(int i = 1; i <n; i++)
	    {
	        //updating sum up to current element excluding it as maximum
            //of sum up to previous element excluding and including it.
	        excl_curr = Math.max(incl_prev, excl_prev);
	        
	        //updating sum up to current element including it as sum up to 
            //previous element excluding it + current element.
            incl_curr = excl_prev + arr[i];
            
            //updating sum up to previous element including and 
            //excluding it for next iteration.
            excl_prev = excl_curr;  
            incl_prev = incl_curr;  
	    }
	    //returning the maximum of sum up to current element  
        //including and excluding it.
	    return Math.max(excl_curr, incl_curr);
    }
}