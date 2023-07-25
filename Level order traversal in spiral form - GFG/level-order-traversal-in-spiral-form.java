//{ Driver Code Starts
//Initial Template for Java



//Initial Template for Java

//Contributed by Sudarshan Sharma
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
    void inOrder(Node node) {
        if (node == null) {
            return;
        }
 
        inOrder(node.left);
        System.out.print(node.data + " ");
 
        inOrder(node.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Spiral g = new Spiral();
                ArrayList<Integer> result = g.findSpiral(root);
                for(int value : result)
                System.out.print(value + " ");
			    System.out.println();
    	        
	        }
	}
}




// } Driver Code Ends


//User function Template for Java


/*
// A Binary Tree node
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

class Spiral
{
    //Function to find the height of the tree.
		int height(Node node)
		{
			//base case for recursion.
			if(node==null)
				return 0;
			
			//finding height of left subtree recursively.
			int l = 1+height(node.left);
			
			//finding height of right subtree recursively.
			int r = 1+height(node.right);
			
			//taking the maximum as height of tree.
			if(l>r)
				return l;
			else
				return r;
		}
		
		
		//Function to do level order traversal of tree in spiral form.
		void printGivenLevel(ArrayList<Integer> result,Node node,int level,boolean ltr) 
		{
			//base case for recursion.
			if (node == null) 
				return;
			
			//if level is 1, we push the data in the list.
			if (level == 1) 
				result.add(node.data);
				
			
			else if (level > 1) 
			{
			    //if ltr is true, we call the spiral function recursively 
                //for the left subtrees first and then for right subtrees.
				if (ltr != false) 
				{
					printGivenLevel(result,node.left, level - 1, ltr);
					printGivenLevel(result,node.right, level - 1, ltr);
				} 
				//else we call for right subtrees first and then left subtrees.
				else
				{
					printGivenLevel(result,node.right, level - 1, ltr);
					printGivenLevel(result,node.left, level - 1, ltr);
				}
            }
		}
		
	
	    //Function to return a list containing the level order 
	    //traversal in spiral form.	
	    ArrayList<Integer>  findSpiral(Node node) 
        {
           ArrayList<Integer> result = new ArrayList<Integer>();
			if(node==null)
				return result;
			int h = height(node);
			int i;
			boolean ltr = false;
			//for each level, we do the spiral traversal.
			for (i = 1; i <= h; i++) 
			{
				printGivenLevel(result,node, i, ltr);
				ltr = !ltr;
			}
			//returning the list.
            return result;
		}
}