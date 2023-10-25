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
        let [N,W] =  readLine().trim().split(" ").map((x) => parseInt(x));
        let val =  readLine().trim().split(" ").map((x) => parseInt(x));
        let wt =  readLine().trim().split(" ").map((x) => parseInt(x));
        let obj = new Solution();
        let res = obj.knapSack(N,W,val,wt);
        if(res === -0)
            res = 0;
        console.log(res);
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number} N
 * @param {number} W
 * @param {number[]} val
 * @param {number[]} wt
 * @return {number}
*/

class Solution {

    knapSack(N,W,val,wt){
       // initialize dp array
        let dp = new Array(W+1).fill(0);
        let ans = 0;

        for(let i=0; i<W+1; i++) {
            for (let j=0; j<N; j++) {
                if(wt[j] <= i){
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
                }
            }
        }
        
        return dp[W];
    }
}