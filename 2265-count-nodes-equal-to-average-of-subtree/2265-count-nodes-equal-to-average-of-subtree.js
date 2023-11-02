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
  let finale = {final : 0};

    traversePostOrder(root,finale);
   return finale.final;
  
};

function traversePostOrder(node,finale) {
  if(!node) {
    return null;
  }
  let sum = node.val;
 let counter = 1;
  if(node.left) {
    const [suml,counterl] =traversePostOrder(node.left,finale);
    sum +=suml;
    counter += counterl;

  }
  if(node.right) {
    const [sumr,counterr]= traversePostOrder(node.right,finale);
    sum += sumr;
    counter +=counterr;
  }

  if(Math.floor(sum/counter) === node.val) {
    finale.final++;
  }
  return [sum,counter];
}