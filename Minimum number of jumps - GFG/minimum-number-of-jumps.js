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
    let arr = new Array(n);
    let inputArr2 = readLine().split(" ").map((x) => parseInt(x));
    for(let j = 0;j < n;j++){
      arr[j] = inputArr2[j];
    }
    let obj = new Solution();
    let res = obj.minJumps(arr,n);
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
     minJumps(arr,n){
        // The number of jumps needed to reach the starting index is 0 
        if (n <= 1) 
            return 0; 

        // Return -1 if not possible to jump 
        if (arr[0] === 0) 
            return -1; 

        // initialization 
        let maxReach = arr[0];  // stores all time the maximal reachable index in the array. 
        let step = arr[0];      // stores the number of steps we can still take 
        let jump = 1; //stores the number of jumps necessary to reach that maximal reachable position. 

        // Start traversing array 
        let i=1; 
        for (i = 1; i < n; i++) { 
            // Check if we have reached the end of the array 
            if (i === n-1) 
                return jump; 

            // updating maxReach 
            maxReach = Math.max(maxReach, i+arr[i]); 

            // we use a step to get to the current index 
            step--; 

            // If no further steps left 
            if (step === 0) { 
                // we must have used a jump 
                jump++; 

                // Check if the current index/position or lesser index 
                // is the maximum reach point from the previous indexes 
                if(i >= maxReach) 
                    return -1; 

                // re-initialize the steps to the amount 
                // of steps to reach maxReach from position i. 
                step = maxReach - i; 
            } 
        } 

        return -1; 
    }
}