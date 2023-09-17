/**
 * @param {number[][]} graph
 * @return {number}
 */
var shortestPathLength = function (g) {
    let n = g.length
    let allVis = (1 << n) - 1

    let vis = Array.from({ length: n }, () => new Array(allVis + 1).fill(0))
    let q = []
    for (let i = 0; i < n; i++) {
        q.push([i, 1 << i, 0])
        vis[i][1 << i] = 1
    }

    while (q.length) {
        let [u, pathbm, d] = q.shift()
        if (allVis === pathbm) return d


        for (let v of g[u]) {
            let pathbmnew = pathbm | (1 << v)
            if (vis[v][pathbmnew]) continue
            q.push([v, pathbmnew, d + 1])
            vis[v][pathbmnew] = 1
        }
    }
};