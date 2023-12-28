/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */
var getLengthOfOptimalCompression = function (s, k) {
  if (s.length <= k) return 0;
  const hash = Array.from({ length: s.length }, (_) => new Array(k + 1));

  const dfs = (idx, k) => {
    if (k + idx >= s.length) return 0;
    if (k < 0) return Infinity;
    if (hash[idx][k] != undefined) return hash[idx][k];
    let res = dfs(idx + 1, k - 1);
    let diff = 0;
    let same = 0;
    for (let i = idx; i < s.length && k - diff >= 0; i++) {
      s[i] == s[idx] ? same++ : diff++;
      const length =
        same <= 1 ? 1 : Math.floor(Math.log(same) / Math.log(10)) + 2;
      res = Math.min(res, length + dfs(i + 1, k - diff));
    }
    return (hash[idx][k] = res);
  };
  return dfs(0, k);
};