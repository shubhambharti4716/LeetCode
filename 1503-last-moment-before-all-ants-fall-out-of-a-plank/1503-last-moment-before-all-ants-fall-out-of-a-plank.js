/**
 * @param {number} n
 * @param {number[]} left
 * @param {number[]} right
 * @return {number}
 */
var getLastMoment = function(n, left, right) {
    const maxLeft = left.length === 0 ? 0 : Math.max(...left);
    const minRight = right.length === 0 ? n : Math.min(...right);
    return Math.max(maxLeft, n - minRight);
};