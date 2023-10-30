/**
 * @param {number[]} arr
 * @return {number[]}
 */
var sortByBits = function(arr) {
    const n = arr.length;
    const res = new Array(n);
    for (let i = 0; i < n; i++) {
        res[i] = countBit(arr[i]) * 10001 + arr[i];
    }
    res.sort((a, b) => a - b);
    for (let i = 0; i < n; i++) {
        res[i] %= 10001;
    }
    return res;
};

function countBit(n) {
    let res = 0;
    while (n !== 0) {
        res += (n & 1);
        n >>= 1;
    }
    return res;
}