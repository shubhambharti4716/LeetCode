/**
 * @param {number} n
 * @return {number}
 */
var countVowelPermutation = function(n) {
      const modVal = (1e9 + 7);
   let a = 1;
   let e = 1;
   let i = 1;
   let o = 1;
   let u = 1;

   for (let x = 1; x < n; x++) {
      let tempA = e % modVal;
      let tempE = (a + i) % modVal;
      let tempI = (a + e + o + u) % modVal;
      let tempO = (i + u) % modVal;
      let tempU = a % modVal;
      a = tempA;
      e = tempE;
      i = tempI;
      o = tempO;
      u = tempU;
   }

   return (a + e + i + o + u) % modVal;
};