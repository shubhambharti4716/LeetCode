/**
 * @param {number[]} nums
 * @return {number}
 */
var minPairSum = function(arr) {
    arr.sort((a, b) => a - b);
    
    let res = 0;
    let i = 0;
    let j = arr.length - 1;

    while(i <= j) {
        res = Math.max(res, arr[i] + arr[j]);
        i += 1;
        j -= 1;
    }
        

    return res;
};