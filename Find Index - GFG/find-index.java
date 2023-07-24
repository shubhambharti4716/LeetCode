//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;




class Array
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	    {
	    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    int key = sc.nextInt();
		    Solution ob=new Solution();
		    int ar[]=ob.findIndex(arr,n,key);
		    System.out.println(ar[0]+" "+ar[1]);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    // Function to find starting and end index 
    static int[] findIndex(int a[], int N, int key) 
    { 
        int start = -1;
        int[] arr = new int[2];
        
        //traverse from beginning to find first occurence
        for(int i=0; i<N; i++){
            if(a[i] == key) {
                start = i;
                break;
            }
        }
        // traverse from end to find last occurence
        int end = start;
        for(int i=N-1; i>=0; i--){
            if(a[i] == key){
                end = i;
                break;
            }
        }
        arr[0] = start;
        arr[1] = end;
        return arr;
    }
}