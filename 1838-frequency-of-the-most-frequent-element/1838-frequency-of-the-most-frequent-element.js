/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxFrequency = function(nums, k) {
    nums.sort((a, b) => a - b);
    let i = 0, j = 0, sum = 0, maxLength = 0;

    for (i = 0; i < nums.length; i++) {
        sum += nums[i];

        while ((i - j + 1) * nums[i] - sum > k) {
            sum -= nums[j];
            j++;
        }

        maxLength = Math.max(maxLength, i - j + 1);
    }

    return maxLength;
};