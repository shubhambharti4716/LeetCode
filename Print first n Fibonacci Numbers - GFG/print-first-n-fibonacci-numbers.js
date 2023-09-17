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
    let dp = new Array();
    dp.push(BigInt(0));
    dp.push(BigInt(1));
    dp.push(BigInt(1));
    for(let i=4;i<=100;i++)
    {
        dp.push(BigInt(0));
    }
    
    let t = parseInt(readLine());
    for(let i=0;i<t;i++)
    {
        let input_line = readLine().split();
        let N = BigInt(input_line[0]);
        let obj = new Solution();
        let ans = obj.printFibb(N, dp);
        let s = "";
        for(let j=0;j<ans.length;j++)
        {
            s+=ans[j];
            s+=" ";
        }
        console.log(s);
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {BigInt} N
 * @returns {BigInt[]} 
*/
class Solution 
{
    //Function to return list containing first n fibonacci numbers.
    printFibb(N)
    {
        //creating a list to store the numbers. 
        let ans = new Array();
        
        //storing base values for a and b.
        let a= BigInt(1), b= BigInt(1);
        
        //pushing 1 once in the list if n>=1 and again if n>=2.
        if(N>=1)
            ans.push(BigInt(1));
        if(N>=2) 
            ans.push(BigInt(1));
            
      
        for(let i = 2 ; i < N ; ++ i )
        {
            //pushing sum of a and b in the list.
            ans.push(a+b);
            let c=a+b;
            
            //updating a as b and b as c (sum of a and b).
            a=b;
            b=c;
        }
        
        //returning the list.
        return ans;
    }
}