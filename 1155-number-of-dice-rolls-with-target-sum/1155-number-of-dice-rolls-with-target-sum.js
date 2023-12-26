// Time complexity: O(n * k * target)
// Space complexity: O(n * target)

const MOD = 1e9 +7;
var numRollsToTarget = function(n, k, target) {
	const memo = Array(n + 1).fill(-1).map(x => Array(target + 1).fill(-1));
	return helper(n, k, target, memo);
};
		
var helper = function(n, k, target, memo) {
	if (n === 0 || target < 0)
		return target === 0 ? 1 : 0;
	
	if (memo[n][target] !== -1)
			return memo[n][target];

	let ways = 0;

	for (let i = 1; i <= k; i++)
		ways = (ways + helper(n - 1, k, target - i, memo)) % MOD;

	return memo[n][target] = ways;
};