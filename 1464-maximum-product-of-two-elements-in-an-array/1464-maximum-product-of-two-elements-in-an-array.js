/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let temp = nums.sort((a,b) => b - a)
    return (temp[0]-1) * (temp[1]-1)
};