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

function newNode(root, data)
{
    if(root === null)
        root = new Node(data);
    else if(data < root.data)
        root.left = newNode(root.left, data);
    else
        root.right = newNode(root.right, data);
    return root;
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
        let root1 = buildTree(input_ar1);
        
        let input_ar2 = readLine().split(' ');
        let root2 = buildTree(input_ar2);
        
        let obj = new Solution();
        let res = obj.findCommon(root1, root2); 
        let s = '';
        for(let i=0; i<res.length; i++){
            s += res[i] +" ";
        }
        console.log(s);
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} root1
 * @param {Node} root2
 * @returns {number[]}
*/


class Solution 
{
    //Function to find the nodes that are common in both BST.
    findCommon(root1, root2)
    {
        //creating two stacks for inorder traversals of both BST.
    	let stack1 = [], s1 = [], s2 = [];
    	let end_stack1 = -1, end_s1 = -1, end_s2 = -1;
        let res = []; 
    	while (1)
    	{
    	    //pushing the nodes of first BST in stack s1.
    		if (root1)
    		{
    			s1.push(root1);
    			end_s1++;
    			root1 = root1.left;
    		}
    		//pushing the nodes of second BST in stack s2.
    		else if (root2)
    		{
    			s2.push(root2);
    			end_s2++;
    			root2 = root2.left;
    		}
    		//when both root1 and root2 become NULL
    		else if (end_s1 >= 0 && end_s2 >= 0)
    		{
    			root1 = s1[end_s1];
    			root2 = s2[end_s2];
    			
    			//if data at current node in two BST's are same, we 
	    		//store it in output list.
    			if (root1.data === root2.data)
    			{
    			    //popping element from both stacks.
    				res.push(root1.data);
    				s1.pop();
    				end_s1--;
    				s2.pop();
    				end_s2--;
    				
    				//moving to the inorder successor
    				root1 = root1.right;
    				root2 = root2.right;
    			}
    			//if data at current node of first BST is smaller than that of 
                //second BST then it's obvious that inorder successors of 
                //current node can have same value as that of second BST node.
    			else if (root1.data < root2.data)
    			{
    			    //popping element from stack s1.
    				s1.pop();
    				end_s1--;
    				root1 = root1.right;
    				
    				//root2 is set to NULL since we need new nodes of first BST.
    				root2 = null;
    			}
    			else if (root1.data > root2.data)
    			{
    			    //popping element from stack s2.
    				s2.pop();
    				end_s2--;
    				root2 = root2.right;
    				
    				//root1 is set to NULL since we need new nodes of second BST.
    				root1 = null;
    			}
    		}
    		else break;
    	}
    	//returning the output list.
    	return res;
    }
}