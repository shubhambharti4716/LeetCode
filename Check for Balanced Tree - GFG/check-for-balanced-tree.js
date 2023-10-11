//{ Driver Code Starts
//Initial Template for javascript

'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

function buildTree(str){
   // Corner Case
   if(str.length === 0 || str[0] === "N")
       return null;

   // Create the root of the tree
   let root = new Node(parseInt(str[0]));

   // Push the root to the queue
   let queue = [];
   let start = 0;
   queue.push(root);

   // Starting from the second element
   let i = 1;
   while(queue.length !== start && i < str.length) {

       // Get and remove the front of the queue
       let currNode = queue[start];
       start++;

       // Get the current node's value from the string
       let currVal = str[i];

       // If the left child is not null
       if(currVal !== "N") {

           // Create the left child for the current node
           currNode.left = new Node(parseInt(currVal));

           // Push it to the queue
           queue.push(currNode.left);
       }

       // For the right child
       i++;
       if(i >= str.length)
           break;
       currVal = str[i];

       // If the right child is not null
       if(currVal !== "N") {

           // Create the right child for the current node
           currNode.right = new Node(parseInt(currVal));

           // Push it to the queue
           queue.push(currNode.right);
       }
       i++;
   }

   return root;
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let input_ar1 = readLine().split(' ');
        let root = buildTree(input_ar1);
        let obj = new Solution();
        if(obj.isBalanced(root)){
            console.log("1");
        }
        else{
            console.log("0");
        }
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} root
 * @returns {boolean}
*/

/*
class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/
class Height {
    constructor(){
        this.height = 0;
    }
}

class Solution {
    
    //Function to check whether a binary tree is balanced or not.
    isBalancedUtil(root,height)
    { 
        //if root is null, we return true.
        if (root === null) { 
            height.height = 0; 
            return true; 
        } 
  
        let lheight = new Height(), rheight = new Height();
        
        //calling the function isBalancedUtil recursively for the heights of 
        //left and right subtrees and storing the returned values in l and r.
        let l = this.isBalancedUtil(root.left, lheight); 
        let r = this.isBalancedUtil(root.right, rheight); 
        
        let lh = lheight.height, rh = rheight.height; 
  
        //height of current node is(max of height of left and right subtrees)+1.
        height.height = (lh > rh ? lh : rh) + 1; 
  
        //if difference between heights of left and right subtrees is 2 or  
        //more than 2 then this node is not balanced so we return false.
        if (Math.abs(lh -rh) >= 2) 
            return false; 
  
        //if this node is balanced and left and right subtrees are balanced 
        //then we return true.
        else
            return l && r; 
    }
    
    //Function to check whether a binary tree is balanced or not.
    isBalanced(root){
        let height = new Height(); 
        return this.isBalancedUtil(root,height);
    }
    
    
}  