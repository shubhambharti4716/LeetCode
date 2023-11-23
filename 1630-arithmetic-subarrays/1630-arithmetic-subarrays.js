/**
 * @param {number[]} nums
 * @param {number[]} l
 * @param {number[]} r
 * @return {boolean[]}
 */
var checkArithmeticSubarrays = function(nums, l, r) {
    const result = [];
    for (let i = 0; i < l.length; i++) {
        result.push(isArithmetic(nums, l[i], r[i]));
    }
    return result;
};

const isArithmetic = function(nums, l, r) {
    let maxVal = Number.MIN_SAFE_INTEGER, minVal = Number.MAX_SAFE_INTEGER;

    for (let i = l; i <= r; i++) {
        maxVal = Math.max(nums[i], maxVal);
        minVal = Math.min(nums[i], minVal);
    }

    const len = r - l + 1;
    if ((maxVal - minVal) % (len - 1) !== 0) {
        return false;
    }

    const diff = (maxVal - minVal) / (len - 1);
    if (diff === 0) {
        return true;
    }

    const visited = Array(len).fill(false);

    for (let i = l; i <= r; i++) {
        const val = nums[i];
        if ((val - minVal) % diff !== 0) {
            return false;
        } else {
            const pos = (val - minVal) / diff;
            if (visited[pos]) {
                return false;
            }
            visited[pos] = true;
        }
    }
    return true;
};