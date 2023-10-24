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
        let S = readLine();
        let obj = new Solution();
        console.log(obj.palindromicPartition(S));
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {string} S
 * @returns {number}
*/

class Solution {
    
    palindromicPartition(S)
    {
        let n = S.length;
        
        // Create two arrays to build the solution in bottom up manner
        // C[i] = Minimum number of cuts needed for palindrome partitioning
        // of substring S[0..i]
        // P[i][j] = true if substring S[i..j] is palindrome, else false
        // Note that C[i] is 0 if P[0][i] is true
        let C = new Array(n);
        let P = new Array(n);
        
        for (let i = 0; i < n; i++) {
            P[i] = new Array(n);
        }
        
        for (let i = 0; i < n; i++) {
            P[i][i] = true;
        }
        
        for (let L = 2; L <= n; L++) {
            for (let i = 0; i < n - L + 1; i++) {
                let j = i + L - 1;   // set ending index
                
                // If L is 2, then we just need to compare two characters. Else
                // need to check two corner characters and value of P[i+1][j-1]
                if (L === 2) {
                    P[i][j] = S[i] === S[j];
                } else {
                    P[i][j] = (S[i] === S[j]) && P[i + 1][j - 1];
                }
            } 
        }
        
        for (let i = 0; i < n; i++) {
            if (P[0][i]) {
                C[i] = 0;
            } else {
                C[i] = Infinity;
                for (let j = 0; j < i; j++) {
                    if (P[j + 1][i] && C[j] + 1 < C[i]) {
                        C[i] = C[j] + 1;
                    }
                }
            }
        }
        
        return C[n - 1];
    }
}