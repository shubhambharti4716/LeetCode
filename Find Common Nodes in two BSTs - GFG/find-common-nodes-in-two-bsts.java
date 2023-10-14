//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1, Node root2)  
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> stack1 = new Stack<Node> ();
        
        //creating two stacks for inorder traversals of both BST.
        Stack<Node> s1 = new Stack<Node> ();  
        Stack<Node> s2 = new Stack<Node> (); 

        while (true)
        {  
            //pushing the nodes of first BST in stack s1. 
            if (root1 != null)  
            {  
                s1.push(root1);  
                root1 = root1.left;  
            }  
            //pushing the nodes of second BST in stack s2.
            else if (root2 != null)  
            {  
                s2.push(root2);  
                root2 = root2.left;  
            }  
            //when both root1 and root2 become NULL 
            else if (!s1.isEmpty() && !s2.isEmpty())  
            {  
                root1 = s1.peek();  
                root2 = s2.peek();  
      
                //if data at current node in two BST's are same, we 
	    		//store it in output list.
                if (root1.data == root2.data)  
                {  
                    res.add(root1.data);
                    //popping element from both stacks.
                    s1.pop();  
                    s2.pop();  
      
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
                    root1 = root1.right;  
                    //root2 is set to NULL since we need new nodes of first BST.
                    root2 = null;  
                }  
                else if (root1.data > root2.data)  
                {  
                    //popping element from stack s2.
                    s2.pop();  
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


//{ Driver Code Starts.
class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends