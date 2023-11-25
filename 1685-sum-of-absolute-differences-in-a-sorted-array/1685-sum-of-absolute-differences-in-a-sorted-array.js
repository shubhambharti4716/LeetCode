/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getSumAbsoluteDifferences = function(nums) {
    let n = nums.length;
    let arr = new Array(n);
    let leftSum = new Array(n).fill(0);
    let rightSum = new Array(n).fill(0);
    leftSum[0] = 0;
    rightSum[n-1] = 0;
    for(let i=1; i<n; i++) {
        leftSum[i] = leftSum[i-1] + (nums[i] - nums[i-1]) * i;
        rightSum[n-i-1] = rightSum[n-i] + (nums[n-i] - nums[n-i-1]) * i;
    }
    for(let j=0; j<n; j++) {
        arr[j] = leftSum[j] + rightSum[j];
    }
    return arr;
};