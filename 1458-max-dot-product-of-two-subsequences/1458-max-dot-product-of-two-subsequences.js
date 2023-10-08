/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var maxDotProduct = function(nums1, nums2) {
    const n = nums1.length;
    const m = nums2.length;
    const memo = new Array(n).fill(null).map(() => new Array(m).fill(Number.MIN_SAFE_INTEGER));
    
    const dp = (i, j) => {
        if (i === n || j === m) {
            return Number.MIN_SAFE_INTEGER;
        }
        
        if (memo[i][j] !== Number.MIN_SAFE_INTEGER) {
            return memo[i][j];
        }
        
        memo[i][j] = Math.max(
            nums1[i] * nums2[j] + Math.max(dp(i + 1, j + 1), 0),
            Math.max(dp(i + 1, j), dp(i, j + 1))
        );
        
        return memo[i][j];
    };
    
    return dp(0, 0);
};