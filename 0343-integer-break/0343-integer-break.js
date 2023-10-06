/**
 * @param {number} n
 * @return {number}
 */
var integerBreak = function(n) {
    let x = 1;
    while (n > 4) {
        x *= 3;
        n -= 3
    } 
    return x * (x > 1 ? n : n === 3 ? 2 : n === 4 ? 4 : 1);
    
};