/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isMonotonic = function(nums) {
    let incr = true;
    let decr = true;
    for(let i = 0; i < nums.length - 1; i++){
        if (nums[i] > nums[i + 1]) incr = false;
        if (nums[i] < nums[i + 1]) decr = false;
    }
    return incr || decr
};