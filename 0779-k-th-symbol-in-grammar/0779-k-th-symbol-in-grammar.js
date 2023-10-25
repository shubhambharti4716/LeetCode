/**
 * @param {number} n
 * @param {number} k
 * @return {number}
 */
var kthGrammar = function(n, k) {
    if (n === 1) {
        return 0; // Base case: when n is 1, there's only one symbol, which is 0.
    }

    const mid = Math.pow(2, n - 2); // Calculate the midpoint of the previous row.

    if (k <= mid) {
        return kthGrammar(n - 1, k); // Recurse on the previous row if k is in the left half.
    } else {
        return 1 - kthGrammar(n - 1, k - mid); // Recurse on the previous row with k adjusted for the right half.
    }
};