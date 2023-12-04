/**
 * @param {string} num
 * @return {string}
 */
var largestGoodInteger = function(num) {
    let a = 0, b = 1;
    let max = 0;
    let matchFound = false;
    if(num.length < 3 )
        return ""
    while(a < b && b < num.length){
        if(num[a] === num[b])
            b++;
        else{
            a = b;
            b++;
        }
        if(b - a > 2){
            max = Math.max(max, num[a]);
            matchFound = true;
        }
    }
    if(matchFound)
        return `${max}${max}${max}`;
    return ""
};