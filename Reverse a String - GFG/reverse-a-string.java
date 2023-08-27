//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- >0)
        {
            String str = read.readLine();
            System.out.println(new Reverse().reverseWord(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Reverse
{
    //function to reverse a string
    public static String reverseWord(String str)
    {
        String rev = "";
        //iterating from the end of the string
        for(int i = str.length()-1; i >= 0; i--)
            //appending each character to the reverse string
            rev += str.charAt(i);
            
        //returning the reverse string
        return rev;
    }
}