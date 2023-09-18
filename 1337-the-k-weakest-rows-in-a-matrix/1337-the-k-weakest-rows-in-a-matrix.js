/**
 * @param {number[][]} mat
 * @param {number} k
 * @return {number[]}
 */
var kWeakestRows = function(mat, k) {
    let countedMat = mat.map(x => x.reduce( (a, b) => a + b));
    
    let indexObj = {};
    
    for(let i = 0; i < countedMat.length; i += 1){
        let key = countedMat[i];
        indexObj[countedMat.indexOf(key)] = key;
        // overwrite matrix to allow indexOf to find duplicated
        countedMat[i] = -1; 
    }

    let keyValues = Object.entries(indexObj);

    let sortedValues = keyValues.sort( (a, b) => a[1] - b[1]);

    let finalIdx = sortedValues.map(x => x[0]).slice(0, k)

    return finalIdx;
};