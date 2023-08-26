//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        int[] m = new int[128];
        int uniq = 0, i = 0, j = 0, res = 0, n = s.length();

        while (j < n) {
            // sliding the j-pointer till we have a valid substring
            while (j < n) {
                if (m[s.charAt(j)] == 0) uniq++;
                m[s.charAt(j)]++;
                // if the number of uniq characters increases k, we stop.
                if (uniq > k) break;
                j++;
            }

            // checking if the unique characters are equal to k or k + 1
            if (uniq >= k) res = Math.max(res, j - i);

            if (j == n) break;

            // sliding the i-pointer till we again get k unique characters in
            // the substring
            while (i < n) {
                if (m[s.charAt(i)] == 1) uniq--;
                m[s.charAt(i)]--;

                if (uniq == k) break;
                i++;
            }
            i++;
            j++;
        }
        if (res == 0) return -1;
        return res;
    }
}