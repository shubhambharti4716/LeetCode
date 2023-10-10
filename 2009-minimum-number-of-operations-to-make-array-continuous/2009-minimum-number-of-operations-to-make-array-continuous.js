/**
 * @param {number[]} nums
 * @return {number}
 */
const minOperations = function(nums) {
    const n = nums.length;
    nums = [...new Set(nums)].sort((a, b) => a - b);

    let ans = 0, j = 0;
    const len = nums.length;

    for (let i = 0; i < len; ++i) {
        if (nums[i] - nums[j] >= n) {
            ++j;
        }
        if (i - j + 1 > ans) {
            ans = i - j + 1;
        }
    }

    return n - ans;
};