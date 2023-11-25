/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getSumAbsoluteDifferences = function(nums) {
    let totalSum = nums.reduce((sum, n) => sum + n, 0);
    let left = 0, right = totalSum;
    let result = [];

    for (let i = 0; i < nums.length; i++) {
        right -= nums[i];
        result.push(nums[i] * i - left + right - nums[i] * (nums.length - i - 1));
        left += nums[i];
    }

    return result;
};