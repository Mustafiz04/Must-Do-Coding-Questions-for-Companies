// { Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d; 
        next = null;
    }
}


class MergeLists
{
    Node head;



    /* Function to print linked list */
    public static void printList(Node head)
    {
        
        while (head!= null)
        {
            System.out.print(head.data+" ");
            head = head.next;
        }  
        System.out.println();
    }
    
        
    
        /* Driver program to test above functions */
    public static void main(String args[])
    {
        
            
        /* Constructed Linked List is 1->2->3->4->5->6->
            7->8->8->9->null */
            Scanner sc = new Scanner(System.in);
            int t=sc.nextInt();
            
            while(t>0)
            {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            Node head1 = new Node(sc.nextInt());
            Node tail1 = head1;
            for(int i=0; i<n1-1; i++)
            {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
            Node head2 = new Node(sc.nextInt());
            Node tail2 = head2;
            for(int i=0; i<n2-1; i++)
            {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
            
            LinkedList obj = new LinkedList();
            Node head = obj.sortedMerge(head1,head2);
            printList(head);
            
            t--;
            
            }
    }
}

class LinkedList{
    Node sortedMerge(Node headA, Node headB) {
        Node temp = new Node(0);
        Node curr = temp;
        
        Node n1 = headA;
        Node n2 = headB;
        
        while( n1 != null && n2 != null ){
            if( n1.data < n2.data ){
                curr.next = n1;
                n1 = n1.next;
            }else{
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }
        
        if( n1 != null ){
            curr.next = n1;
        }
        if( n2 != null ){
            curr.next = n2;
        }
        return temp.next;
    } 
}