/**
 * @param {number[][]} matrix
 * @return {number[][]}
 */
var transpose = function(matrix) {

    let row = matrix.length
    let col = matrix[0].length
    
   let arr = Array(col).fill(0).map(x => Array(row).fill(0))


   for(let i=0;i<row;i++){
       for(let j=0;j<col;j++){
           arr[j][i] = matrix[i][j]
       }
   }

  return arr
};