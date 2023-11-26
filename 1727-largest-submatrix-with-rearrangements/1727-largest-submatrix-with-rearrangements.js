
/**
* @param {number[][]} matrix
* @return {number}
*/
var largestSubmatrix = function(matrix) {
    let m = matrix.length;
    let n = matrix[0].length;
    let maxArea = 0;

    // Step 1: Compute the running count of sequential 1s for each column
    for (let i = 1; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (matrix[i][j] === 1) {
                matrix[i][j] += matrix[i - 1][j];
            }
        }
        }

        // Step 2: For each row, sort the counts in non-increasing order
        // Step 3: Compute the maximum area
        for (let i = 0; i < m; i++) {
            let row = matrix[i].slice();
            row.sort((a, b) => b - a); // Sort in non-increasing order

            for (let j = 0; j < n; j++) {
                // Height is row[j], and width is j + 1 since we consider columns from [0, j]
                let area = row[j] * (j + 1);
                maxArea = Math.max(maxArea, area);
                }
        }

        return maxArea;
        };
        