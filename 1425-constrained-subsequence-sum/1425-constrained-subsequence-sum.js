/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */

 // j-i <= k 
var constrainedSubsetSum = function(nums, k) {
     const n = nums.length;
    const dp = new Array(n);
    const deque = [];
    
    dp[0] = nums[0];
    deque.push(0);
    
    for (let i = 1; i < n; i++) {
     
        while (deque.length && i - deque[0] > k) {
            deque.shift();
        }
        
        dp[i] = Math.max(nums[i], nums[i] + dp[deque[0]]);
        

        while (deque.length && dp[i] >= dp[deque[deque.length - 1]]) {
            deque.pop();
        }
        
        deque.push(i);
    }
    
    return Math.max(...dp);
};