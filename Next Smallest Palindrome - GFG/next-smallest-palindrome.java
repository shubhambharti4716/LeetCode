//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Returns next palindrome of a given
    // number num[]. This function is for
    // input type 2 and 3
    void generateNextPalindromeUtil(int num[], int n) {
        int mid = n / 2;

        // end of left side is always 'mid -1'
        int i = mid - 1;

        // Beginning of right side depends
        // if n is odd or even
        int j = (n % 2 == 0) ? mid : mid + 1;

        // A bool variable to check if copy of left
        // side to right
        // is sufficient or not
        boolean leftsmaller = false;

        // Initially, ignore the middle same digits
        while (i >= 0 && num[i] == num[j]) {
            i--;
            j++;
        }

        // Find if the middle digit(s) need to
        // be incremented or not (or copying left
        // side is not sufficient)
        if (i < 0 || num[i] < num[j]) {
            leftsmaller = true;
        }

        // Copy the mirror of left to tight
        while (i >= 0) {
            num[j++] = num[i--];
        }

        // Handle the case where middle digit(s)
        // must be incremented. This part of code
        // is for CASE 1 and CASE 2.2
        if (leftsmaller) {
            int carry = 1;

            // If there are odd digits, then increment
            // the middle digit and store the carry
            if (n % 2 == 1) {
                num[mid] += 1;
                carry = num[mid] / 10;
                num[mid] %= 10;
            }
            i = mid - 1;
            j = (n % 2 == 0 ? mid : mid + 1);

            // Add 1 to the rightmost digit of the left
            // side, propagate the carry towards MSB digit
            // and simultaneously copying mirror of the
            // left side to the right side.
            // when carry is zero no need to loop through till i>=0
            while (i >= 0 && carry > 0) {
                num[i] = num[i] + carry;
                carry = num[i] / 10;
                num[i] %= 10;
                num[j] = num[i]; // copy mirror to right
                i--;
                j++;
            }
        }
    }

    // The function that prints next palindrome
    // of a given number num[] with n digits.
    Vector<Integer> generateNextPalindrome(int num[], int n) {
        Vector<Integer> ans = new Vector<>();
        // Input type 1: All the digits are 9,
        // simply o/p 1 followed by n-1 0's
        // followed by 1.
        if (isAll9(num, n)) {
            ans.add(1);
            for (int i = 0; i < n - 1; i++) ans.add(0);
            ans.add(1);

        }

        // Input type 2 and 3
        else {
            generateNextPalindromeUtil(num, n);
            for (int i = 0; i < n; i++) {
                ans.add(num[i]);
            }
        }
        return ans;
    }

    // A utility function to check if num has all 9s
    boolean isAll9(int num[], int n) {
        for (int i = 0; i < n; i++)
            if (num[i] != 9) return false;
        return true;
    }
}