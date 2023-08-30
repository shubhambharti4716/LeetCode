//{ Driver Code Starts
import java.util.*;
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class DeleteNode
{
	Node head;
	void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	public void addToTheLast(Node node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   Node temp = head;
		   while (temp.next != null)
		   temp = temp.next;

		   temp.next = node;
		}}
	public static void main(String args[])
    {
       
         Scanner sc = new Scanner(System.in);
		 int t  =sc.nextInt();
		 
		 while(t>0)
         {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			DeleteNode llist = new DeleteNode();
			//int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			int x = sc.nextInt();
			//System.out.println(llist.head.data);
			  GfG g = new GfG(); 
			//System.out.println(k);
			//System.out.println(g.getNthFromLast(llist.head,k));
			Node result = g.deleteNode(llist.head, x);
			llist.printList(result);
		t--;
		}
	}
}
// } Driver Code Ends


/* Linklist node structure
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
/*You are required to complete below method*/
class GfG
{
	Node deleteNode(Node head, int x)
	{
		/*if(head == null)
			return null;	
		if(x==1)
		{
			Node temp = head;
			head = temp.next;
			return head;
		}else
		{
			Node temp = head;
			Node back = temp;;
			x--;
			while(temp != null && x>1)
			{
				back = temp;
				temp = temp.next;
				x--;
			}
			
			back.next = temp.next;
			return head;
		}*/
		if (head == null)
            return null;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (x == 1)
        {
            head = temp.next;   // Change head
            return head;
        }
 
      
		x--;
		//Node back;
        for (int i=1; temp!=null && i<x; i++)
		{
			//back = temp;
            temp = temp.next;
		}
 
        // If position is more than number of ndoes
        if (temp == null || temp.next == null)
            return null;
 
		if(temp.next.next == null)
			temp.next = null;
		else
			temp.next = temp.next.next;
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        //Node next = temp.next.next;
 
        //temp.next = next;  
		
		return head;
	}
}