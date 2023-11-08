/**
 * @param {number} sx
 * @param {number} sy
 * @param {number} fx
 * @param {number} fy
 * @param {number} t
 * @return {boolean}
 */
var isReachableAtTime = function (sx, sy, fx, fy, t) {
  if (sx === fx && sy === fy) {
    if (t === 1) return false;
    return true;
  }
  let max = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
  if (max <= t) return true;
  return false;
};