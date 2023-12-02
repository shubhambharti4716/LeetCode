/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function(words, chars) {
    let sum = 0
    for(let i = 0; i < words.length; i++) {
        let count = 0
        let arr = JSON.stringify(chars)
        for(let j = 0; j < words[i].length; j++) {
            let a = words[i][j]

            if (arr.includes(a)) {
                count++
                //let index = arr.indexOf(a);
                arr = arr.replace(a, "");
            } else {
                break;
            }
        }
        if (count === words[i].length) {
            sum = sum + count
        }
    }
    return sum
};