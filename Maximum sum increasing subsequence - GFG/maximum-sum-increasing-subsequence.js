//{ Driver Code Starts
//Initial Template for javascript

"use strict";

process.stdin.resume();
process.stdin.setEncoding("utf-8");

let inputString = "";
let currentLine = 0;

process.stdin.on("data", (inputStdin) => {
  inputString += inputStdin;
});

process.stdin.on("end", (_) => {
  inputString = inputString
    .trim()
    .split("\n")
    .map((string) => {
      return string.trim();
    });

  main();
});

function readLine() {
  return inputString[currentLine++];
}

/* Function to print an array */
function printArray(arr, size) {
  let i;
  let s = "";
  for (i = 0; i < size; i++) {
    s += arr[i] + " ";
  }
  console.log(s);
}

function main() {
  let t = parseInt(readLine());
  let i = 0;
  for (; i < t; i++) {
    let n = parseInt(readLine());
    let input1 = readLine().split(" ").map((x)=>parseInt(x));
    let arr = new Array(n);
    for(let j = 0;j<n;j++) arr[j] = input1[j];
    let obj = new Solution();
    let res = obj.maxSumIS(arr,n);
    console.log(res);
  }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} n
 * @return {number}
 */

class Solution {
    maxSumIS(arr,n){
        let maxSum = 0;
        let msis = new Array(n).fill(0);
      
        for (let i = 0; i < n; i++ ) {
            msis[i] = arr[i];
        }

        for (let i = 1; i < n; i++) {
            for (let j = 0; j < i; j++) {
                if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i]) {
                    msis[i] = msis[j] + arr[i];
                }
            }
        }

        for (let i = 0; i < n; i++) {
            if (maxSum < msis[i]) {
                maxSum = msis[i];
            }
        }

        return maxSum;
    }
}