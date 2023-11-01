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

const inorder = (root, arr) => {
    if(!root){
        return;
    }

    inorder(root.left, arr);
    arr.push(root.val);
    inorder(root.right, arr);
}

const mostFrequent = (arr, n) => 
{ 
    var hash = new Map(); 
    for (var i = 0; i < n; i++) 
    { 
        if(hash.has(arr[i])) 
            hash.set(arr[i], hash.get(arr[i])+1) 
        else
            hash.set(arr[i], 1) 
    } 
  
    let max_count = 0; 
    hash.forEach((value) => {    
        if (max_count < value) { 
            max_count = value; 
        } 
  
    }); 

    let result = [];
    hash.forEach((value,key) => {    
        if (max_count === value) { 
            result.push(key)
        } 
  
    }); 
  
    return result; 
} 

var findMode = function(root) {
    const inorderArr =[];
    inorder(root, inorderArr);

    // console.log(inorderArr);

    return mostFrequent(inorderArr, inorderArr.length)
};