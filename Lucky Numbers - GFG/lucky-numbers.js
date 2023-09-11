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
        let n = parseInt(readLine());
        let obj = new Solution();
        if(obj.isLucky(n)){
            console.log("1");   
        }
        else{
            console.log("0");   
        }
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {number} n
 * @returns {boolean}
*/

class Solution {
    check(n,counter)
    {
        // variable next_position is just for readability of 
        // the program we can remove it and use n only  
       	if(counter<=n)
       	{
			if(n%counter==0)
				return false;
			//calculate next position of input number
			//Math.floor(n) is used to get largest integer smaller than n
			n=n-Math.floor(n/counter);
			counter++;
			// make recursive call with updated counter and position
			return this.check(n, counter);
       	}      
   		else
   			return true;
        
    }
    isLucky(n)
    {
        return this.check(n,2);   
    }
}