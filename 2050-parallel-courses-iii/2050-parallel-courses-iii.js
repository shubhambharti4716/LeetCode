/**
 * @param {number} n
 * @param {number[][]} relations
 * @param {number[]} time
 * @return {number}
 */
var minimumTime = function(n, relations, time) {
    const cnt = Array(n+1).fill(0);
    const edges = Array(n+1).fill(null).map(() => []);
    for (const [p,n] of relations) {
        cnt[n]++;
        edges[p].push(n);
    }
    const q = [];
    let fr = -1, re= -1;
    const T = Array(n+1).fill(0);
    for (let i = 1; i <= n ; i++) {
        if (!cnt[i]) {
            q[++re] = i;
            T[i] = time[i-1];
        }
    }

    let ans = 0;
    while (fr < re) {
        const c = q[++fr];
        ans = Math.max(ans, T[c]);
        for (const n of edges[c]) {
            cnt[n]--;
            T[n] = Math.max(T[n], T[c] + time[n-1])
            if (!cnt[n]) {
                q[++re] = n;
            }
        }
    }
    return ans;
};