//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        // array which stores the minimum steps
        // to reach i from start
        int[] ans = new int[100001];

        // -1 indicated the state has not been visited
        Arrays.fill(ans, -1);
        int mod = 100000;

        // queue to store all possible states
        Queue<Integer> q = new LinkedList<>();

        // initially push the start
        q.add(start % mod);

        // to reach start we require 0 steps
        ans[start] = 0;

        // till all states are visited
        while (!q.isEmpty()) {

            // pop and get the topmost element in the queue
            int top = q.poll();

            // if the topmost element is end
            if (top == end) return ans[end];

            // perform multiplication with all array elements
            for (int i = 0; i < arr.length; i++) {
                int pushed = top * arr[i];
                pushed = pushed % mod;

                // if not visited, then push it to queue
                if (ans[pushed] == -1) {
                    ans[pushed] = ans[top] + 1;
                    q.add(pushed);
                }
            }
        }

        return -1;
    }
}