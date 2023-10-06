//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Rearr
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t  =sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node temp = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                temp.next = new Node(a);
                temp = temp.next;
            }
            
            Solution ob = new Solution();
            ob.rearrange(head);
            printLast(head);
            System.out.println();
        }
    }
    
    public static void printLast(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}*/
class Solution
{
    public static void rearrange(Node odd) {
        // If the list has less than 3 nodes, no rearrangement needed
        if (odd == null || odd.next == null || odd.next.next == null)
            return;
        
        Node even = odd.next;
        // Rearrange the list by swapping nodes
        odd.next = odd.next.next;
        odd = odd.next;
        even.next = null;
        
        while (odd != null && odd.next != null) {
            // Swap nodes to rearrange the list
            Node temp = odd.next.next;
            odd.next.next = even;
            even = odd.next;
            odd.next = temp;
            
            // Move odd pointer to the next node
            if (temp != null)
                odd = temp;
        }
        
        // Connect the last node of odd list with the even list
        odd.next = even;
    }
}
