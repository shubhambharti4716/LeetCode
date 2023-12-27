/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */
var minCost = function(colors, neededTime) {
    let output = 0;
    let currentCursor = 0;
    for (let i = 1; i < colors.length; i++) {
        if (colors[i] === colors[currentCursor]) {
            if (neededTime[i] > neededTime[currentCursor]) {
                output += neededTime[currentCursor];
                currentCursor = i;
            } else {
                output += neededTime[i];
            }
        } else {
            currentCursor = i;
        }
    }
    
    return output;
};