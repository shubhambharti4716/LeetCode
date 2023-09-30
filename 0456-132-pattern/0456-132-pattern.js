/**
 * @param {number[]} nums
 * @return {boolean}
 */
var find132pattern = function(nums) {
    let n = nums.length;
    if (n < 3) return false;

    let secondLargest = -Infinity
    let stack = []

    for (let i = n - 1; i >= 0; i--) {
        if (nums[i] < secondLargest) return true;
        while (stack.length && nums[i] > stack[stack.length - 1]) {
            secondLargest = stack.pop()
        }

        stack.push(nums[i])
    }
    return false
};