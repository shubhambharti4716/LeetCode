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

function printList(res,n){
    let s="";
    for(let i=0;i<n;i++){
        s+=res[i];
        s+=" ";
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
        let d = input_ar1[1];
        let obj = new Solution();
        let res = obj.rotate(n, d);
        console.log(res[0]);
        //console.log("\n");
        console.log(res[1]);
        //console.log("\n");

    }
}// } Driver Code Ends


// } Driver Code Ends


//User function Template for javascript



/**
 * @param {number} n
 * @param {number} d
 * @returns {number[]}
*/

class Solution{
    rotate(n,d){
        d = d % 16;
        let res = [0, 0];
        
        let temp = n;
        
        let mask = (1 << d) - 1;
        let shift = (temp & mask); 
        temp = (temp >> d);
        temp += (shift << (16 - d));
        res[1] = temp;
    
    
        temp = n;
        mask = ~((1 << (16 - d)) - 1);
        shift = (temp & mask);
        temp = (temp << d);
        temp += (shift >> (16 - d));
        res[0] = temp;
    
        mask = (1 << 16) - 1;
        res[0] = (res[0] & mask);
        
        return res;
    }
}