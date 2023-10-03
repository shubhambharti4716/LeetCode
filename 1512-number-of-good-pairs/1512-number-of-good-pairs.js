/**
 * @param {number[]} nums
 * @return {number}
 */
var numIdenticalPairs = function(nums) {
    let goodPair = 0;
    let map = {};

    for(let i=0;i<nums.length; i++) {
        let item = nums[i];
        if(map[item]) {
            goodPair +=map[item];
            map[item] = map[item]+1;
        } else {
            map[item] = 1;
        }
    }
    return goodPair;
};