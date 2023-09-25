/**
 * @param {string} s
 * @param {string} t
 * @return {character}
 */
var findTheDifference = function(s, t) {
    let result = 0;
    for (let i = 0; i < s.length; i++) {
        result ^= s.charCodeAt(i);
    }
    for (let i = 0; i < t.length; i++) {
        result ^= t.charCodeAt(i);
    }
    return String.fromCharCode(result);
};