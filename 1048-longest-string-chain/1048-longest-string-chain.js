/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function(words) {
    words.sort((a, b) => a.length - b.length);
    const dp = {};
    let max_chain = 0;
    for (const word of words) {
        dp[word] = 1;
        for (let i = 0; i < word.length; i++) {
            const prev_word = word.slice(0, i) + word.slice(i + 1);
            if (prev_word in dp) {
                dp[word] = Math.max(dp[word], dp[prev_word] + 1);
            }
        }
        max_chain = Math.max(max_chain, dp[word]);
    }
    return max_chain;
};