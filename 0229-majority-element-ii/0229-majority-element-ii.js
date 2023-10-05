/**
 * @param {number[]} nums
 * @return {number[]}
 */
var majorityElement = function(nums) {
    const count = new Map();
    const freq = []
  for(let num of nums) {
      let newCount = 1;
      if(count.has(num)) {
            newCount += count.get(num);
          count.set(num, newCount);
          
      } else {
          count.set(num, 1);
      }
      if(newCount > Math.floor((nums.length)/3) && !freq.includes(num)) {
        freq.push(num);
    }
  }  
  return freq;
};