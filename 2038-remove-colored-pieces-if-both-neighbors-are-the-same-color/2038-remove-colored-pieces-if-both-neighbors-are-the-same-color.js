/**
 * @param {string} colors
 * @return {boolean}
 */
var winnerOfGame = function(colors) {
    let countA = 0;
    let countB = 0;

    for (let i = 0; i < colors.length; i++) {
        const x = colors[i];
        let count = 0;

        while (i < colors.length && colors[i] === x) {
            i++;
            count++;
        }

        if (x === 'A') {
            countA += Math.max(count - 2, 0);
        } else if (x === 'B') {
            countB += Math.max(count - 2, 0);
        }

        i--;
    }

    return countA > countB;
};