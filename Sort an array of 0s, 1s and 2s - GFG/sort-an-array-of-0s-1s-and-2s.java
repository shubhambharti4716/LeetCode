//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n){
        // Initialize low, mid, and high pointers
        int low = 0, high = n-1, mid = 0;
        
        // Iterate until mid pointer is less than or equal to high pointer
        while(mid <= high){
            // If element at mid pointer is 0
            if(a[mid]==0) {
                // Swap element at low pointer with element at mid pointer
                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                // Increment low and mid pointers
                low++;
                mid++;
            }
            // If element at mid pointer is 1
            else if(a[mid]==1) {
                // Increment mid pointer
                mid++;
            } 
            // If element at mid pointer is 2
            else {
                // Swap element at mid pointer with element at high pointer
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                // Decrement high pointer
                high--;
            }
        }
    }
}

//{ Driver Code Starts.

class GFG {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends