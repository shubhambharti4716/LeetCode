//{ Driver Code Starts
//Initial Template for javascript

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
        let input_ar0 = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<n;i++)
            arr[i] = input_ar0[i];
    
        let obj = new Solution();
        arr = obj.convertToWave(n, arr);
        let ans = "";
        for(let element of arr) ans += element + " ";
        
        console.log(ans);
    }
}
// } Driver Code Ends


//User function Template for javascript

class Solution {
    // arr: input array
    // n: size of array
    //Function to sort the array into a wave-like array.
    convertToWave(n, arr)
    {
        for (let i = 0; i + 1 < n; i += 2)
            [arr[i], arr[i + 1]] = [arr[i + 1], arr[i]];  
        return arr;
    }
}