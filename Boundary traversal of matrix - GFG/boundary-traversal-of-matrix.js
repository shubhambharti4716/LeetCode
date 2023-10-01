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
        let m = parseInt(input_line[1]);
        
        input_line = readLine().split(' ');
        let matrix = new Array(n);
        for(let i=0;i<n;i++)
        {
            let a = new Array(m);
            for(let j=0;j<m;j++)
            {
                a[j] =parseInt(input_line[i*m+j]);
            }
            matrix[i] = a;
        }
        
        let obj = new Solution();
        let ans = obj.boundaryTraversal(matrix, n, m);
        let s = "";
        for(let i = 0 ; i < ans.length ;i++)
        {
            if(ans[i]==-0)
                ans[i]=0;
            s+=ans[i];
            s+=" ";
        }
        console.log(s);
    }
}
// } Driver Code Ends


//User function Template for javascript


/**
 * @param {number[][]} matrix
 * @param {number} n
 * @param {number} m
 * @returns {number[]}
*/
class Solution 
{
    //Function to return list of integers that form the boundary 
    //traversal of the matrix in a clockwise manner.
    boundaryTraversal(matrix, n, m)
    {
        let output = new Array();
        
        //base case if number of row or column is 1 then adding all elements.
        if(n == 1)
        {
            let i = 0;
            while(i < m)
                output.push(matrix[0][i++]);
        }
        else if(m == 1)
        {
            let i = 0;
            while(i < n)
                output.push(matrix[i++][0]);
        }
        else
        {
            //we take care of fact that we don't add any number multiple times.
            
            //traversing first row and adding elements in the list.
            for(let j=0; j<m; j++)
                output.push(matrix[0][j]);
            
            //traversing last column and adding elements in the list.
            for(let j=1; j<n; j++)
                output.push(matrix[j][m-1]);
            
            //traversing last row and adding elements in the list.
            for(let j=m-2; j>=0; j--)
                output.push(matrix[n-1][j]);
            
            //traversing first column and adding elements in the list.
            for(let j=n-2; j>=1; j--)
                output.push(matrix[j][0]);
        }
        //returning the list.
        return output;
    }
}