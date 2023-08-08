//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int gcd(int a,int b)
    {
        if(a==0) return b;
        if(b==0) return a;
        if(a==b) return a;
        if(a>b) return gcd(a-b,b);
        return gcd(a,b-a);
    }
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        int fractions=0;
        for(int i=0;i<n;i++)
        {
            int gcd=gcd(numerator[i],denominator[i]);
            numerator[i]/=gcd;
            denominator[i]/=gcd;
        }
        Hashtable<List<Integer>,Integer> hash=new Hashtable<>();
        for(int i=0;i<n;i++)
        {
            int x=numerator[i];
            int y=denominator[i];
            int z=y-x;
            List<Integer> lst=new ArrayList<>();
            lst.add(z);
            lst.add(y);
            if(hash.get(lst)!=null)
            {
                fractions+=hash.get(lst);
            }
            List<Integer> lst2=new ArrayList<>();
            lst2.add(x);
            lst2.add(y);
            if(hash.get(lst2)!=null)
            {
                hash.replace(lst2,hash.get(lst2)+1);
            }
            else
            {
                hash.put(lst2,1);
            }
        }
        return fractions;
    }
}
        
