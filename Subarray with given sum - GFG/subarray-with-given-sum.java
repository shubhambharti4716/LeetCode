//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        int start = 0;
        int last = 0;
        boolean flag=false;
        int currsum=0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        
         //iterating over the array.
        for(int i=0;i<n;i++)
        {
            //storing sum upto current element.
            currsum+= arr[i];
            
            //checking if current sum is greater than or equal to given number.
            if(currsum>=s)
            {
                last=i;
                //we start from starting index till current index and do the 
                //excluding part while s(given number) < currsum.
                while(s<currsum && start<last)
                {
                    //subtracting the element from left i.e., arr[start]
                    currsum-= arr[start];
                    ++start;
                }
                
                //now if current sum becomes equal to given number, we store 
                //the starting and ending index for the subarray.
                if(currsum==s)
                {
                    res.add(start + 1);
                    res.add(last + 1);
                    
                    //flag is set to true since subarray exists.
                    flag = true;
                    break;
                }
            }
        }
        //if no subarray is found, we store -1 in result else the found indexes.
        if (flag==false) {
            res.add(-1);
        } 
        //returning the result.
        return res;    
    }
}