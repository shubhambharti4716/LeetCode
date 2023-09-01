//{ Driver Code Starts
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
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	        Tree g = new Tree();
    	        g.printCorner(root);
                System.out.println();
	        }
	}
}





// } Driver Code Ends


//User function Template for Java

/* Node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Tree
{
    public static void printCorner(Node node)
    {
        //using a queue to perform level order traversal
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);
        q.add(null);
        
        boolean isFirst = false;
        boolean isOne = false;
        
        int last = 0;
        
        //iterating through the queue until it is empty
        while(q.isEmpty() != true)
        {
            Node temp = q.peek();
            q.poll();
            
            //printing the first node of each level
            if (isFirst == true)
		  {
			System.out.print(temp.data + " ");

			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);

			// make isFirst as false and one = 1
			isFirst = false;
			isOne = true;
		  }
		  //when encountering null, it means end of a level
		  else if(temp == null)
		  {
		      //if there are more nodes in the queue, add null for next level

		      if (q.size() >= 1)
				  q.add(null);

			
			isFirst = true;

				 
			if (isOne == false)
				System.out.print(last + " ");
		  }
		  else
		  {
		      last = temp.data;

			
			isOne = false;
			if (temp.left != null)
				q.add(temp.left);
			if (temp.right != null)
				q.add(temp.right);
		  }
		  
        }
    }
    
}