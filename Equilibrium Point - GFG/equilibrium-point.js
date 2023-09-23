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
        let a = new Array(n);
        let input_ar = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<n;i++)
            a[i] = input_ar[i];
        let obj = new Solution();
        console.log(obj.equilibriumPoint(a, n));
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} a
 * @param {number} n
 * @returns {number}
*/

class Solution {
    // Function to find equilibrium point in the array.
    equilibriumPoint(a, n)
    {
        //We store the sum of all array elements.
        let sum = 0;
        for (let i = 0; i < n; i++) 
           sum += a[i];
    
        //sum2 is used to store prefix sum.
        let sum2 = 0;
        let ans = -1;
        for (let i = 0; i < n; i++) {
            
            //Leaving out the value of current element from suffix sum.
            sum = sum - a[i];
            
            //Checking if suffix and prefix sums are same.
            if (sum2 == sum) {
                //returning the index or equilibrium point.
                return (i + 1);
            }
            
            //Adding the value of current element to prefix sum.
            sum2 = sum2 + a[i];
        }
        return -1;
    }
}