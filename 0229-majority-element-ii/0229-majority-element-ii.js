/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
    let candidate1 = null, candidate2 = null, count1 = 0, count2 = 0;
    
    for (let num of nums) {
        if (num === candidate1) {
            count1++;
        } else if (num === candidate2) {
            count2++;
        } else if (count1 === 0) {
            candidate1 = num;
            count1 = 1;
        } else if (count2 === 0) {
            candidate2 = num;
            count2 = 1;
        } else {
            count1--;
            count2--;
        }
    }
    
    count1 = count2 = 0;
    
    for (let num of nums) {
        if (num === candidate1) count1++;
        else if (num === candidate2) count2++;
    }
    
    const threshold = Math.floor(nums.length / 3);
    const result = [];
    
    if (count1 > threshold) result.push(candidate1);
    if (count2 > threshold) result.push(candidate2);
    
    return result;
};