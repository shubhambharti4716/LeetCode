/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    let n = nums.length, res = n;
    const numsU = Array.from(new Set(nums));
    let m = numsU.length;
    numsU.sort((a, b) => a - b);

    for(let i = 0, j = 0; i < m; ++i) {
        while(j < m && numsU[j] < numsU[i] + n) {
            ++j;
        }
        res = Math.min(res, n - j + i);
    }

    return res;
};