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
        let res = [];
    if(!root) return res;
    function trav(node, level){
        if(!node) return;
        if(res[level] == undefined || res[level] < node.val ) res[level] =node.val;
        if(node.left) trav(node.left, level+1);
        if(node.right) trav(node.right, level+1);
    }
    trav(root, 0);
    return res;
};