//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
         int h[] = new int[26];
            Arrays.fill(h, 0);
    	    
        //using hash table to store count of each character.
        for(int i = 0;i<S.length();i++){
            h[S.charAt(i)-'a']++;
        }
    
        
        StringBuilder st = new StringBuilder("");
        
        //iterating over the string.
        for(int i = 0;i<S.length();i++)
        {
            //if count of current character is 1, we return it. 
            if(h[S.charAt(i)-'a'] == 1){
                return(S.charAt(i));
                
            }
        }
        //if there is no non-repeating character then we return '$'.
        return '$';
    }
}

