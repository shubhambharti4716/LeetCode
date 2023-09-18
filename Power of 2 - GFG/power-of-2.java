//{ Driver Code Starts
// //Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());//testcases
        
        while(t-- > 0)
        {
            //input a number n
            long n = Long.parseLong(read.readLine());
            
            
            // if n is less than equal to zero then 
            //it can't be a power of 2 so we print No
            if(new Solution().isPowerofTwo(n) == true)
              System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        
        if(n==0){
        return false;
        }
    
        //We use a counter variable to count number of set bits.
        int count = 0;
        while(n>0)
        {
            //Increment of counter variable if we get 1 as the rightmost bit.
            count+=(n&1);
            //Right Shift n to remove the rightmost bit.
            n>>=1;
        }
        //returning true if number of set bits is 1 otherwise false.
        return count==1;
        
    }
    
}