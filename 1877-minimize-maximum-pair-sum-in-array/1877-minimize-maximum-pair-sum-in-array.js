/**
 * @param {number[]} nums
 * @return {number}
 */
var minPairSum = function(nums) {
    nums.sort( (a,b) => a-b);
    let maximum = 0;
    let start =0;
    let end = nums.length-1;
    while(start < end){
        let sum = nums[start] + nums[end];
        if(maximum < sum){
            maximum =sum;
        }
        start++;
        end--;
    }
    return maximum;
};