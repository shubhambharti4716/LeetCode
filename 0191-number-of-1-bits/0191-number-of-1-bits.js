/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let setBitCount = 0;
    while (n !== 0) {
        n &= (n - 1);
        setBitCount++;
    }
    return setBitCount;
};