//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxOnes(a, n));
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java


//Back-end complete function Template for Java


class Solution {
    
    public static int maxSubArraySum(int a[],int n)
    {
       int max_so_far=a[0];
       int curr_max=a[0];
    
       for(int i=1;i<n;i++)
       {
            curr_max = Math.max(a[i],curr_max+a[i]);
            max_so_far = Math.max(max_so_far,curr_max);
       }
       max_so_far = Math.max(0,max_so_far);
       return max_so_far;
    }

    public static int maxOnes(int a[], int n) {
        int i, cnt=0;
        for(i=0;i<n;i++)
        {
            if(a[i]==0)
                a[i]=1;
            else
            {
                cnt++;
                a[i]=-1;
            }
        }
        return (cnt+maxSubArraySum(a,n)) ;
    }
}