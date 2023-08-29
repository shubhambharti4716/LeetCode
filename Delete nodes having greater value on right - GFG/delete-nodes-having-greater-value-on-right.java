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


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    
    Node compute(Node head)
    {
        // First reversed the linked list
    
        Node cur = head;
        Node prev = null;
        Node next;
    
        while(cur!=null)
        {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    
        head = prev;
    
        // Link list is reversed till here
    
        // Computing and deleting the nodes which have larger nodes
        // on the left
    
        Node current = head;
    
        Node maxNode = head;
        Node temp;
    
         while (current != null && current.next != null)
         {
             if(current.next.data < maxNode.data)
             {
                 temp = current.next;
                 current.next = temp.next;
                
             }
             else
             {
                 current = current.next;
                 maxNode= current;
             }
         }
         
         // reversing list again to get required result :-
         
         cur = head;
         prev = null;
        
         while(cur!=null)
         {
             next = cur.next;
             cur.next = prev;
             prev = cur;
             cur = next;
         }
    
         head = prev;
         
         // head of list can be returned now
    
        return head;
    
    }

    
}