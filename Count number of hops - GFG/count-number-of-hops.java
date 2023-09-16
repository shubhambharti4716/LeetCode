//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG implements Runnable {
    public void run() {
        try {
            BufferedReader in;
            PrintWriter out;
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int t = Integer.parseInt(in.readLine());

            while (t-- > 0) {
                int n = Integer.parseInt(in.readLine().trim());

                Solution g = new Solution();
                out.println(g.countWays(n));
            }
            out.close();
        } catch (Exception e) {
            ;
        }
    }

    public static void main(String args[]) throws IOException {
        new Thread(null, new GFG(), "whatever", 1 << 26).start();
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to count the number of ways in which frog can reach the top.
    static long countWays(int n)
    {
        //we use similar algorithm as Fibonacci series to find the
        //number of ways in which frog can reach the top.

        long mod = 1000000007;
        
        //base cases
    	if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        
        //initializing base values.
        long a = 1, b = 2, c = 4, temp;
        
        for (int i = 4; i <= n; i++)
        {
            temp = (a + b + c)%mod;
            //updating a as b and b as c and c as temp (sum of a, b and c).
            a = b;
            b = c;
            c = temp;
        }
        //returning the result.
        return c;
    }
    
}


