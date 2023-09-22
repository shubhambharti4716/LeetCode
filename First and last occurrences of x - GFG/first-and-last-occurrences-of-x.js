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
        
        let [n,x] = readLine().trim().split(" ").map((x) => parseInt(x));
        let arr=readLine().trim().split(" ").map((x) => parseInt(x));
        let obj = new Solution();
        let res = obj.find(arr,n,x);
        let s = "";
        for(let it of res){
            s+=it+" ";
        }
        console.log(s);
    }
}

// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number[]} arr
 * @param {number} n
 * @param {number} x
 * @return {number[]}
*/

class Solution {
    find(arr,n,x){
       let a1=-1;
       let a2=-1;
       for(let i=0;i<n;i++){
           if(arr[i]==x){
               a1=i;
               break;
           }
       }
       for(let i=n-1;i>=0;i--){
           if(arr[i]==x){
               a2=i;
               break;
           }
       }
       return [a1,a2];
    }
}