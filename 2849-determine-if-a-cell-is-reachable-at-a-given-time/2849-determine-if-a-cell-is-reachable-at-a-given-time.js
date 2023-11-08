/**
 * @param {number} sx
 * @param {number} sy
 * @param {number} fx
 * @param {number} fy
 * @param {number} t
 * @return {boolean}
 */
var isReachableAtTime = function(sx, sy, fx, fy, t) {
    let distx = Math.abs(sx - fx);
    let disty = Math.abs(sy - fy);

    if (distx === 0 && disty === 0 && t === 1) {
        return false;
    }

    // Calculate the minimum time needed based on Manhattan distance
    let minTimeNeeded = Math.min(distx, disty);
    distx -= minTimeNeeded;
    disty -= minTimeNeeded;

    minTimeNeeded += Math.max(distx, disty);

    return minTimeNeeded <= t; 
};