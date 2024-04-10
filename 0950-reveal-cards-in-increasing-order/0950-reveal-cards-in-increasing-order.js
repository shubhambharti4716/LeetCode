/**
 * @param {number[]} deck
 * @return {number[]}
 */
var deckRevealedIncreasing = function(deck) {
    
    const n = deck.length;
    deck.sort((a, b) => a - b);
    const revealed = [];
    revealed.unshift(deck[n - 1]);
    for (let i = n - 2; i >= 0; i--) {
        revealed.unshift(revealed.pop());
        revealed.unshift(deck[i]);
    }
    return revealed;
};