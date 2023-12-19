/**
 * @param {number[][]} img
 * @return {number[][]}
 */
var imageSmoother = function(img) {
    const rows = img.length;
    const cols = img[0].length;
    const result = new Array(rows);

    for (let i = 0; i < rows; ++i) {
        result[i] = new Array(cols);

        for (let j = 0; j < cols; ++j) {
            let totalSum = 0;
            let count = 0;

            for (let x = Math.max(0, i - 1); x < Math.min(rows, i + 2); ++x) {
                for (let y = Math.max(0, j - 1); y < Math.min(cols, j + 2); ++y) {
                    totalSum += img[x][y];
                    count += 1;
                }
            }

            result[i][j] = Math.floor(totalSum / count);
        }
    }

    return result;
};