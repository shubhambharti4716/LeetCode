/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isMonotonic = function(nums) {

    let increasing = true;
    let decreasing = true;

    for(let i = 1 ; i < nums.length ; i++){

        if(nums[i] < nums[i - 1]){
            increasing = false;
        }

        if(nums[i] > nums[i - 1]){
            decreasing = false;
        }
    }

    return increasing || decreasing;
    
};