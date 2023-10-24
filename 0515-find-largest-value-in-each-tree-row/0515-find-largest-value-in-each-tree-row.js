/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var largestValues = function(root) {
    if (!root) {
        return [];
    }
    
    let queue = [root];
    let temp = [];
    let level = 0;
    const max = [];
    
    while (queue.length) {
        const el = queue.shift();
        
        temp.push(...[el.left, el.right].filter(Boolean));

        if (el.val > (max[level] ?? -Infinity)) {
            max[level] = el.val;
        }
        
        if (!queue.length) {
            level++;
            queue = temp;
            temp = [];
        }
   }
    
    return max;
};