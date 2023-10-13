/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    if(cost.length ===1) return cost[0];

    const minTotalCost = new Array(cost.length);

    minTotalCost[0] = cost[0];
    minTotalCost[1] = cost[1];

    for(let i = 2; i < minTotalCost.length; i++) {
        minTotalCost[i] = cost[i] + Math.min(minTotalCost[i - 1], minTotalCost[i-2]);
    }

    return Math.min(minTotalCost[cost.length-1], minTotalCost[cost.length-2])
};