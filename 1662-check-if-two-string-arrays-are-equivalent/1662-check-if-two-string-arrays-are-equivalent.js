/**
 * @param {string[]} word1
 * @param {string[]} word2
 * @return {boolean}
 */
var arrayStringsAreEqual = function(word1, word2) {
    const str1 = word1.join('');
    const str2 = word2.join('');
    return str1 === str2;
};