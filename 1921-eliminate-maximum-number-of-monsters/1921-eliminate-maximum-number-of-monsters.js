/**
 * @param {number[]} dist
 * @param {number[]} speed
 * @return {number}
 */
var eliminateMaximum = function (dist, speed) {
    let sorted = [];
    for (let i = 0; i < dist.length; i++) {
        sorted.push(Math.ceil(dist[i] / speed[i]));
    }

    sorted.sort(function (a, b) {
        return a - b;
    });

    for (let i = 0; i < sorted.length; i++) {
        if (sorted[i] - 1 < i) {
            return i;
        }
    }

    return sorted.length;
};