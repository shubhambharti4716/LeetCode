/**
 * @param {string} s
 * @return {number}
 */
var minOperations = function(s) {
    let c_0 = s[0];
    let count1 = count(s, c_0);
    let count2 = count(s, c_0 === '0' ? '1' : '0') + 1;
    return Math.min(count1, count2);
};

const count = function(s, c_pre) {
    let count = 0;
    for (let i = 1; i < s.length; i++) {
        let current = s[i];
        if (current === c_pre) {
            count++;
            c_pre = c_pre === '0' ? '1' : '0';
        } else {
            c_pre = current;
        }
    }
    return count;
};