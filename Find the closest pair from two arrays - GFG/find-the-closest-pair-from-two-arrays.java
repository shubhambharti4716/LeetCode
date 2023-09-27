//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String[] element = br.readLine().split(" ");
		    int N = Integer.parseInt(element[0]);
		    int M = Integer.parseInt(element[1]);
		    int arr [] = new int[N];
		    int brr [] = new int[M];
		    String[] elements = br.readLine().split(" ");
		    for(int i=0; i<N; i++)
		        arr[i] = Integer.parseInt(elements[i]);
		        
		    String[] ele = br.readLine().split(" ");
		    for(int i=0; i<M; i++)
		        brr[i] = Integer.parseInt(ele[i]);
		    
		    int X = Integer.parseInt(br.readLine());
		    
		    Solution obj = new Solution();
		    ArrayList<Integer> ans;
		    ans = obj.printClosest(arr, brr, N, M, X);
		    System.out.println(Math.abs(ans.get(0) + ans.get(1) - X));
		}
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        int temp = n;
        n = m;
        m = temp;
        int diff = Integer.MAX_VALUE;
  
        // res_l and res_r are result indexes from ar1[] and ar2[]
        // respectively
        int res_l = 0, res_r = 0;
        
        // Start from left side of ar1[] and right side of ar2[]
        int l = 0, r = n-1;
        while (l<m && r>=0)
        {
            // If this pair is closer to x than the previously
            // found closest, then update res_l, res_r and diff
            if (Math.abs(arr[l] + brr[r] - x) < diff)
            {
              res_l = l;
              res_r = r;
              diff = Math.abs(arr[l] + brr[r] - x);
            }
            
            // If sum of this pair is more than x, move to smaller
            // side
            if (arr[l] + brr[r] > x)
              r--;
            else // move to the greater side
              l++;
        }
        
        while(l<m)
    	{
    	    if (Math.abs(arr[l] + brr[0] - x) < diff)
        	{
        		res_l = l;
        		res_r = 0;
        		diff = Math.abs(arr[l] + brr[0] - x);
        	}
        	l++;
    	}
    	while(r>=0)
    	{
    	    if (Math.abs(arr[m-1] + brr[r] - x) < diff)
        	{
        		res_l = m-1;
        		res_r = r;
        		diff = Math.abs(arr[m-1] + brr[r] - x);
        	}
        	r--;
    	}
    	
        ArrayList<Integer> v = new ArrayList<>();
        
        v.add(arr[res_l]);
        v.add(brr[res_r]);
        return v;
    }
}