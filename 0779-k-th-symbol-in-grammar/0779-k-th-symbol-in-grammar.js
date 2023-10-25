/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthGrammar = function(n, k) {
    if (n === 1) {
        return 0;
    }
    const parent = kthGrammar(n - 1, Math.floor((k + 1) / 2));
    if (k % 2 === 0) {
        return parent === 1 ? 0 : 1;
    } else {
        return parent;
    }
};