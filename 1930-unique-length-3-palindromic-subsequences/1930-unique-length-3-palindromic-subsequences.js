/**
 * @param {string} s
 * @return {number}
 */
var countPalindromicSubsequence = function(s) {
    const visited = new Set();
    let res = 0;

    for (let left = 0; left < s.length - 2; left++) {
        // console.log("left", left);
        const leftChar = s[left];

        if (visited.has(leftChar)) continue;
        visited.add(leftChar);

        const seenMiddleLetters = new Set();
        let rightMostMatchIdx;

        for (let right = s.length - 1; right >= 0; right--) {
            const rightChar = s[right];
            if (rightChar === leftChar) {
                rightMostMatchIdx = right;
                break;
            }
        }

        if (rightMostMatchIdx == null || rightMostMatchIdx - left <= 1) continue;

        console.log("right", rightMostMatchIdx);
        for (let i = left + 1; i < rightMostMatchIdx; i++) {
            seenMiddleLetters.add(s[i]);
        }

        // console.log("seenMiddleLetters", seenMiddleLetters);

        res += seenMiddleLetters.size;
        // console.log("updated res", res);
    }

    return res;
};