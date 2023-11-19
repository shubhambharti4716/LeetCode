/**
 * @param {number[]} nums
 * @return {number}
 */
var reductionOperations = function(nums) {
    const n = nums.length;
    const freq = new Array(50001).fill(0);
    for (let i = 0; i < n; i++) {
        freq[nums[i]]++;
    }
    let res = 0, operations = 0;
    for (let i = 50000; i >= 1; i--) {
        if (freq[i] > 0) {
            operations += freq[i];
            res += operations - freq[i];
        }
    }
    return res;
};