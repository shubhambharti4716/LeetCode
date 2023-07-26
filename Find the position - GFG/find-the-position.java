//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String n = read.readLine().trim();
            Solution ob = new Solution();
            long ans = ob.findpos(n);
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    long findpos(String n) 
    { 
       int len=n.length();
        int i = 0;
        long position = 0;
        // calculating position character wise
        // imagine the series as tree like structure.
        while (i<len) {
            switch ((int)(n.charAt(i))) 
            {
            case '4':
                position = position * 2 + 1;
                break;
            case '7':
                position = position * 2 + 2; 
                break;
            }
            i++;
        }
        return position;
    }
}