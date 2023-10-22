/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maximumScore = function(nums, k) {
    let res = nums[k], mini = nums[k], i = k, j=k, n = nums.length;

    while(i > 0 || j < n - 1){
        if(i === 0) {
            ++j;
        } else if (j === n - 1) {
            --i;
        } else if (nums[i - 1] < nums[j + 1]) {
            ++j
        } else {
            --i;
        }
        mini = Math.min(mini,nums[i],nums[j]);
        res = Math.max(res, mini*(j-i+1));
    }
    return res;
};