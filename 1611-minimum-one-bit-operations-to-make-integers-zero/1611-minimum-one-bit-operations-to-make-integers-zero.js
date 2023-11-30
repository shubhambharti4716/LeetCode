/**
 * @param {number} n
 * @return {number}
 */
function minimumOneBitOperations(n) {
    if (n === 0) {
        return 0;
    }

    let k = 0;
    let curr = 1;

    while (curr * 2 <= n) {
        curr *= 2;
        k++;
    }

    return Math.pow(2, k + 1) - 1 - minimumOneBitOperations(n ^ curr);
}