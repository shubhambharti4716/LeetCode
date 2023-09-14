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
        let [n,sum] = readLine().trim().split(" ").map((x) => parseInt(x));
        let arr = readLine().trim().split(" ").map((x) => parseInt(x));
        let obj = new Solution();
        let res = obj.perfectSum(arr,n,sum);
        if(res === -0)
            res = 0;
        console.log(res);
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} n
 * @param {number} sum
 * @return {number}
*/

class Solution {
    constructor() {
        this.mod = 1000000007;
        this.dp = [];
        this.N = 0;
    }
    
    fun(pos, sum, arr) {
        if (pos >= this.N)
            return sum === 0 ? 1 : 0;
            
        if (this.dp[pos][sum] !== -1)
            return this.dp[pos][sum];
            
        this.dp[pos][sum] = 0;

        this.dp[pos][sum] = (this.dp[pos][sum] + this.fun(pos + 1, sum, arr)) % this.mod;

        if (arr[pos] <= sum)
            this.dp[pos][sum] = (this.dp[pos][sum] + this.fun(pos + 1, sum - arr[pos], arr)) % this.mod;

        return this.dp[pos][sum];
    }

    perfectSum(arr, n, sum) {
        this.dp = new Array(n + 1).fill().map(() => new Array(sum + 2).fill(-1));
        this.N = n;

        return this.fun(0, sum, arr);
    }
}