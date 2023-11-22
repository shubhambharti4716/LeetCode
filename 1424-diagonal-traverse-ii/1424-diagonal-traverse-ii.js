/**
 * @param {number[][]} nums
 * @return {number[]}
 */
var findDiagonalOrder = function(nums) {
    let m = nums.length;
    let maxSum = 0, size = 0, index = 0;
    let map = new Array(100001);
    
    for (let i = 0; i < m; i++) {
        size += nums[i].length;
        for (let j = 0; j < nums[i].length; j++) {
            let sum = i + j;
            if (!map[sum]) map[sum] = [];
            map[sum].push(nums[i][j]);
            maxSum = Math.max(maxSum, sum);
        }
    }
    
    let res = new Array(size);
    for (let i = 0; i <= maxSum; i++) {
        let cur = map[i];
        for (let j = cur.length - 1; j >= 0; j--) {
            res[index++] = cur[j];
        }
    }
    
    return res;
};