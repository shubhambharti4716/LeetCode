//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        int l=0,r=n-1;
        int left_index=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]<x){
                l=mid+1;
            }else{
                r=mid-1;
                left_index=mid;
            }
        }
        l=0;
        r=n-1;
        int right_index=-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]<=x){
                l=mid+1;
                right_index=mid;
            }else{
                r=mid-1;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        if(arr[left_index]!=x || arr[right_index]!=x){
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        ans.add(left_index);
        ans.add(right_index);
        return ans;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends