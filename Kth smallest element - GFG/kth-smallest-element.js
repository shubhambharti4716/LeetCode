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
    let N = parseInt(readLine());
    let arr = readLine().trim().split(" ").map((x) => parseInt(x));
    let k = parseInt(readLine());
    let obj = new Solution();
    let res = obj.kthSmallest(arr,0,N-1,k);
    console.log(res);
  }

}

// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} l (starting index of the array i.e 0)
 * @param {number} r (ending index of the array i.e size-1)
 * @param {number} k
 * @return {number}
*/

class Solution {
  kthSmallest(arr,l,r,k){
    //code here
    function mergeSort(arr){
        if(arr.length >1){
        let mid = Math.floor(arr.length/2)
        let left_arr =arr.slice(0,mid);
        let right_arr = arr.slice(mid)
        
        mergeSort(left_arr);
        mergeSort(right_arr);
        
        let i=0
        let j=0
        let k=0
        while( i < left_arr.length && j < right_arr.length){
            if (left_arr[i] <right_arr[j]){
                arr[k] = left_arr[i]
                i++
            }else{
                arr[k] = right_arr[j]
                j++
            }
            k++
        }
        
        while (i < left_arr.length){
            arr[k] = left_arr[i]
            i++
            k++
        }
        while (j < right_arr.length){
            arr[k] = right_arr[j]
            j++
            k++
        }
        return arr
    }
    }
    mergeSort(arr)
    return arr[k-1]
  }
}