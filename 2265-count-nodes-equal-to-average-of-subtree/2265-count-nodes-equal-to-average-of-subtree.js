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
 * @return {number}
 */
var averageOfSubtree = function(root) {
  let result = 0;

  const traverse = (node) => {
    let count = 0;
    let sum = 0;

    if (!node) return [0,0];
    const [leftSum, leftCount] = traverse(node.left);
    const [rightSum, rightCount] = traverse(node.right);
    sum += leftSum + rightSum + node.val
    count += leftCount + rightCount + 1;

    if (Math.floor(sum / count) === node.val) result += 1

    return [sum, count]
  }

  traverse(root)
  return result;
}