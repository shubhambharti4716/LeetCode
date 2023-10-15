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
function height(node) 
{
   if (node===null) 
    return 0;
   else
   {
       let lDepth = height(node.left);
       let rDepth = height(node.right);
       if (lDepth > rDepth)
           return(lDepth+1);
       else 
           return(rDepth+1);
   }
} 

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {  
        
        let s_tree = readLine().trim().split(" ");
        let root = buildTree(s_tree);
        let obj = new Solution();
        root = obj.buildBalancedTree(root);
        let res = height(root);
        console.log(res);        
    }
}


// } Driver Code Ends


//User function Template for javascript

/*
class Node{
    constructor(data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

 /**
   * @param {Node} root
   * @return {Node}
  */

class Solution
{ 
  buildBalancedTree(root){
    function storeBSTNodes(root, nodes) {
        if (root == null) return;
        storeBSTNodes(root.left, nodes);
        nodes.push(root);
        storeBSTNodes(root.right, nodes);
    }
    
    function buildTreeUtil(nodes, start, end) {
        if (start > end) return null;
        let mid = Math.floor((start + end) / 2);
        let root = nodes[mid];
        root.left = buildTreeUtil(nodes, start, mid - 1);
        root.right = buildTreeUtil(nodes, mid + 1, end);
        return root;
    }
    
    let nodes = [];
    storeBSTNodes(root, nodes);
    let n = nodes.length;
    return buildTreeUtil(nodes, 0, n - 1);
  }
}  