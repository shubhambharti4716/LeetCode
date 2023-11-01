/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val === undefined ? 0 : val);
 *     this.left = (left === undefined ? null : left);
 *     this.right = (right === undefined ? null : right);
 * }
 */

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var findMode = function(root) {
    if (!root) return [];

    // Initialize variables to track mode(s)
    let maxFreq = 0;
    let currentVal = null;
    let currentFreq = 0;

    // Variables to store the result
    let modes = [];

    // Helper function for in-order traversal
    const traverse = (node) => {
        if (!node) return;

        // Visit left subtree
        traverse(node.left);

        // Process current node
        if (node.val === currentVal) {
            currentFreq++;
        } else {
            currentVal = node.val;
            currentFreq = 1;
        }

        // Update max frequency and modes
        if (currentFreq === maxFreq) {
            modes.push(currentVal);
        } else if (currentFreq > maxFreq) {
            maxFreq = currentFreq;
            modes = [currentVal];
        }

        // Visit right subtree
        traverse(node.right);
    };

    // Start in-order traversal
    traverse(root);

    return modes;
};