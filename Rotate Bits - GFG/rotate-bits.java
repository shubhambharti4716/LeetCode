//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.rotate (n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
            
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    ArrayList<Integer> rotate(int N, int D)
    {
        // your code here
        D = D % 16;
        ArrayList<Integer> res=new ArrayList<>();
        res.add(0);
        res.add(0);
        
        // storing n in a temporary variable
        int temp = N;
        
        int mask = (1 << D) - 1; // picking up the leftmost d bits
        int shift = (temp & mask); 
        temp = (temp >> D); // moving the remaining bits to their new location
        temp += (shift << (16 - D)); // adding removed bits at rightmost end
        res.set(1,temp); // storing the new number
    
    
        temp = N;
        mask = ~((1 << (16 - D)) - 1); // picking the rightmost d bits
        shift = (temp & mask);
        temp = (temp << D); // moving the remaining bits to their new location
        temp += (shift >> (16 - D)); // adding removed bits at leftmost end
        res.set(0,temp); // storing the new number
    
        mask = (1 << 16) - 1;
		res.set(0,(res.get(0) & mask));
		
        return res;
    }
}