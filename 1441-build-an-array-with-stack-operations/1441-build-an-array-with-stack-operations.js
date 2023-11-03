/**
 * @param {number[]} target
 * @param {number} n
 * @return {string[]}
 */
var buildArray = function(target, n) {
    //using 2 pointer approach
    const operations = [];
    let targetIndex = 0; // Pointer for target array
    let currentNumber = 1; // Pointer for numbers 1 to n

    while (targetIndex < target.length) {
        if (target[targetIndex] === currentNumber) {
            // If the current number in the target array matches the current number 1 to n
            // Push "Push" operation and move both pointers
            operations.push("Push");
            targetIndex++;
        } else {
            // If the numbers don't match, push "Push" followed by "Pop" operation
            // and only move the current number pointer
            operations.push("Push");
            operations.push("Pop");
        }
        currentNumber++;
    }

    return operations;
};