/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {
    let mask = 0x55555555;
    return n > 0 && (n & (n - 1)) === 0 && (n & mask) === n;
};