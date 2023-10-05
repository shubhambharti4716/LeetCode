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


function main() {
  let t = parseInt(readLine());
  let i = 0;
 
  for (; i < t; i++) {
    let S = readLine().trim();
    let k = parseInt(readLine());
    let obj = new Solution();
    let res = obj.substrCount(S,k);
    if(res==-0){
      res = 0;
    }
    console.log(res.toString());
  }

}

// } Driver Code Ends


//User function Template for javascript

/**
 * @param {string} s
 * @param {number} k
 * @return {number} 
*/

class Solution {
  substrCount(S,k){
    let atMostK = (s, k) => {
        if (k < 0) return 0;
        
        let i = 0, j = 0, cnt = 0;
        let res = 0;
        let m = new Array(26).fill(0);
        
        while (j < s.length) {
            m[s.charCodeAt(j) - 'a'.charCodeAt()]++;
            if (m[s.charCodeAt(j) - 'a'.charCodeAt()] == 1) cnt++;
            
            while (cnt > k) {
                m[s.charCodeAt(i) - 'a'.charCodeAt()]--;
                if (m[s.charCodeAt(i) - 'a'.charCodeAt()] == 0) cnt--;
                i++;
            }
            
            res += (j - i + 1);
            j++;
        }
        
        return res;
    }
    
    return atMostK(S, k) - atMostK(S, k - 1);
  }
}
