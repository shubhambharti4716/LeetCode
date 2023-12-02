/**
 * @param {string[]} words
 * @param {string} chars
 * @return {number}
 */
var countCharacters = function(words, chars) {
    const counts = new Array(26).fill(0);

    // Step 1: Initialize Character Counts Array
    for (const ch of chars) {
        counts[ch.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    let result = 0;

    // Step 3: Check Words
    for (const word of words) {
        if (canForm(word, counts)) {
            // Step 4: Calculate Lengths
            result += word.length;
        }
    }

    return result;

    function canForm(word, counts) {
        const c = new Array(26).fill(0);

        // Step 2: Update Counts Array
        for (const ch of word) {
            const x = ch.charCodeAt(0) - 'a'.charCodeAt(0);
            c[x]++;
            if (c[x] > counts[x]) {
                return false;
            }
        }

        return true;
    }
};