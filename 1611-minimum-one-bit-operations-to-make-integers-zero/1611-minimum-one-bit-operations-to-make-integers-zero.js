/**
 * @param {number} n
 * @return {number}
 */
var minimumOneBitOperations = function(n) {
    if (n <= 1) return n;
    let count = 0;
    while ((1 << count) <= n) count++;
    return ((1 << count) - 1) - minimumOneBitOperations(n - (1 << (count - 1)));
};