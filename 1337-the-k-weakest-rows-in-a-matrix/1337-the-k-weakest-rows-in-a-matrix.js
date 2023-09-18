/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[]}
 */
var kWeakestRows = function(mat, k) {
    let rowStrengths = mat.map((row, i) => [row.reduce((a, b) => a + b, 0), i]);
    rowStrengths.sort((a, b) => a[0] === b[0] ? a[1] - b[1] : a[0] - b[0]);
    return rowStrengths.slice(0, k).map(([_, i]) => i);
};