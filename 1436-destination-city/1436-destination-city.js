/**
 * @param {string[][]} paths
 * @return {string}
 */
var destCity = function(paths) {
    const pointers = {}
    
    paths.forEach(e => {
        pointers[e[0]] = e[1]

        if(pointers[e[1]] == null) pointers[e[1]] = false
    })

    let point = paths[0][1]

    while(pointers[point])
    {
        point = pointers[point]
    }

    return point
};