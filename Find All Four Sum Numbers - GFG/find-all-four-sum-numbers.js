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

function printArray(res, n) {
    let s="";
    for(let i=0;i<n;i++){
        
        for(let j=0;j<res[i].length;j++){
            s+=res[i][j];
            s+=" ";
        }
        s+="$";
        
    }
    console.log(s);
}


function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        let n = input_ar1[0];
        let k = input_ar1[1];
        input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        let arr = [];
        for(let i=0;i<n;i++){
            arr.push(input_ar1[i]);
        }
        let obj = new Solution();
        let res = obj.fourSum(arr, n, k);
        if(res.length===0) {
            console.log(-1);
        } else {
            printArray(res,res.length);
        }
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} n
 * @param {number} k
 * @returns {number[][]} 
 */
 
class Solution {
    fourSum(arr, n, k){
        let ans = [];
        if (arr.length < 4) return ans;
        arr.sort((a, b) => a - b);
        for (let i = 0; i < arr.length - 3; ++i) {
            if (arr[i] > 0 && arr[i] > k) break;
            if (i > 0 && arr[i] === arr[i - 1]) continue;
            for (let j = i + 1; j < arr.length - 2; ++j) {
                if (j > i + 1 && arr[j] === arr[j - 1]) continue;
                let left = j + 1;
                let right = arr.length - 1;
                while (left < right) {
                    let old_l = left;
                    let old_r = right;
                    let sum = arr[i] + arr[j] + arr[left] + arr[right];
                    if (sum === k) {
                        ans.push([arr[i], arr[j], arr[left], arr[right]]);
                        while (left < right && arr[left] === arr[old_l]) left++;
                        while (left < right && arr[right] === arr[old_r]) right--;
                    } else if (sum > k) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}
