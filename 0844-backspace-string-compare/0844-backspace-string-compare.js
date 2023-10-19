/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var backspaceCompare = function(s, t) {
    let index1 = s.length - 1
    let index2 = t.length - 1
    while (index1 >= 0 || index2 >= 0) {
        let i1 = nextValidCharIdx(s, index1)
        let i2 = nextValidCharIdx(t, index2)
        if (i1 < 0 && i2 < 0) return true
        if (i1 < 0 || i2 < 0) return false
        if (s[i1] !== t[i2]) return false
        index1 = i1 - 1
        index2 = i2 - 1
    }
    return true
};

function nextValidCharIdx(str, index) {
    let backspaceCount = 0
    while (index >= 0) {
        if (str[index] === '#') {
            backspaceCount += 1
        } else if (backspaceCount > 0) {
            backspaceCount -= 1
        } else {
            break
        }
        index -= 1
    }
    return index
}