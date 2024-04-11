/**
 * @param {string} num
 * @param {number} k
 * @return {string}
 */
const removeKdigits = (number, k) => {
    // Stack to store digits of the resulting number
    const digitStack = [];
    // Variable to keep track of how many digits have been removed
    let removed = 0;

    // Iterate over each digit in the input number
    for (const digit of number) {
        // Remove digits from the stack if they are greater than the current digit and
        // there are still digits to be removed
        while (digitStack.length && digit < digitStack[digitStack.length - 1] && removed < k) {
            digitStack.pop();
            removed++;
        }
        // Push the current digit onto the stack
        digitStack.push(digit);
    }

    // Remove remaining digits if necessary
    while (removed < k) {
        digitStack.pop();
        removed++;
    }

    // Remove leading zeros from the resulting number
    while (digitStack.length && digitStack[0] === '0') {
        digitStack.shift();
    }

    // Construct the result string by joining the digits in the stack
    const result = digitStack.join('');

    // Return "0" if the result is empty, otherwise return the result
    return result ? result : "0";
}