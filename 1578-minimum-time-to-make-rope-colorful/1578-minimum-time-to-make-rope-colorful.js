/**
 * @param {string} colors
 * @param {number[]} neededTime
 * @return {number}
 */
var minCost = function(colors, neededTime) {
    let totalTime = 0;
    let i = 0;
    let j = 0;

    while (i < neededTime.length && j < neededTime.length) {
        let currTotal = 0;
        let currMax = 0;

        while (j < neededTime.length && colors[i] === colors[j]) {
            currTotal += neededTime[j];
            currMax = Math.max(currMax, neededTime[j]);
            j++;
        }

        totalTime += currTotal - currMax;
        i = j;
    }

    return totalTime;
};

