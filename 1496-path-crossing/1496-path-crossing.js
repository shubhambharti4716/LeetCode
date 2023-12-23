/**
 * @param {string} path
 * @return {boolean}
 */
var isPathCrossing = function (path) {
    const positions = new Set()
    let x = 0;
    let y = 0;
    const navigate = {
        "N": { x: 0, y: +1 },
        "S": { x: 0, y: -1 },
        "W": { x: -1, y: 0 },
        "E": { x: +1, y: 0 },
    }
    positions.add("0-0")
    for (const direction of path) {
        x += navigate[direction].x;
        y += navigate[direction].y;

        if (positions.has(`${x}-${y}`)) {
            console.log(positions);
            return true
        }

        positions.add(`${x}-${y}`);
    }

    return false;
};