/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortArrayByParity = function(nums) {
    const length = nums.length;
    let left = 0, right = length - 1;
    if (length <= 1) return nums;
    while (left < right) {
        if (nums[right] % 2 === 0) {
            let temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
        } else {
            right--;    
        }
    }
    return nums;
};