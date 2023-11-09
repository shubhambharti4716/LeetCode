/**
 * @param {string} s
 * @return {number}
 */
var countHomogenous = function(s) {
    let i = 0,
    res = 0,
    cur = 0,
    count = 0,
    mod = 1_000_000_007;
  while (i < s.length) {
    count = s.charAt(i) === cur ? count + 1 : 1;
    cur = s.charAt(i);
    res = (res + count) % mod;
    i++;
  }
  return res;
};