/**
 * @param {number[]} piles
 * @return {number}
 */
var maxCoins = function(piles) {
    piles.sort((a, b) => b - a)
    let total = 0, count = piles.length / 3, index = 1

    while (count-- > 0) {
        total += piles[index]
        index += 2
    }
    
    return total
};