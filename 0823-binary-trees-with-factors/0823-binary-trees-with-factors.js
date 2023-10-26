/**
 * @param {number[]} arr
 * @return {number}
 */
var numFactoredBinaryTrees = function(arr) {
    arr.sort((a,b)=>a-b);
    let map = new Map();
    let mod = 1000000007;
    let res = 0;
    for(let i=0;i<arr.length;i++){
        let count = 1;
        for(let j=0;j<i;j++){
            if(arr[i]%arr[j]==0 && map.has(arr[i]/arr[j])){
                count += map.get(arr[j])*map.get(arr[i]/arr[j]);
            }
        }
        map.set(arr[i],count);
        res += count;
    }
    return res%mod;
    
};