/**
 * @param {number[]} nums
 * @return {number}
 */
var countNicePairs = function(nums) {
    function reverse(num) {
        let rev = 0;
        while (num > 0) {
            rev = rev * 10 + num % 10;
            num = Math.floor(num / 10);
        }
        return rev;
    }

    const mod = 1000000007;

    nums = nums.map(num => num - reverse(num));
    nums.sort((a, b) => a - b);

    let res = 0;
    let i = 0;
    while (i < nums.length - 1) {
        let cont = 1;
        while (i < nums.length - 1 && nums[i] === nums[i + 1]) {
            cont++;
            i++;
        }
        res = (res % mod + (cont * (cont - 1)) / 2) % mod;
        i++;
    }

    return Math.floor(res % mod);
};