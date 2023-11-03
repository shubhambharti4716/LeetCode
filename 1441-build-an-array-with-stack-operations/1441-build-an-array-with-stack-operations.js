/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function(target, n) {
    let res = [];
    j = 0;
    for(let i=1;i<=n;i++) {
        if(target[j]===i) {
            res.push('Push');
            j++;
        } else res.push(...['Push','Pop']);
        if(j===target.length) return res;
    }
    return res;
};