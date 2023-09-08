//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            Node rootA = g.binaryTreeToBST(root);
            printInorder(rootA);
            System.out.println();
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

/*Structure of the node class is
class Node
{
    int data;
    Node left, right;
    Node(int item){
        data = item;
        left = right = null;
    }
} */


class index
{
    int x = 0;
}
class Solution
{
    // Function to convert an array to a binary search tree
    void arrayToBST(int arr[], Node root, index index_ptr)
    {
        // Base case: return if root is null
        if(root == null)
            return ;
        
        // Recursively convert left subtree
        arrayToBST(arr, root.left, index_ptr);
        
        // Assign value from array to current root node
        root.data = arr[index_ptr.x];
        
        // Increment index pointer
        index_ptr.x++;
        
        // Recursively convert right subtree
        arrayToBST(arr, root.right, index_ptr);
    }
    
    // Function to store inorder traversal of a tree in an array
    void storeInorder(Node node, int inorder[], index index_ptr)
    {
        // Base case: return if node is null
        if(node == null)
            return ;
        
        // Recursively store inorder traversal of left subtree
        storeInorder(node.left, inorder, index_ptr);
        
        // Store data of current node in inorder array
        inorder[index_ptr.x] = node.data;
        
        // Increment index pointer
        index_ptr.x++;
        
        // Recursively store inorder traversal of right subtree
        storeInorder(node.right, inorder, index_ptr);
    }
    
    // Function to count the number of nodes in a tree
    int countNodes(Node root)
    {
        // Base case: return 0 if root is null
        if(root == null)
            return 0;
        
        // Recursively count nodes in left and right subtrees and add 1 for the root node
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    // Function to convert a binary tree to a binary search tree
    Node binaryTreeToBST (Node root)
    {
        // Base case: return null if root is null
        if(root == null)
            return null;
        
        // Count the number of nodes in the tree
        int n = countNodes(root);
        
        // Create an array to store the inorder traversal of the tree
        int arr[] = new int[n];
        
        // Create an index pointer object
        index index = new index();
        
        // Store the inorder traversal of the tree in the array
        storeInorder(root, arr, index);
        
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        // Reset the index pointer to 0
        index.x = 0;
        
        // Convert the sorted array back into a binary search tree
        arrayToBST(arr, root, index);
        
        // Return the root of the converted binary search tree
        return root;
    }
}