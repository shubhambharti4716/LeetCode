//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    public String multiplyStrings(String num1,String num2)
    {
          int nn=1,mm=1;  
          if(num1.charAt(0)=='-')
               nn=-1; 
          if(num2.charAt(0)=='-')
               mm=-1; 
          
            int mul= nn*mm;
            int n1 = num1.length();
            int n2 = num2.length();
            if (n1 == 0 || n2 == 0)     return "0";
 
            // will keep the result number in ArrayList in reverse order
           
            int result[] = new int[n1 + n2];
            for(int ii = 0 ;ii<n1 + n2;ii++)
                result[ii] = 0;
 
            int i_n1 = 0; // index by num1
            int i_n2 = 0; // index by num2
 
            // go from right to left by num1
            for (int i = n1 - 1; i >= 0; i--)
            {
                if(num1.charAt(i)=='-')
                  continue;
                int carrier = 0;
                int no1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                i_n2 = 0;
                
                // go from right to left by num2
               
                for (int j = n2 - 1; j >= 0; j--)
                {
                    //System.out.println(j);
                    if(num2.charAt(j)=='-')
                       continue;
                   int no2 = Integer.parseInt(String.valueOf(num2.charAt(j))); 
                    
 
                    int sum = no1 * no2 + result[i_n1 + i_n2] + carrier;
                    
                    carrier = sum / 10;
                    result[i_n1 + i_n2] = sum % 10;
                    
                    i_n2++;
                }
 
                // store carrier in next cell
                if (carrier > 0)
                {
                     result[i_n1 + i_n2] += carrier;
                }
 
                i_n1++;
            }
        
        
            
            int i = n1 + n2 - 1;
            while (i>=0 && result[i] == 0) i--;
 
            // if all were '0's - means either both or one of num1 or num2 were '0'
            if(i == -1) return "0";
 
            // generate the result string
            StringBuffer s = new StringBuffer("");
            StringBuffer p = new StringBuffer("");
            
            while (i >= 0)
                {
                    s.append( Integer.toString(result[i] ) );
                    i--;
                }
            if(mul==-1)
            { 
                p.append("-"); 
                p.append(s); 
                
            }
            else
              p.append(s);
            
            return p.toString();

 
    }
}