/**
 * @param {number} n
 * @return {number}
 */
var countVowelPermutation = function(n) {
    let aCount = 1, eCount = 1, iCount = 1, oCount = 1, uCount = 1;
    const MOD = 1000000007; 
    for (let i = 1; i < n; i++) {
        const aCountNew = (eCount + iCount + uCount) % MOD;
        const eCountNew = (aCount + iCount) % MOD;
        const iCountNew = (eCount + oCount) % MOD;
        const oCountNew = (iCount) % MOD;
        const uCountNew = (iCount + oCount) % MOD;
        aCount = aCountNew;
        eCount = eCountNew;
        iCount = iCountNew;
        oCount = oCountNew;
        uCount = uCountNew;
    }
    const result = (aCount + eCount + iCount + oCount + uCount)  % MOD;
    return result;
};