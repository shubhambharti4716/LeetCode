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
    for(let i=0;i<t;i++)
    {
        let input_line = readLine().split(' ');
        let n = parseInt(input_line[0]);
        
        let obj = new Solution();
        let ans = obj.countWays(n);
        if(ans==-0n)
            ans=0n;
        console.log(ans.toString());
    }
}
// } Driver Code Ends


//User function Template for javascript


/**
 * @param {number} n
 * @returns {BigInt}
*/

class Solution 
{
    //Function to count the number of ways in which frog can reach the top.
    countWays(n)
    {
        //we use similar algorithm as Fibonacci series to find the
        //number of ways in which frog can reach the top.

        let mod=BigInt(1e9+7);
    
        //base cases
    	if (n == 1) return BigInt(1);
        if (n == 2) return BigInt(2);
        if (n == 3) return BigInt(4);
        
        //initializing base values.
        let a = BigInt(1), b = BigInt(2), c = BigInt(4), temp;
        
        for (let i = 4; i <= n; i++)
        {
            temp = (a + b + c)%mod;
            //updating a as b and b as c and c as temp (sum of a, b and c).
            a = b;
            b = c;
            c = temp;
        }
        
        //returning the result.
        return c;
    }
}