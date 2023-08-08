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
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        int ans=0;
        HashMap<Integer,HashMap<Integer,Integer>> hm=new HashMap<>();
        for(int i=0;i<n;i++){
            int x=numerator[i],y=denominator[i];
            int g=gcd(x,y);
            x/=g;
            y/=g;
            if(hm.containsKey(y-x) && hm.get(y-x).containsKey(y)){
                ans+=hm.get(y-x).get(y);
            }
            if(hm.containsKey(x)){
                HashMap<Integer,Integer> internalMap=hm.get(x);
                internalMap.put(y,internalMap.getOrDefault(y,0)+1);
            }else{
                HashMap<Integer,Integer> internalMap=new HashMap<>();
                internalMap.put(y,1);
                hm.put(x,internalMap);
            }
        }
        return ans;
    }
    public static int gcd(int a,int b)
    {
        if(b==0)return a;
        return gcd(b,a%b);
    }
}
        
