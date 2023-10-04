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
    let str = readLine();
    let obj = new Solution();
    let res = obj.romanToDecimal(str);
    console.log(res);

  }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {string} str
 * @returns {number}
 */

class Solution {
    romanToDecimal(str){ 
        // This function returns value of a Roman symbol
        function value(r) {
            if (r == 'I') return 1;
            if (r == 'V') return 5;
            if (r == 'X') return 10;
            if (r == 'L') return 50;
            if (r == 'C') return 100;
            if (r == 'D') return 500;
            if (r == 'M') return 1000;
        }

        // Initialize result
        let res = 0;

        // Traverse given input
        for (let i = 0; i < str.length; i++) {
            // Getting value of symbol str[i]
            let s1 = value(str[i]);

            if (i + 1 < str.length) {
                // Getting value of symbol str[i+1]
                let s2 = value(str[i + 1]);

                // Comparing both values
                if (s1 >= s2) {
                    // Value of current symbol is greater or equal to the next symbol
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++; // Value of current symbol is less than the next symbol
                }
            } else {
                res = res + s1;
            }
        }
        
        return res;
    }
}