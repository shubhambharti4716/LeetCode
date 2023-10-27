//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        //your code here
        if(S==null||S.length()==0)return 0;
        Integer[][]arr=new Integer[S.length()][S.length()];
        return S.length()-palindrome(S,0,S.length()-1,arr);
        
    }
    static int palindrome(String s,int start,int end,Integer[][] A){
        if(start>end){
            return 0;
        }
        if(start==end)return 1;
        if(A[start][end]==null){
        if(s.charAt(start)==s.charAt(end)){
        A[start][end]=2+palindrome(s,start+1,end-1,A);
        }
        else{
        A[start][end]=Math.max(palindrome(s,start+1,end,A),palindrome(s,start,end-1,A));
     }
       }
       return A[start][end];
    }
}