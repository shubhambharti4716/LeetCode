/**
 * @param {number[]} arr
 * @return {number}
 */
var maximumElementAfterDecrementingAndRearranging = function(arr) {
    const l = arr.length;
    const counter = new Array(l).fill(0);

    for (let i = 0; i < l; ++i) {
        counter[Math.min(arr[i] - 1, l - 1)] += 1;
    }

    let ans = 1;
    for (let i = 1; i < l; ++i) {
        ans = Math.min(i + 1, ans + counter[i]);
    }

    return ans;
};