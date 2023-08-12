//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends

class Solution 
{ 
    //binary search function finds the position of the first integer
    //in arr[] which is greater than or equal to 'value'.
    static int binarySearch(int arr[], int l, int h, int value)
    {
        //if new value is greater than all array values,
        //then it is placed at the end.
        if(value>arr[h]) 
            return h+1;
        
        //binary search algorithm.    
        while(h>l)
        {
            int middle = (h+l)/2;
            if(arr[middle] == value) 
                return middle;
            
            if(arr[middle] > value) 
                h = middle;
            
            else 
                l = middle + 1;
        }
        
        return h;
    }

    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        //tail[i] holds the last value in a subsequence of length i+1.
        int[] tail = new int[size];
        tail[0] = a[0];
        
        //the position of last filled index in tail[].
        int lastIndex = 0; 
        
        for(int i=1; i<size; i++)
        {
            //getting the furthest possible index for a[i].
            int index = binarySearch( tail, 0, lastIndex, a[i] );
            
            tail[index] = a[i];
            //updating lastIndex.
            lastIndex = Math.max( lastIndex, index );
        }
        //returning the result.
        return lastIndex + 1;
    }

} 