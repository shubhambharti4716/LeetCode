/**
 * @param {string} s
 * @return {number}
 */
var maxLengthBetweenEqualCharacters = function(s) {
    max = -1

    for (let i = 0; i < s.length; i++) {
        len = i - s.indexOf(s[i]) - 1
        if (len > max)
            max = len
    }

    return max
};