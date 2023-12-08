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
 * @return {string}
 */
var tree2str = function(t) {
    let res = [];
    dfs(t, res);
    return res.join('');

    function dfs(t, res) {
        if (t === null)
            return;

        res.push(t.val);

        if (t.left === null && t.right === null)
            return;

        res.push('(');
        dfs(t.left, res);
        res.push(')');

        if (t.right !== null) {
            res.push('(');
            dfs(t.right, res);
            res.push(')');
        }
    }
};