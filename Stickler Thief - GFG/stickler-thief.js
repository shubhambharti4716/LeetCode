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
    for(let i=0;i<t;i++)
    {
        let input_line = readLine().split(' ');
        let n = parseInt(input_line[0]);
        let arr = new Array(n);
        
        input_line = readLine().split(' ').map((x) => parseInt(x));
        for(let i=0;i<n;i++)
            arr[i] = input_line[i];
        
        let obj = new Solution();
        let ans = obj.findMaxSum(arr, n);
        if(ans===-0)
            ans=0;
        console.log(ans);
    }
}

// } Driver Code Ends


//User function Template for javascript
/**
 * @param {number[]} arr
 * @param {number} n
 * @returns {BigInt}
*/

class Solution 
{
    max(x,y){
        return x>y?x:y;
    }
    
    //Function to find the maximum money the thief can get.
    findMaxSum(arr, n)
    { 
        //storing sum up to current element including and 
        //excluding it in respective variables.
        let incl_curr = arr[0];    
        let excl_curr = 0;  
        
        //storing sum up to previous element including and 
        //excluding it in respective variables.
        let incl_prev = incl_curr;
        let excl_prev = excl_curr;
        
	    for(let i = 1; i <n; i++)
	    {
	        //updating sum up to current element excluding it as maximum
            //of sum up to previous element excluding and including it.
	        excl_curr = this.max(incl_prev, excl_prev);
	        
	        //updating sum up to current element including it as sum up to 
            //previous element excluding it + current element.
            incl_curr = excl_prev + arr[i];
            
            //updating sum up to previous element including and 
            //excluding it for next iteration.
            excl_prev = excl_curr;  
            incl_prev = incl_curr;  
	    }
	    //returning the maximum of sum up to current element  
        //including and excluding it.
	    return this.max(excl_curr, incl_curr);
    }
}