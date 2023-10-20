//{ Driver Code Starts
// Initial Template for javascript

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => { inputString += inputStdin; });

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(
        string => { return string.trim(); });

    main();
});

function readLine() {
    return inputString[currentLine++];
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for (; i < t; i++) {
        let N = parseInt(readLine());
        let arr = readLine().trim().split(" ").map((x) => parseInt(x));
        let obj = new Solution();
        let res = obj.isPossible(N, arr);
        if (res === -0) res = 0;
        console.log(res);
    }
}
// } Driver Code Ends


// User function Template for javascript

/**
 * @param {number} N
 * @param {number[]} arr
 * @return {number}
*/

class Solution {
    isPossible(N, arr) {
        // code here
        let totalSum = 0
        
        for(const num of arr) {
            totalSum += this.getDigitSum(num)
        }
        // console.log(totalSum)
        if(totalSum%3 == 0) {
            return 1
        } else {
            return 0
        }
        
    }
    
    getDigitSum(num) {
        
        let sum = 0
        while(num != 0) {
            
            sum += (num%10)
            num = Math.floor(num/10)
        }
        return sum
    }
}