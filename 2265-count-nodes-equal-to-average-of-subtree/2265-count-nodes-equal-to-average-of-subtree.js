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
    var res = 0;

    var postorder = function(node) {
        if (!node) {
            return [0, 0]; // sum, number of nodes
        }

        var left = postorder(node.left);
        var right = postorder(node.right);

        var totalSum = left[0] + right[0] + node.val;
        var totalCount = 1 + left[1] + right[1];
        res += node.val === Math.floor(totalSum / totalCount);

        return [totalSum, totalCount];
    };

    postorder(root);

    return res;
};