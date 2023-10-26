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
                    Solution ob = new Solution();
                    System.out.println(ob.minOperation(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minOperation(int n)
    {
        int count = 0;
        while(n!=0)
            {
                // if n is even then it will be good to
                // reach n from n/2 by multiplying it by 2.
                if(n%2==0)
                    n/=2;
                // if n is odd then we can reach n from n-- only. 
                else
                    n--;
                
                count++;     
            }
        return count;
    }
}