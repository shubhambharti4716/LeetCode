/**
 * @param {number[][]} points
 * @return {number}
 */
var maxWidthOfVerticalArea = function(points) {
    points.sort((a, b) => a[0] - b[0]);
    let max = 0;
    let prev = points[0][0];
    for (let i = 1; i < points.length; i++) {
        if (points[i][0] !== prev) {
            max = Math.max(max, points[i][0] - prev);
            prev = points[i][0];
        }
    }
    return max;
};