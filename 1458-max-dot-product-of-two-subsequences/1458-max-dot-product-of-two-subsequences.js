/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var maxDotProduct = function(nums1, nums2) {
    const n = nums1.length, m = nums2.length;
    const dp = Array.from({length: n}, () => new Int32Array(m));
    dp[0][0] = nums1[0] * nums2[0];

    for(let i = 1; i < n; ++i) {
        dp[i][0] = Math.max(nums1[i] * nums2[0], dp[i - 1][0]);
    }

    for(let j = 1; j < m; ++j) {
        dp[0][j] = Math.max(nums1[0] * nums2[j], dp[0][j - 1]);
    }

    for(let i = 1; i < n; ++i) {
        for(let j = 1; j < m; ++j) {
            dp[i][j] = nums1[i] * nums2[j] + Math.max(dp[i - 1][j - 1], 0);
            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
        }
    }

    return dp[n - 1][m - 1];
};