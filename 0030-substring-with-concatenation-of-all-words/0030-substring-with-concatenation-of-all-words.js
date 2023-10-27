/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function(s, words) {
    const output = []
    let wordLen = words[0].length
    let totalWordsLen = wordLen * words.length
    if (totalWordsLen > s.length) return output
    const wordsMap = {}
    let checker = {}
    for (let word of words) {
        wordsMap[word] = wordsMap[word] ? wordsMap[word] + 1 : 1
        checker[word] = wordsMap[word]
    }
    for (let i = 0; i <= s.length - totalWordsLen; i++) {
        let str = s.slice(i, i + wordLen)
        let j = i
        if (checker[str]) {
            while (checker[str]) {
                checker[str]--
                j += wordLen
                if (j - i === totalWordsLen) {
                    output.push(i)
                    break
                } else {
                    str = s.slice(j, j + wordLen)
                }
            }
            checker = { ...wordsMap }
        } 
    }
    return output
};