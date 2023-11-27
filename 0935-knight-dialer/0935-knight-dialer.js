/**
 * @param {number} n
 * @return {number}
 */
var knightDialer = function(n) {

	// if n equals 1, 10 number can be formed, that is with each digit
    if(n === 1) {
        return 10;
    }
    const mod = 1000000007;
	
	// since knight can move in 8 directions, in the dialpad, we know what positions the knight can move when we start from a digit
	// created the map of those positions that can be moved from key `num`
    const map = {1: [6,8], 2: [7,9], 3: [4,8], 4: [0,3,9],
                 5: [], 6: [0,1,7], 7: [2,6], 8: [1,3], 9: [2,4], 0: [4,6]};
    
	// create a dp array of size - 10 * (n + 1), initialize with 0
    const dp = Array(10).fill(null).map(() => Array(n + 1).fill(0));
	
	//initialize the dp array for each num and n = 1 and n = 2 
    let total = 0;
    for(let num = 0; num <= 9; ++num) {
        dp[num][1] = 1;
        dp[num][2] = map[num].length;
        if(n === 2) {
            total += dp[num][2];
        }
    }
	
	// if n > 2, we calculate the total numbers that can be formed from each digit when we start from it
	// `total` will be summation of all the numbers which we will return
    for(let i = 3; i <= n; ++i) {
        for(let num = 0; num <= 9; ++num) {
		
			/* the number of digits that can be formed starting with `num` equals the sum of the number of digits that can be formed by the digits which are reachable from `num`
			for instance, for n = 3 and num = 1, `16` and `18` are two 2 digit number. 
			in order to get the 3 digit numbers starting with `1`, we need to check the digits reachable from 6 and 8
			for `6` we check all the 2 digit numbers - 3 (0,1,7), and for `8` = 2 (1,3)
			that is,
			dp[1][3] = dp[6][2] + dp[8][2]
			dp[6][2] = 3
			dp[8][2] = 2
			=> dp[1][3] = 5 (phone numbers - 160, 161, 167, 181, 183)
			*/
            map[num].forEach(d => dp[num][i] = (dp[num][i] + dp[d][i - 1]) % mod);
            if(i === n) {
                total = (total + dp[num][i]) % mod;
            }
        }    
    }
    return total;
};