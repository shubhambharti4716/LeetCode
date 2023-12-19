/**
 * @param {number[][]} img
 * @return {number[][]}
 */
var imageSmoother = function (img) {
  const m = img.length,
    n = img[0].length;
  return img.map((row, i) =>
    row.map((cell, j) => {
      let c = 1;
      if (i > 0) {
        const prevRow = img[i - 1];
        cell += prevRow[j];
        c++;
        if (j > 0) {
          cell += prevRow[j - 1];
          c++;
        }
        if (j < n - 1) {
          cell += prevRow[j + 1];
          c++;
        }
      }
      if (i < m - 1) {
        const nextRow = img[i + 1];
        cell += nextRow[j];
        c++;
        if (j > 0) {
          cell += nextRow[j - 1];
          c++;
        }
        if (j < n - 1) {
          cell += nextRow[j + 1];
          c++;
        }
      }
      if (j > 0) {
        cell += row[j - 1];
        c++;
      }
      if (j < n - 1) {
        cell += row[j + 1];
        c++;
      }

      return ~~(cell / c);
    })
  );
};