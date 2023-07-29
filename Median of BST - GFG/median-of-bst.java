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
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Tree g = new Tree();
                float answer = g.findMedian(root);
                if(answer-(int)answer == 0)
        		    System.out.println((int)answer);
        		else
        		    System.out.println(answer);
                t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Tree
{
   public static int countNodes(Node n)
{
    // this function returns number of nodes in tree
    if(n==null) return 0;
    return 1 + countNodes(n.left) + countNodes(n.right);
}

public static int find(Node n, int serialNo, int target, int value[])
{
    // this function keeps track of serial number while doing
    // inorder traveresal and finds the target node
    
    if(n==null) return serialNo;
    serialNo = find(n.left, serialNo, target, value);
    
    serialNo++;
    // current value of serialNo variable is the rank of
    // current Node
    if(serialNo==target) value[0] = n.data;
    
    serialNo = find(n.right, serialNo, target, value);
    return serialNo;
}

public static float findMedian(Node root)
{
    int n = countNodes(root);
    
    if(n%2!=0)
    {
        // odd number of nodes in tree:
        // 1+n/2 is the rank of mid node
        
        int mid[] = new int[1];
        mid[0] = 0;
        find( root, 0, 1+n/2, mid );
        return (float)(mid[0]);
    }
    else
    {
        // even number of nodes in tree:
        // n/2 and 1+n/2 are the ranks of mid nodes
        
        int mid1[] = new int[1];
        int mid2[] = new int[1];
        mid1[0] = 0;
        mid2[0] = 0;
        find( root, 0, n/2, mid1 );
        find( root, 0, 1+n/2, mid2 );
        if( (mid1[0]+mid2[0])%2 == 0)
            return (float)(mid1[0]+mid2[0])/2;
        else    
            return ((float)(mid1[0]+mid2[0])/2);
    }
}
}