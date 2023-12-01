/**
 * @param {string[]} word1
 * @param {string[]} word2
 * @return {boolean}
 */
var arrayStringsAreEqual = function (word1, word2) {
    let s1 = word1.join("")
    let s2 = word2.join("")
    return s1===s2
};