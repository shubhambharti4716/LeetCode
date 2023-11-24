/**
 * @param {number[]} piles
 * @return {number}
 */
var maxCoins = function(piles) {
    piles.sort((a, b) => a - b);
    let res = 0;

    for (let i = Math.floor(piles.length / 3); i < piles.length; i += 2) {
        res += piles[i];
    }

    return res;    
};