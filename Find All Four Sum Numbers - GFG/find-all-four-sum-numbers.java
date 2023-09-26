//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] a, int k) {
        int n = a.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (n < 4) return ans;

        Arrays.sort(a);
        for (int i = 0; i < n - 3; i++) {
            // current element is greater than k then no quadruplet can be found
            if (a[i] > 0 && a[i] > k) break;

            // removing duplicates
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; ++j) {
                // removing duplicates
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                // taking two pointers
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int old_l = left;
                    int old_r = right;
                    // calculate current sum
                    int sum = a[i] + a[j] + a[left] + a[right];
                    if (sum == k) {
                        // add to answer
                        ans.add(new ArrayList<Integer>(
                            Arrays.asList(a[i], a[j], a[left], a[right])));

                        // removing duplicates
                        while (left < right && a[left] == a[old_l]) left++;
                        while (left < right && a[right] == a[old_r]) right--;
                    } else if (sum > k) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}