//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str)
    {
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
  
	public static void main (String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int t=Integer.parseInt(br.readLine());
            
            while(t > 0){
                String s = br.readLine();
                Node root = buildTree(s);
                
                int k=Integer.parseInt(br.readLine());
                
                Solution g = new Solution();
                System.out.println (g.kthLargest(root,k));
                t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution
{

    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root,int k)
    {
        //Your code here
        Node curr = root;
    Node Klargest = null;
 
    // count variable to keep count of visited Nodes
    int count = 0;
 
    while (curr != null)
    {
        // if right child is NULL
        if (curr.right == null)
        {
 
            // first increment count and check if count = k
            if (++count == k)
                Klargest = curr;
 
            // otherwise move to the left child
            curr = curr.left;
        }
 
        else
        {
 
            // find inorder successor of current Node
            Node succ = curr.right;
 
            while (succ.left != null && succ.left != curr)
                succ = succ.left;
 
            if (succ.left == null)
            {
 
                // set left child of successor to the
                // current Node
                succ.left = curr;
 
                // move current to its right
                curr = curr.right;
            }
 
            // restoring the tree back to original binary
            // search tree removing threaded links
            else
            {
 
                succ.left = null;
 
                if (++count == k)
                    Klargest = curr;
 
                // move current to its left child
                curr = curr.left;
            }
        }
    }
    return Klargest.data;
}
 
    }