/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    let start1 = 0;
    let end1 = nums.length - 1;
    let mid1;

    let start2 = 0;
    let end2 = nums.length - 1;
    let mid2;

    while(start1 <= end1){
        mid1 = parseInt(start1 + (end1 - start1) / 2);
        if(target <= nums[mid1]){
            end1 = mid1 - 1;
        } else {
            start1 = mid1 + 1;
        }
    }

    while(start2 <= end2){
        mid2 = parseInt(start2 + (end2 - start2) / 2);

        if(nums[mid2] <= target){
            start2 = mid2 + 1;
        } else {
            end2 = mid2 - 1;
        }
    }

     return [nums[start1] === target ? start1 : -1, nums[end2] === target ? end2 : -1];
};