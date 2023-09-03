//{ Driver Code Starts
//Initial Template for Java

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

class GfG {
    
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
    static void printInorder(Node root)
    {
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
	            String s1 = br.readLine();
	            String s2 = br.readLine();
    	    	Node root1 = buildTree(s1);
    	    	Node root2 = buildTree(s2);
        	    Solution tree = new Solution();
        	    if (tree.isIsomorphic(root1, root2) == true) 
                    System.out.println("Yes"); 
                else
                    System.out.println("No");
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java

class Solution  
{ 
    Node root1, root2; 
   
    /* Given a binary tree, print its nodes in reverse level order */
    boolean isIsomorphic(Node n1, Node n2)  
    { 
        // Both roots are NULL, trees isomorphic by definition 
        if (n1 == null && n2 == null) 
            return true; 
   
        // Exactly one of the n1 and n2 is NULL, trees not isomorphic 
        if (n1 == null || n2 == null) 
            return false; 
   
        if (n1.data != n2.data) 
            return false; 
   
        // There are two possible cases for n1 and n2 to be isomorphic 
        // Case 1: The subtrees rooted at these nodes have NOT been  
        // "Flipped".  
        // Both of these subtrees have to be isomorphic. 
        // Case 2: The subtrees rooted at these nodes have been "Flipped" 
        return
        (isIsomorphic(n1.left, n2.left) &&  isIsomorphic(n1.right, n2.right)) 
        || (isIsomorphic(n1.left, n2.right) &&  isIsomorphic(n1.right, n2.left)); 
    } 
    
}    