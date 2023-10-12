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
	    	
            Solution ob = new Solution();
    		System.out.println(ob.dupSub(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    private HashSet<String> set; // using a HashSet to store the serialized string representations of subtrees
    boolean found = false; // flag to indicate if a duplicate subtree has been found

    int dupSub(Node root) {
        set = new HashSet<String>(); // initialize the HashSet
        dfs(root); // perform depth-first search on the tree
        if (found) return 1; // if a duplicate subtree has been found, return 1
        return 0; // if no duplicate subtree has been found, return 0
    }

    private String dfs(Node root) {
        StringBuilder s = new StringBuilder(); // create a StringBuilder to construct the serialized string representation of the subtree
        if (root == null) {
            return "#"; // return "#" to represent a null node
        }
        if (root.left==null && root.right==null) return root.data+" "; // return the data of a leaf node followed by a space

        s.append(root.data+" "); // append the data of the current node followed by a space
        s.append(dfs(root.left)); // recursively append the serialized string representation of the left subtree
        s.append(dfs(root.right)); // recursively append the serialized string representation of the right subtree
        
        if (set.contains(s.toString())) found = true; // if the serialized string representation of the subtree is already in the HashSet, set the found flag to true
        else set.add(s.toString()); // otherwise, add the serialized string representation of the subtree to the HashSet
        
        return s.toString(); // return the serialized string representation of the subtree
    }
}