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
        
        let matrix = new Array(n);
        for(let i=0;i<n;i++)
        {
            input_line = readLine().split(' ');
            let a = new Array(m);
            for(let j=0;j<m;j++)
            {
                a[j] =parseInt(input_line[j]);
            }
            matrix[i] = a;
        }
      
        let obj = new Solution();
        let ans = obj.booleanMatrix(matrix);
        for(let i = 0 ; i < n ;i++)
        {
            let s = "";
            for(let j = 0; j < m; j++)
            {
                s+=matrix[i][j];
                s+=" ";   
            }
            console.log(s);
        }
    }
}
// } Driver Code Ends


//User function Template for javascript


/**
 * @param {number[][]} matrix
*/
class Solution 
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    booleanMatrix(matrix)
    {
        let R = matrix.length;
        let C = matrix[0].length;
        
        //using two list to keep track of the rows and columns 
        //that needs to be updated with 1.
        let row = new Array(R);
        row.fill(0);
        let col = new Array(C);
        col.fill(0);

        for(let i = 0; i < R; i++)
        {
            for(let j = 0; j < C; j++)
            {
                //if we get 1 in matrix, we mark ith row and jth column as 1.
                if(matrix[i][j] == 1){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for(let i = 0; i < R; i++)
        {
            for(let j = 0; j < C; j++)
            {
                //if ith row or jth column is marked as 1, then all elements
                //of matrix in that row and column will be 1.
                if(row[i]==1 || col[j]==1){
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
