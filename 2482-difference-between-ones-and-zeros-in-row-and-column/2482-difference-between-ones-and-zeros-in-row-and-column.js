/**
 * @param {number[][]} grid
 * @return {number[][]}
 */
var onesMinusZeros = function(grid) {
    let onesRow = new Array(grid.length).fill(0);
    let onesCol = new Array(grid[0].length).fill(0);
    const m = grid[0].length;
    const n = grid.length;
    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            if (grid[i][j] != 1) continue;
            onesRow[i]++;
            onesCol[j]++;
        }
    }

    for (let i = 0; i < grid.length; i++) {
        for (let j = 0; j < grid[0].length; j++) {
            grid[i][j] = (2 * onesRow[i]) - m + (2 * onesCol[j]) - n;
        }
    }
    return grid;
};