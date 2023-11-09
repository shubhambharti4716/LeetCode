/**
 * @param {string} s
 * @return {number}
 */
var countHomogenous = function(s) {
    let res = 0;
    let start = 0;
    
    for (let i = 0; i < s.length; i++) {
        if (s[i] !== s[start]) {
            let appear = i - start;
            while (appear > 0) {
                res += appear;
                appear -= 1;
            }
            start = i;
        }
    }

    let appear = s.length - start;
    while (appear > 0) {
        res += appear;
        appear -= 1;
    }

    return res % (Math.pow(10, 9) + 7);
};