//{ Driver Code Starts
//Initial Template for javascript

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let arr = new Array(n);
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<n;i++)
            arr[i] = input_ar1[i];
        let obj = new Solution();
        let ok = obj.equalPartition(arr, n);
        if(ok)
            console.log("YES");
        else
            console.log("NO");
    }
}

// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} n
 * @returns {boolean}
*/

class Solution {
    
    equalPartition(arr, N)
    {
        // Calculate the total sum of elements in the array.
        let sum = 0;
        for(let i = 0;i < N;i++)
            sum = sum + arr[i];
        
        // If sum is odd, return 0 as equal partition is not possible.
        if(sum%2 == 1)
            return 0;
        
        // Calculate the target sum for each subset.
        sum = sum/2;
        
        // Create a 2D array to store the result of subproblems.
        let dp = new Array(N+1);
        for(let i = 0;i<=N;i++){
            dp[i] = new Array(sum+1);
        }
        
        // Initialize the base cases for dynamic programming.
        for(let i= 0;i<dp.length;i++)
            dp[i][0] = true;
        
        for(let i= 1;i<dp.length;i++)
            dp[0][i] = false;
         
        // Use dynamic programming to solve the problem.
        for(let i = 1;i <= N;i++){
            for(let j = 1;j <= sum;j++){
                if(arr[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        
        // Return 1 if equal partition is possible, 0 otherwise.
        return (dp[N][sum]?1:0);
    }
}