/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {

    let count=0
    let stack=0
    for(let j=0;j<s.length;j++){
        for(let i=count;i<t.length;i++){
            if(s[j]===t[i]){    
                count++
                stack++
                break
            }
            count++
        }
    }
    if(stack===s.length){
        return true
    }else{
        return false
    }

};