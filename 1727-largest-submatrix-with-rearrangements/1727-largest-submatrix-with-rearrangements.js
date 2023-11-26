/**
 * @param {number[][]} matrix
 * @return {number}
 */
var largestSubmatrix = function(matrix) {
    const m = matrix.length;
    const n = matrix[0].length;

    for (let i = 1; i < m; ++i) {
        for (let j = 0; j < n; ++j) {
            if (matrix[i][j] === 1) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
    }
    
    let ans = 0;
    
    matrix.forEach(row => {
        row.sort((a, b) => b - a);
        for (let j = 0, k = 1; j < n && row[j] > 0; ++j, ++k) {
            const s = row[j] * k;
            ans = Math.max(ans, s);
        }
    });
    
    return ans;
};