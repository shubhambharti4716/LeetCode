/**
 * @param {string[]} words
 * @return {boolean}
 */
var makeEqual = function(words) {
    let letterCounts = new Array(26).fill(0);

    if(words.length == 1) {
        return true;
    }
 
    for(let word of words) {
        for(let i = 0; i < word.length; i++) {
            let cIdx = word.charCodeAt(i)-97;
            letterCounts[cIdx]++;
        }
    }

    let unusedLetters=0;
    for(let i = 0; i < letterCounts.length; i++) {
        if(letterCounts[i] != 0) {
            if(letterCounts[i]%words.length != 0) {
                return false;
            }
        } else {
            unusedLetters++;
        }
    }

    return true;
};