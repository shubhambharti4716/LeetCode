/**
 * @param {number[][]} mat
 * @return {number}
 */
var numSpecial = function(mat) {
    let specials = 0;

    for (let i = 0; i < mat.length; i++) {
        let index = checkRow(mat, i);
        if (index >= 0 && checkColumn(mat, i, index))
            specials++;
    }

    return specials;

    function checkRow(mat, i) {
        let index = -1;
        for (let j = 0; j < mat[0].length; j++) {
            if (mat[i][j] === 1) {
                if (index >= 0)
                    return -1;
                else
                    index = j;
            }
        }
        return index;
    }

    function checkColumn(mat, i, index) {
        for (let j = 0; j < mat.length; j++) {
            if (mat[j][index] === 1 && j !== i)
                return false;
        }
        return true;
    }
};