/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function(path) {
    let moves = {
        'N': [0, 1], 
        'S': [0, -1], 
        'W': [-1, 0],
        'E': [1, 0]
    };

    let visited = new Set();
    visited.add("0,0");
    let x = 0;
    let y = 0;

    for (let c of path) {
        let curr = moves[c];
        let dx = curr[0]; 
        let dy = curr[1];

        x += dx;
        y += dy;

        let hash = `${x},${y}`;

        if (visited.has(hash)) {
            return true;
        }
        visited.add(hash);
    }

    return false;
};