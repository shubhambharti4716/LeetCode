/**
 * @param {number} n
 * @param {number[][]} relations
 * @param {number[]} time
 * @return {number}
 */
var minimumTime = function(n, relations, time) {
    const adjList = new Array(n + 1)
    const inDegree = new Array(n + 1).fill(0)
    const costs = new Array(n + 1).fill(0)
    for (let i = 0; i <= n; i++) {
        adjList[i] = [];
    }
    for (const [from, to] of relations) {
        inDegree[to] += 1
        adjList[from].push(to)
    }
    const q = []
    for (let i = 1; i <= n; i++) {
        if (inDegree[i] === 0) {
            costs[i] = time[i - 1]
            q.push(i) 
        }
    }

    while(q.length) {
        const u = q.shift();
        const cost = costs[u]
        const list = adjList[u] || []
        for (const v of list) {
            inDegree[v] -= 1
            costs[v] = Math.max(costs[v], cost)
            if (inDegree[v] === 0) {
                costs[v] += time[v - 1]
                q.push(v)
            }
        }
    }
    return Math.max(...costs)
};