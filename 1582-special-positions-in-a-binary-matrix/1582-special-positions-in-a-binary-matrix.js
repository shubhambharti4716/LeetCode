/**
 * @param {number[][]} mat
 * @return {number}
 */
var numSpecial = function(mat) {
    for(let row=0; row<mat.length; row++){
        let rowSum = 0;
        let firstRowOne = [];
        for(let col=0; col<mat[0].length; col++){
            rowSum += mat[row][col];
            if(mat[row][col] == 1) firstRowOne = [row, col];
        }
        
        if(rowSum == 1) mat[firstRowOne[0]][firstRowOne[1]] = -1;
    }
    
    let specials = 0;
    for(let col=0; col<mat[0].length; col++){
        let countMinusOne = 0;
        let countOne = 0;
        for(let row=0; row<mat.length; row++){
            if(mat[row][col] == -1) countMinusOne++;  
            if(mat[row][col] == 1) countOne++;  
        }   
         if(countMinusOne == 1 && countOne == 0) specials++;
    }
    return specials;
};