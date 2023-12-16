/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function(s, t) {
    if (s.length !== t.length) return false;

        const charMap = Array(26).fill(0);

        for (let i = 0; i < s.length; i++) {
            charMap[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
            charMap[t.charCodeAt(i) - 'a'.charCodeAt(0)]--;
        }

        return charMap.every(count => count === 0);
};