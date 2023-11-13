/**
 * @param {string} s
 * @return {string}
 */
var sortVowels = function(s) {
    let strArr = s.split('');
    let vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
    let sortVowels = [];
    for(let i=0; i < strArr.length; i++){
        if(vowels.includes(strArr[i])){
           sortVowels.push(strArr[i].charCodeAt(0));
        }
    }
    sortVowels.sort((a,b) => a > b ? 1 : -1);
    let count = 0;
    for(let i = 0; i < strArr.length; i++){
        if(vowels.includes(strArr[i])){
            strArr[i] = String.fromCharCode(sortVowels[count]);
            count++;
        }
    }
    return strArr.join("");
};