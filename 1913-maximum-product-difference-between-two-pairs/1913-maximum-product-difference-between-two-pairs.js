/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProductDifference = function(nums) {
    let largest = 0, secondLargest = 0;
    let smallest = Number.MAX_SAFE_INTEGER, secondSmallest = Number.MAX_SAFE_INTEGER;

    for (const n of nums) {
        if (n < smallest) {
            secondSmallest = smallest;
            smallest = n;
        } else if (n < secondSmallest) {
            secondSmallest = n;
        }

        if (n > largest) {
            secondLargest = largest;
            largest = n;
        } else if (n > secondLargest) {
            secondLargest = n;
        }
    }

    return (largest * secondLargest) - (smallest * secondSmallest);
};