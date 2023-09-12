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
        let obj = new Solution();
        let res = obj.isPerfectNumber(n);
        console.log(res);
        
    }
}

// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number} n
 * @return {number}
*/

class Solution {

    isPerfectNumber(N){
        // To store sum of divisors 
        let sum = 1;

        // Find all divisors and add them 
        for(let i=2 ; i<=Math.sqrt(N) ; i++)
        {
            if(N%i==0)
            {
                if(i==N/i)
                    sum+=i;
                else
                {
                    sum+=i;
                    sum+=N/i;
                }
            }
        }

        // If sum of divisors is equal to 
        // N, then N is a perfect number 
        if(sum==N && N!=1)
            return 1;
        else
            return 0;
    }
}