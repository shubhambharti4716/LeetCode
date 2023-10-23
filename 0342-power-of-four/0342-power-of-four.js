/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfFour = function(n) {
    let res = false
  let count = 1
  for (let i = 0; i < 100; i++) {
   if(n == count) {
    res = true
    break
  }
   count *=  4
  }
  return res
};