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
        let res = obj.minOperation(n);
        if(res === -0)
            res = 0;
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

    minOperation(n){ // Function to calculate the minimum number of operations required.
        let cnt = 0; // Initialize a variable to keep track of the number of operations.
        while(n > 0){ // Loop until the input number becomes 0.
            if(n%2){ // Check if the input number is odd.
                n--; // Decrement by 1 if the input number is odd.
               
            } else { // If the input number is even.
                n/=2; // Divide the input number by 2.
            }
            cnt++; // Increment the count of operations.
        }
        return cnt; // Return the total count of operations.
        
    }
}