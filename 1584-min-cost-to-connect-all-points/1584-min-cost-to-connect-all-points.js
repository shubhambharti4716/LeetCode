/**
 * @param {number[][]} points
 * @return {number}
 */
const minCostConnectPoints = function(points) {
    let cost = 0, prev = 0, n = points.length;
    let result = new Array(n).fill(Number.MAX_SAFE_INTEGER);
    result[0] = 0;
    for(let j=1;j<n;j++){
        let minimum = Number.MAX_SAFE_INTEGER, temp = -1;
        for(let i=1;i<n;i++){
            if(result[i] > 0){
                result[i] = Math.min(result[i],
                Math.abs(points[i][0] - points[prev][0]) +
                Math.abs(points[i][1] - points[prev][1]));
                if(result[i] < minimum) minimum = result[i], temp =i;
            }
        }
        cost += minimum, result[temp] = 0, prev = temp;
    }
    return cost;
};