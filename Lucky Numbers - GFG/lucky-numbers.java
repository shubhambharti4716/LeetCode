//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());//testcases
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(reader.readLine());//input n
            //printing "1" if isLucky() returns true else "0"
            Solution s = new Solution();
            System.out.println(s.isLucky(n)? "1" : "0");
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution
{
    public static boolean check(int n,int counter)
    {
        if(counter<=n){
            if(n%counter==0)
                return false;
		    // calculate next position of input number
		    n=n-n/counter;
		    counter++;
		    // make recursive call with updated counter 
		    // and position return check(n, counter);
		    return check(n, counter);
        }    
       	else
       		return true;
    }
    
    
    public static boolean isLucky(int n)
    {
        return check(n,2);
    }
    
}